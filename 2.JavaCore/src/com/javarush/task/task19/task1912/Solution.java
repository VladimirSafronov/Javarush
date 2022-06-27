package com.javarush.task.task19.task1912;

/*
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static String transform(String str) {
        Pattern pattern = Pattern.compile("te+?");
        Matcher matcher = pattern.matcher(str);
        return matcher.replaceAll("??");
    }

    public static void main(String[] args) {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(output);
        System.setOut(ps);

        testString.printSomething();
        String str = output.toString();
        System.setOut(originalOut);

        String answer = transform(str);
        System.out.println(answer);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
