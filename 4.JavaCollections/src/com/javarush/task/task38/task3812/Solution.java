package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        if (!c.isAnnotationPresent(PrepareMyTest.class)) {
            return false;
        } else {
            PrepareMyTest myTest = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            for (String str : myTest.fullyQualifiedNames()) {
                System.out.println(str);
            }
            return true;
        }
    }

    public static boolean printValues(Class c) {
        if (!c.isAnnotationPresent(PrepareMyTest.class)) {
            return false;
        } else {
            PrepareMyTest myTest = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            for (Class clazz : myTest.value()) {
                System.out.println(clazz.getSimpleName());
            }
            return true;
        }
    }
}
