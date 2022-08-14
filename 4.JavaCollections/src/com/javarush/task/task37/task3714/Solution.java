package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Древний Рим
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        Map<String, Integer> romanNumerals = new HashMap<>();
        romanNumerals.put("I", 1);
        romanNumerals.put("V", 5);
        romanNumerals.put("X", 10);
        romanNumerals.put("L", 50);
        romanNumerals.put("C", 100);
        romanNumerals.put("D", 500);
        romanNumerals.put("M", 1000);

        int result = 0;
        String number;
        int previous = 0;
        int current;
        for (int i = s.length() - 1; i >= 0; i--) { //идем с конца, чтобы находить случаи вычитания
            number = String.valueOf(s.charAt(i));
            if (romanNumerals.containsKey(number)) {
                current = romanNumerals.get(number);
                if (current >= previous) {
                    result += current;
                    previous = current;
                }
                else {
                    result -= current;
                }
            }
        }
        return result;
    }
}
