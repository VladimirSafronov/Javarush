package com.javarush.task.task36.task3602;

/*
Найти класс по описанию Ӏ Java Collections: 6 уровень, 6 лекция
*/

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        for (Class<?> clazz : Collections.class.getDeclaredClasses()) {
            if (List.class.isAssignableFrom(clazz) &&
                    Modifier.isPrivate(clazz.getModifiers()) &&
                    Modifier.isStatic(clazz.getModifiers())) {
                try {
                    Constructor<?> constructor = clazz.getDeclaredConstructor();
                    return clazz;
                } catch (NoSuchMethodException ignored) {}
            }
        }
        return null;
    }


//    public static Class getExpectedClass() throws InstantiationException, IllegalAccessException {
//        Class[] clazz = Collections.class.getDeclaredClasses();
//        if (clazz.length > 0) {
//            for (Class c : clazz) {
//                int classModifiers = c.getModifiers();
//                if (List.class.isAssignableFrom(c)
//                        && isModifierSet(classModifiers, Modifier.PRIVATE)
//                        && isModifierSet(classModifiers, Modifier.STATIC)) {
//                    try {
//                        Method method = c.getDeclaredMethod("get", int.class);
//                        method.setAccessible(true);
//                        Constructor constructor = c.getDeclaredConstructor();
//                        constructor.setAccessible(true);
//
//                        method.invoke(constructor.newInstance(), 0);
//                    } catch (InvocationTargetException | NoSuchMethodException exception) {
//                        if (exception.getCause().toString().contains("IndexOutOfBoundsException")) {
//                            return c;
//                        }
//                    }
//                }
//            }
//        }
//        return null;
//    }
//
//    public static boolean isModifierSet(int allModifiers, int specificModifier) {
//        return (allModifiers & specificModifier) > 0;
//    }
}
