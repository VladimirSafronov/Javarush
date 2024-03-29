package com.javarush.task.task30.task3001;

/*
Конвертер систем счислений
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumberSystemType._10, "6");
        Number result = convertNumberToOtherNumberSystem(number, NumberSystemType._2);
        System.out.println(result);    //expected 110

        number = new Number(NumberSystemType._16, "6df");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._8);
        System.out.println(result);    //expected 3337

        number = new Number(NumberSystemType._16, "abcdefabcdef");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._16);
        System.out.println(result);    //expected abcdefabcdef
    }

    public static Number convertNumberToOtherNumberSystem(Number number, NumberSystem expectedNumberSystem) {
        //создание BigInteger в заданной системе счисления
        BigInteger integer = new BigInteger(number.getDigit(), number.getNumberSystem().getNumberSystemIntValue());
        //создание Number с необходимой с.с.
        return new Number(expectedNumberSystem, integer.toString(expectedNumberSystem.getNumberSystemIntValue()));
    }
}
