package com.javarush.task.pro.task05.task0508;

import java.util.Scanner;

/* 
Удаляем одинаковые строки
*/

public class Solution {
    public static String[] strings = new String[6];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < strings.length; i++)
        {
            strings[i] = scan.nextLine();
        }
        int[] isNull = new int[strings.length];

        for (int i = 0; i < strings.length - 1; i++)
        {
            boolean isEquals = false;
            for (int j = i + 1; j < strings.length; j++)
            {
                if (strings[i].equals(strings[j]))
                {
                    isNull[j] = 1;
                    isEquals = true;
                }
            }
            if (isEquals) isNull[i] = 1;
        }

        for (int i = 0; i < strings.length; i++)
        {
            if (isNull[i] == 1) strings[i] = null;
        }

        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i] + ", ");
        }
    }
}
