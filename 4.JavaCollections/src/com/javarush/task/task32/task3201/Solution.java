package com.javarush.task.task32.task3201;

/*
Запись в существующий файл
*/

import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String... args) {
        String fileName = args[0];
        long number = Integer.parseInt(args[1]);
        String text = args[2];
        byte[] textByte = text.getBytes();

        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            if(number > raf.length()) {
                raf.seek(raf.length());
            } else {
                raf.seek(number);
            }
            raf.write(textByte);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
