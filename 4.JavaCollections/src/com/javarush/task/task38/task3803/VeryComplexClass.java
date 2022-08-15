package com.javarush.task.task38.task3803;

/*
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object obj = 10;
        String str = (String) obj;
    }

    public void methodThrowsNullPointerException() {
        Integer s = null;
        int b = 10 + s;
    }

    public static void main(String[] args) {
        VeryComplexClass vcc = new VeryComplexClass();
        vcc.methodThrowsNullPointerException();
    }
}
