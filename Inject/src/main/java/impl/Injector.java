package impl;

import java.lang.reflect.Field;

public class Injector {

    public static <T> void doInjections(T injected) throws Exception {

        Field[] attributes = injected.getClass().getDeclaredFields();

        for(Field f : attributes){
            Object value = InjectorFactory.getValueToInject(f); //InjectorFactory
            f.setAccessible(true);
            f.set(injected, value);
            //Injector.doInjections(value);
        }
    }
}
