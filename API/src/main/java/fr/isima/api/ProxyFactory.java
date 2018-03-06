package fr.isima.api;

import fr.isima.api.exceptions.MultiplyPreferedClasses;
import fr.isima.api.SingletonManager;

public class ProxyFactory {

  @SuppressWarnings("unchecked")
  public static <T> T generate(Class<T> iface)
      throws MultiplyPreferedClasses, IllegalAccessException, InstantiationException {
    Class cls = ClassSelector.selectClass(iface);
    T proxyClass = null;
    if(cls != null)
    {
      if(SingletonManager.checkSingleton(cls))
      {
        if(SingletonManager.singletons.containsKey(cls))
        {
          proxyClass = (T) SingletonManager.singletons.get(cls);
        }
        else
        {
          proxyClass = (T) createProxy(cls, iface);
          SingletonManager.singletons.put(cls, proxyClass);
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
    return ProxyInvokeur.<T>createProxy((T) o,iface);
  }
}
