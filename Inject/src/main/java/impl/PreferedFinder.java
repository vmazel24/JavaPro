package impl;

import annotations.Prefered;
import exceptions.MultiplyImplementationWithoutPrefered;
import exceptions.MultiplyPreferedClasses;
import exceptions.NoImplementationOfInterface;
import org.reflections.Reflections;

import java.util.Set;

public class PreferedFinder {

    public static <T> Class<?> getPreferedClass(Class<T> interfaceClass) throws Exception{

        Reflections reflections = new Reflections("");
        Set<Class<? extends T>> classes = reflections.getSubTypesOf(interfaceClass);

        if(classes.size()==0) throw new NoImplementationOfInterface("No implementation of the interface was found");

        int nbPrefered = 0;
        Class<?> value = null;
        Class<?> lastImpl = null;
        for(Class<?> classe : classes){
            if(classe.isAnnotationPresent(Prefered.class)){
                value = classe;
                nbPrefered++;
            }
            lastImpl = classe;
        }

        if(nbPrefered > 1) throw new MultiplyPreferedClasses("More than one class that implements "+interfaceClass.getName()+" is annoted as prefered");
        else if(nbPrefered==0 && classes.size()>1) throw new MultiplyImplementationWithoutPrefered("More than one class implement "+interfaceClass.getName()+". Use the annotation @Prefered");
        else if(nbPrefered==0) value=lastImpl;


        return value;
    }
}
