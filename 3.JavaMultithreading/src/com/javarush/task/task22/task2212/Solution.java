package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) {
            return false;
        }
        return (telNumber.matches("^\\+(\\d[()]?){12}$") || telNumber.matches("^([()]?\\d){10}$"))
                && telNumber.matches("^(\\+)?(\\d+)?(\\(\\d{3}\\))?\\d+$");
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("(0)501234567")); // false
        System.out.println(checkTelNumber("050123456")); // false
        System.out.println(checkTelNumber("050ххх4567")); // false
        System.out.println(checkTelNumber("+38(050)123-45-67")); // false
        System.out.println(checkTelNumber("+38)050(1234567")); // false
        System.out.println();
        System.out.println(checkTelNumber("+380501234567")); // true
        System.out.println(checkTelNumber("+38(050)1234567")); // true
        System.out.println(checkTelNumber("(050)1234567"));// true
        System.out.println(checkTelNumber("0(501)234567"));// true
    }
}
