package com.javarush.task.pro.task09.task0916;

/* 
String.format()
*/

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        String str = "abcdefg";
        char[] charArr = str.toCharArray();
        System.out.println(Arrays.toString(charArr));

        char c = str.charAt(4);
        System.out.println(c);

        String s = Character.toString(c);
        System.out.println(s);

        String sr = "dkugn3jfnvh3nfj333";
        String srWithout = sr.replaceAll(Character.toString('3'), "_");
        System.out.println(srWithout);
    }
}


