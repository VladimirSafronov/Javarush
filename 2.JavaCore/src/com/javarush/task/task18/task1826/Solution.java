package com.javarush.task.task18.task1826;

/*
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (FileInputStream input = new FileInputStream(args[1]);
             FileOutputStream output = new FileOutputStream(args[2])) {
            int aByte;
            if (args[0].equals("-e")) {
                while (input.available() > 0) {
                    aByte = input.read() + 1;
                    output.write(aByte);
                }
            }
            else if (args[0].equals("-d")) {
                while (input.available() > 0) {
                    aByte = input.read() - 1;
                    output.write(aByte);
                }
            }
        }

    }

}
