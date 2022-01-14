package com.javarush.task.pro.task09.task0907;

import java.util.regex.Pattern;

/* 
Шестнадцатеричный конвертер
*/

public class Solution {
    private static final String HEX = "0123456789abcdef";

    public static void main(String[] args) {
        int decimalNumber = 1256;
        System.out.println("Десятичное число " + decimalNumber + " равно шестнадцатеричному числу " + toHex(decimalNumber));
        String hexNumber = "4e8";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно десятичному числу " + toDecimal(hexNumber));
    }

    private static String toHex(int decimalNumber) {
        String hexNum = "";
        if (decimalNumber <= 0)
        {
            return "";
        }
        else
        {
            while (decimalNumber != 0)
            {
                hexNum = HEX.charAt(decimalNumber % 16) + hexNum;
                decimalNumber /= 16;
            }
            return hexNum;
        }
    }

    private static int toDecimal(String hexNumber) {
        int decimalNum = 0;
        if (hexNumber == null || hexNumber.isEmpty())
        {
            return 0;
        }
        else
        {
            int length = hexNumber.length();
            for (int i = 0; i < length; i++)
            {
                decimalNum = decimalNum + getCharIndexFromHEX(hexNumber.charAt(length - 1 - i)) * (int) Math.pow(16,i);
            }
            return decimalNum;
        }
    }

    /**
     * Собственная реализация библиотечной функции indexOf
     * @param symbol
     * @return
     */
    public static int getCharIndexFromHEX(char symbol) {
        int i = 0;
        while (i < HEX.length()) {
            if (HEX.charAt(i) == symbol) break;
            else i++;
        }
        return i;
    }
}
