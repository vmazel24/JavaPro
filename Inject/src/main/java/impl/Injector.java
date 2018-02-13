package impl;

import annotations.Inject;

import java.lang.reflect.Field;

public class Injector {
    public static <T> void inject(T injected) throws Exception {
        Field[] attributes = injected.getClass().getDeclaredFields();
        for(Field f : attributes){
            f.setAccessible(true);
            if(f.isAnnotationPresent(Inject.class) && f.get(injected)==null){
                if(f.getType().isInterface()) {
                    f.set(injected, f.getType().newInstance());
                }
            }
        }
    }
}
