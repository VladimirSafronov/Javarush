package com.javarush.task.task19.task1914;

/*
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static String calculator(String[] exp) {
        StringBuilder sb = new StringBuilder();
        int firstNumber = Integer.parseInt(exp[0]);
        int secondNumber = Integer.parseInt(exp[2]);

        for (String s : exp) {
            sb.append(s).append(" ");
        }
        switch (exp[1]) {
            case "+":
                sb.append(firstNumber + secondNumber);
                break;
            case "-":
                sb.append(firstNumber - secondNumber);
                break;
            case "*":
                sb.append(firstNumber * secondNumber);
                break;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(output);
        System.setOut(ps);

        testString.printSomething();
        String[] expression = output.toString().trim().split(" ");
        System.setOut(originalOut);
        System.out.println(calculator(expression));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

