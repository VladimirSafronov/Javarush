package com.javarush.task.pro.task08.task0803;

import java.util.Scanner;

/* 
Минимальный элемент массива
*/

public class Main {
    public static int a = 41;
    public static int c = 11119;
    public static int m = 11113;
    public static int seed = 1;

    public static int getNextRandom()
    {
        seed = (a * seed + c) % m;
        return seed;
    }

    public static void main(String[] args)
    {
        for (int i = 0; i < 100; i++)
        {
            System.out.println(getNextRandom());
        }
    }
}
