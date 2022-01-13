package com.javarush.task.pro.task09.task0905;

import java.util.regex.Pattern;

/* 
Восьмеричный конвертер
*/

public class Solution {
    public static void main(String[] args) {
        int decimalNumber = 21;
        System.out.println("Десятичное число " + decimalNumber + " равно восьмеричному числу " + toOctal(decimalNumber));
        int octalNumber = 25;
        System.out.println("Восьмеричное число " + octalNumber + " равно десятичному числу " + toDecimal(octalNumber));
    }

    public static int toOctal(int decimalNumber) {
        int i = 0;
        int octalNum = 0;
        if (decimalNumber <= 0)
        {
            return 0;
        }
        else
        {
            while (decimalNumber != 0)
            {
                octalNum = octalNum + (decimalNumber % 8) * (int) Math.pow(10, i);
                decimalNumber = decimalNumber / 8;
                i++;
            }
            return octalNum;
        }
    }

    public static int toDecimal(int octalNumber) {
        int i = 0;
        int decimalNum = 0;
        if (octalNumber <= 0)
        {
            return 0;
        }
        else
        {
            while (octalNumber != 0)
            {
                decimalNum = decimalNum + (octalNumber % 10) * (int) Math.pow(8, i);
                octalNumber = octalNumber / 10;
                i++;
            }
            return decimalNum;
        }
    }
}
