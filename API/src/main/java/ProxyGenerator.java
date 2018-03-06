import exceptions.MultiplyPreferedClasses;
import handler.ProxyHandler;
import handler.SingletonHandler;

public class ProxyGenerator {

  @SuppressWarnings("unchecked")
  public static <T> T generate(Class<T> iface)
      throws MultiplyPreferedClasses, IllegalAccessException, InstantiationException {
    Class cls = ClassSelector.selectClass(iface);
    T proxyClass = null;
    if(cls != null)
    {
      if(SingletonHandler.checkSingleton(cls))
      {
        if(SingletonHandler.singletons.containsKey(cls))
        {
          proxyClass = (T) SingletonHandler.singletons.get(cls);
        }
        else
        {
          proxyClass = (T) createProxy(cls, iface);
          SingletonHandler.singletons.put(cls, proxyClass);
        }
      }
      else
      {
        proxyClass = (T) createProxy(cls, iface);
      }
    }

    return proxyClass;
  }

  @SuppressWarnings("unchecked")
  private static <T> T createProxy(Class cls, Class<? super T> iface)
      throws IllegalAccessException, InstantiationException, MultiplyPreferedClasses {
    Object o = cls.newInstance();
    Injector.inject(o);
    return ProxyHandler.<T>createProxy((T) o,iface);
  }
}
