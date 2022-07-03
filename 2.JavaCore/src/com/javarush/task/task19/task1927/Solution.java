package com.javarush.task.task19.task1927;

/*
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(output);
        System.setOut(newOut);

        String[] lines;
        testString.printSomething();
        lines = output.toString().split("\n");

        System.setOut(originalOut);
        for (int i = 0; i < lines.length; i++) {
            if (i != 0 && i % 2 == 0) {
                System.out.println("JavaRush - курсы Java онлайн");
            }
            System.out.println(lines[i]);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
