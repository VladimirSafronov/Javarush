package com.javarush.task.pro.task11.task1104;

/* 
Конвертер строки
*/

public class Solution {
    public static void main(String[] args) {
        String string = "12.84";
        double number = Double.parseDouble(string);
        int num = (int)Math.round(number);
        System.out.println(num);
    }
}
