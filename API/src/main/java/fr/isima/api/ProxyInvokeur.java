package fr.isima.api;

import fr.isima.api.exceptions.MultiplyPreferedClasses;
import fr.isima.api.handler.ComportmentInterface;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class ProxyInvokeur<T> implements InvocationHandler {

  private T object;

  private ProxyInvokeur(T object)
  {
    this.object = object;
  }

  @Override public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    Annotation[] annotations = object.getClass().getMethod(method.getName()).getAnnotations();
    List<Class> comportmentsClazzs = this.getComportmentsClasses(annotations);
    List<ComportmentInterface> comportments = this.getComportments(comportmentsClazzs);

    this.executeBefore(comportments);
    Object result = method.invoke(this.object, args);
    this.executeAfter(comportments);

    return result;
  }

  private List<Class> getComportmentsClasses(Annotation[] annotations) throws ClassNotFoundException {
    List<Class> result = new ArrayList<>();
    for(Annotation annotation : annotations)
    {
      Class clazz = getClass().getClassLoader().loadClass("fr.isima.api.handler." + annotation.annotationType().getSimpleName() + "Handler");
      result.add(clazz);
    }

    return result;
  }

  private void executeBefore(List<ComportmentInterface> comportments)
  {
    for(ComportmentInterface comportment : comportments)
    {
      comportment.before();
    }
  }

  private void executeAfter(List<ComportmentInterface> comportments)
  {
    for(ComportmentInterface comportment : comportments)
    {
      comportment.after();
    }
  }

  private List<ComportmentInterface> getComportments(List<Class> clazzs)
      throws IllegalAccessException, InstantiationException, MultiplyPreferedClasses {
    List<ComportmentInterface> comportments = new ArrayList<>();
    for(Class clazz : clazzs)
    {
      ComportmentInterface comportment = (ComportmentInterface) clazz.newInstance();
      Injector.inject(comportment);
      comportments.add(comportment);
    }

    return comportments;
  }

  @SuppressWarnings("unchecked")
  public static <T> T createProxy(T t, Class<? super T> interfaceType)
  {
    return (T) Proxy.newProxyInstance(interfaceType.getClassLoader(), new Class<?>[]{interfaceType}, new ProxyInvokeur<>(t));
  }
}
