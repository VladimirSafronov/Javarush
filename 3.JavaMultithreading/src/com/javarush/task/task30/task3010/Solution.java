package com.javarush.task.task30.task3010;

/*
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        String output = "incorrect";
        for (int i = 2; i < 37; i++) {
            BigInteger integer = null;
            try {
                integer = new BigInteger(args[0], i);
            } catch (Exception e) {
            }
            if (integer != null) {
                output = String.valueOf(i);
                break;
            }
        }
        System.out.println(output);
    }
}