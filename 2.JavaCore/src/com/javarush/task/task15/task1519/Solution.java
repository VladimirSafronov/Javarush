package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String str = reader.readLine();
            while (!(str.equals("exit"))) {
                try {
                    if (str.contains(".")) {
                        Double number = Double.parseDouble(str);
                        Solution.print(number);
                    } else {
                        int integer = Integer.parseInt(str);
                        if (integer > 0 && integer < 128) {

                            Solution.print((short) integer);
                        } else {
                            Solution.print(integer);
                        }
                    }
                } catch (NumberFormatException e) {
                    Solution.print(str);
                }
                str = reader.readLine();
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
