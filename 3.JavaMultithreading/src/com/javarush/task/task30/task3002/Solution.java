package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        int notation = 0; //хранит систему счисления
        if (s.charAt(0) != '0') {
            notation = 10;
        } else if (s.startsWith("0x")) {
            notation = 16;
            s = s.substring(2);
        } else if (s.startsWith("0b")) {
            notation = 2;
            s = s.substring(2);
        } else if (s.charAt(0) == '0') {
            notation = 8;
        }
        return String.valueOf(Integer.parseInt(s, notation));
    }
}
