package com.javarush.task.task18.task1816;

/*
Английские буквы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(args[0]))) {
            int engLettersCount = 0;
            int letter;
            while (input.available() > 0) {
                letter = input.read();
                if ((letter > 64 && letter < 91) || (letter > 96 && letter < 123)) {
                    engLettersCount++;
                }
            }
            System.out.println(engLettersCount);
        }
    }
}
