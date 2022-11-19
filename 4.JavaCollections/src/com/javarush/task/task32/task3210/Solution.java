package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String... args) {
        String fileName = args[0];
        long number = Long.parseLong(args[1]);
        String text = args[2];

        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {

            byte[] fileText = new byte[text.length()];
            raf.seek(number);
            raf.read(fileText, 0, text.length());

            String readFile = new String(fileText);
            long fileLength = raf.length();
            raf.seek(fileLength);

            if(readFile.equals(text)) {
                raf.write("true".getBytes());
            } else {
                raf.write("false".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
