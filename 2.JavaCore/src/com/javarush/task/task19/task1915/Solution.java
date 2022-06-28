package com.javarush.task.task19.task1915;

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(output);
        System.setOut(ps);

        String fileName;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        }

        testString.printSomething();
        System.setOut(originalOut);

        String text = output.toString();
        System.out.println(text);
         try (FileOutputStream fos = new FileOutputStream(fileName)) {
             fos.write(output.toByteArray());
         }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

