package impl;

import annotations.Prefered;
import exceptions.MultiplyPreferedClasses;
import exceptions.NoImplementationOfInterface;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.util.Set;

public class PreferedFinder {

    public static <T> Class<?> getPreferedClass(Class<T> interfaceClass) throws Exception{
        Class<?> value = null;
        Reflections reflections = new Reflections("");
        Set<Class<? extends T>> classes = reflections.getSubTypesOf(interfaceClass);
        int nbPrefered = 0;

        for(Class<?> classe : classes){
            if(classe.isAnnotationPresent(Prefered.class)){
                value = classe;
                nbPrefered++;
            }
        }

        if(nbPrefered > 1) throw new MultiplyPreferedClasses("More than one classes is annoted as prefered");
        else if(nbPrefered==0) throw new NoImplementationOfInterface("No implementation of the interface was found");



        return value;
    }
}
