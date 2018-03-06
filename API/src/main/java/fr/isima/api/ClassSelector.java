package fr.isima.api;

import fr.isima.api.annotations.Prefered;
import fr.isima.api.exceptions.MultiplyPreferedClasses;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.reflections.Reflections;

public class ClassSelector {
  private static <T> List<Class> checkClass(Class<T> iface)
  {
    Set<Class<? extends T>> allClasses = new Reflections("").getSubTypesOf(iface);
    List<Class> subClasses = new ArrayList<>();
    for(Class<?> clazz : allClasses)
    {
      if(iface.isAssignableFrom(clazz))
      {
        subClasses.add(clazz);
      }
    }

    return subClasses;
  }

  @SuppressWarnings("unchecked")
  public static Class selectClass(Class iface) throws MultiplyPreferedClasses {
    Class clazz = null;
    List<Class> candidates = checkClass(iface);

    if(candidates.size() == 1)
    {
      clazz = candidates.get(0);
    }
    else
    {
      clazz = getPreferedClass(iface, candidates);
    }

    return clazz;
  }

  private static Class getPreferedClass(Class iface, List<Class> candidates)
      throws MultiplyPreferedClasses {
    Class clazz = null;

    for(Class candidate : candidates)
    {
      if(annotatedPrefered(candidate))
      {
        if(clazz == null)
        {
          clazz = candidate;
        }
        else
        {
          throw new MultiplyPreferedClasses("Multiple prefered implementations for "
              + iface.getName());
        }
      }
    }

    return clazz;
  }

  private static boolean annotatedPrefered(Class clazz)
  {
    return clazz.isAnnotationPresent(Prefered.class);
  }
}
