package fr.isima.api;

import fr.isima.api.annotations.Inject;
import fr.isima.api.exceptions.MultiplyPreferedClasses;
import java.lang.reflect.Field;

public class Injector {
  public static void inject(Object o)
      throws IllegalAccessException, MultiplyPreferedClasses, InstantiationException {
    Field[] fields = o.getClass().getDeclaredFields();
    for(Field field : fields)
    {
      if(field.isAnnotationPresent(Inject.class))
      {
        field.setAccessible(true);
        field.set(o, ProxyGenerator.generate(field.getType()));
      }
    }
  }
}
