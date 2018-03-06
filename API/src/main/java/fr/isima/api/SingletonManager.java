package fr.isima.api;

import fr.isima.api.annotations.Singleton;
import java.util.HashMap;
import java.util.Map;

public class SingletonManager {

  public static Map<Class<?>, Object> singletons = new HashMap<>();

  public static <T> boolean checkSingleton (Class<T> clazz)
  {
   return clazz.isAnnotationPresent(Singleton.class);
  }
}
