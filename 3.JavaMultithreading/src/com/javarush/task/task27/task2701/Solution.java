package com.javarush.task.task27.task2701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Избавляемся от меток
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        String substring = reader.readLine();

        if (isSubstringPresent(substring, string)) {
            System.out.println("String: \n" + substring + "\nis present in the string: \n" + string);
        } else {
            System.out.println("String: \n" + substring + "\nis not present in the string: \n" + string);
        }
    }

    static boolean isSubstringPresent(String substring, String string) {
        int subLength = substring.length();
        int subIndex = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == substring.charAt(subIndex)) {
                subIndex++;
                if (subIndex == subLength) {
                    return true;
                }
            } else {
                subIndex = 0;
            }
        }
        return false;
    }
}

