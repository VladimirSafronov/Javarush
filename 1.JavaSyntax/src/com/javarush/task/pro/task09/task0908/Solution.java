package com.javarush.task.pro.task09.task0908;

import java.util.Arrays;
import java.util.regex.Pattern;

/* 
Двоично-шестнадцатеричный конвертер
*/

public class Solution {
    private static final String HEX = "0123456789abcdef";

    public static void main(String[] args) {
        String binaryNumber = "100111010000";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
//        String hexNumber = "9d0";
//        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));

    }

    public static String toHex(String binaryNumber) {
        binaryNumber = catchNotBinaryNumber(binaryNumber);

        if (binaryNumber == null || binaryNumber.isEmpty()) {
            return "";
        }
        else {
            binaryNumber = isLengthMultipleFour(binaryNumber);

            int[] decimalBitsArray = toDecimalArray(binaryNumber);

            String hexNumber = "";
            for (int i = 0; i < decimalBitsArray.length; i++) {
                hexNumber = hexNumber + HEX.charAt(decimalBitsArray[i] % 16);
            }
        return hexNumber;
        }
    }

//    public static String toBinary(String hexNumber) {
//        if (hexNumber == null || hexNumber.isEmpty()) {
////            return "";
////        }
//        return null;
//    }

    public static String isLengthMultipleFour (String arg) {
        if (arg.length() % 4 == 3) {
            arg = "0" + arg;
        }
        else if (arg.length() % 4 == 2) {
            arg = "00" + arg;
        }
        else if (arg.length() % 4 == 1) {
            arg = "000" + arg;
        }
        return arg;
    }

    public static String catchNotBinaryNumber (String str) {
        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) == '0' || str.charAt(i) == '1') {
                i++;
            }
            else {
                str = "";
                break;
            }
        }
        return str;
    }

    public static int[] toDecimalArray (String arg) {
        int[] array = new int[arg.length() / 4];
        int argIndex = 0;
        for (int i = 0; i < array.length; i++) {
            int degree = array.length;
            for (int j = 0; j < 4; j++) {
                array[i] = array[i] + Integer.parseInt(String.valueOf(arg.charAt(argIndex))) * (int) Math.pow(2, degree);
                argIndex++;
                degree--;
            }
        }
        return array;
    }

}
