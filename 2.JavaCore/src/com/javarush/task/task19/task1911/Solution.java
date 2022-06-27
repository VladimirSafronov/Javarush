package com.javarush.task.task19.task1911;

/*
Ридер обертка
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(output);
        System.setOut(ps);

        testString.printSomething();
        String answer = output.toString();

        System.setOut(originalOut);
        System.out.println(answer.toUpperCase());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
