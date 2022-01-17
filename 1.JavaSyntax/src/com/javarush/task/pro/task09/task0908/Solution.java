package com.javarush.task.pro.task09.task0908;

import java.util.Arrays;
import java.util.regex.Pattern;

/* 
Двоично-шестнадцатеричный конвертер
*/

public class Solution {
    private static final String HEX = "0123456789abcdef";
    private static final String BINARY = "01";

    public static void main(String[] args) {
        String binaryNumber = "101";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "5";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));

    }

    public static String toHex(String binaryNumber) {  //неправильно считает
        if (binaryNumber == null) return "";
        binaryNumber = catchOverNumber(binaryNumber, BINARY);
        if (binaryNumber.isEmpty()) return "";

        else {
            binaryNumber = isLengthMultipleFour(binaryNumber);
            System.out.println(binaryNumber);

            int[] decimalBitsArray = toDecimalArray(binaryNumber);
            System.out.println(Arrays.toString(decimalBitsArray));

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
            int decimalNumber = toDecimal(hexNumber);
            String binaryNum = "";
            while (decimalNumber != 0) {
                binaryNum = decimalNumber % 2 + binaryNum;
                decimalNumber /= 2;
            }
            return  binaryNum;
        }
    }

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

    public static String catchOverNumber (String str, String symbols) {
        for (int i = 0; i < str.length(); i++) {
            if (symbols.indexOf(str.charAt(i)) < 0) {
                str = "";
                break;
            }
        }
        return str;
    }

    public static int[] toDecimalArray (String arg) { //выдает некорректное значение при маленьком числе
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

    public static int toDecimal (String arg) {
        int length = arg.length();
        int decimalNum = 0;
        for (int i = 0; i < length; i++) {
            decimalNum = decimalNum + HEX.indexOf(arg.charAt(length - 1 - i)) * (int) Math.pow(16,i);
        }
        return decimalNum;
    }

}
