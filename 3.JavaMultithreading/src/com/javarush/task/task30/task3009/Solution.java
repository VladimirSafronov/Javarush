package com.javarush.task.task30.task3009;

import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number) {
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i <= 36; i++) {
            try {
                int integer = Integer.parseInt(number, 10); //переводим аргумент в int в 10 с.с.
                String num = Integer.toString(integer, i); //переводим полученное выше значение в i-ую с.с.
                if (isPalindrome(num)) {
                    set.add(i);
                }
            } catch (NumberFormatException e) {
            }
        }
        return set;
    }

    private static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}