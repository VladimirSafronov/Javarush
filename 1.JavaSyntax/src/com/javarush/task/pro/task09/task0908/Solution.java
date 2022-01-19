package com.javarush.task.pro.task09.task0908;

import java.util.Arrays;
import java.util.regex.Pattern;

/* 
Двоично-шестнадцатеричный конвертер
*/

public class Solution {
    private static final String HEX = "0123456789abcdef";
    private static final String BINARY = "01";
    private static final int BLOCK = 4;

    public static void main(String[] args) {
        String binaryNumber = "110111101111";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));

    }

    public static String toHex(String binaryNumber) {
        if (binaryNumber == null) return "";
        binaryNumber = catchOverNumber(binaryNumber, BINARY);
        if (binaryNumber.isEmpty()) return "";

        else {
            binaryNumber = isLengthMultipleFour(binaryNumber);

            int[] decimalBitsArray = fillDecimalArray(binaryNumber);

            String hexNumber = "";
            for (int i = 0; i < decimalBitsArray.length; i++) {
                hexNumber = hexNumber + HEX.charAt(decimalBitsArray[i] % 16);
            }
        return hexNumber;
        }
    }

    public static String toBinary(String hexNumber) {
        if (hexNumber == null) return "";
        hexNumber = catchOverNumber(hexNumber, HEX);
        if (hexNumber.isEmpty()) return "";

        else {
            int[] decimalNumbers = getDecimalArrayFromHexNumber(hexNumber);
            return getBinaryFromDecimalArray(decimalNumbers);
        }
    }

    public static String isLengthMultipleFour (String arg) {
        if (arg.length() % BLOCK == 3) {
            arg = "0" + arg;
        }
        else if (arg.length() % BLOCK == 2) {
            arg = "00" + arg;
        }
        else if (arg.length() % BLOCK == 1) {
            arg = "000" + arg;
        }
        return arg;
    }

    public static String catchOverNumber (String str, String symbols) {
        for (int i = 0; i < str.length(); i++) {
            if (symbols.indexOf(str.charAt(i)) < 0) {
                str = "";
                break;
            }
        }
        return str;
    }

    public static int[] fillDecimalArray (String arg) {
        int[] array = new int[arg.length() / BLOCK];
        for (int i = 0; i < array.length; i++) {
            array[i] = toDecimalFromBinary(arg, i);
        }
        return array;
    }

    public static int toDecimalFromBinary (String arg, int number) {
        int argIndex = number * BLOCK;
        int total = 0;
        for (int i = 3; i >= 0; i--) {
            total = total + Integer.parseInt(String.valueOf(arg.charAt(argIndex))) * (int) Math.pow(2, i);
            argIndex++;
        }
        return total;
    }

    public static int[] getDecimalArrayFromHexNumber (String hex) {
        int[] array = new int[hex.length()];
        for (int i = 0; i < hex.length(); i++) {
            array[i] = Integer.parseInt(String.valueOf(HEX.indexOf(hex.charAt(i))));
        }
        return array;
    }

    public static String getBinaryFromDecimalArray (int[] array) {

        String binaryNum = "";
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 0) {
                binaryNum = "0000";
            }
            else
                while (array[i] != 0) {
                    binaryNum = array[i] % 2 + binaryNum;
                    array[i] /= 2;
                }
            binaryNum = isLengthMultipleFour(binaryNum);
        }
        return binaryNum;
    }
}
