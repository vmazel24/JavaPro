package impl;

import annotations.Inject;

import java.lang.reflect.Field;

public class InjectorFactory {

    public static Object getValueToInject(Field f) throws Exception{
        Object value = null;
        if(f.isAnnotationPresent(Inject.class)) {
            if (!f.getType().isInterface()) {
                value = f.getType().newInstance();
            } else {
                value = PreferedFinder.getPreferedClass(f.getType()).newInstance();
            }
        }
        return value;
    }
}
