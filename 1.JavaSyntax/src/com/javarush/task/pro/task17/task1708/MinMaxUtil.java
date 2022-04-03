package com.javarush.task.pro.task17.task1708;


/* 
Минимальное и максимальное
*/

public class MinMaxUtil {
    public static int min(int a, int b) {
        return (a < b ? a : b);
    }

    public static int min(int a, int b, int c) {
        int min = a < b ? a : b;
        return Math.min(min, c);
    }

    public static int min(int a, int b, int c, int d) {
        int min = a < b ? a : b;
        min = Math.min(min, c);
        return Math.min(min, d);
    }

    public static int min(int a, int b, int c, int d, int e) {
        int min = a < b ? a : b;
        min = Math.min(min, c);
        min = Math.min(min, d);
        return Math.min(min, e);
    }

    public static int max(int a, int b) {
        return (a > b ? a : b);
    }

    public static int max(int a, int b, int c) {
        int max = a > b ? a : b;
        return Math.max(max, c);
    }

    public static int max(int a, int b, int c, int d) {
        int max = a > b ? a : b;
        max = Math.max(max, c);
        return Math.max(max, d);
    }

    public static int max(int a, int b, int c, int d, int e) {
        int max = a > b ? a : b;
        max = Math.max(max, c);
        max = Math.max(max, d);
        return Math.max(max, e);
    }
}
