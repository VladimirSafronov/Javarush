package com.javarush.task.task18.task1817;

/*
Пробелы
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        int lettersCount = 0;
        int spacesCount = 0;
        int symbol;

        try (BufferedReader buffer = new BufferedReader(new FileReader(args[0]))) {
            while (buffer.ready()) {
                symbol = buffer.read();
                lettersCount++;
                if (symbol == 32) {
                    spacesCount++;
                }
            }
        }
        System.out.printf("%.2f", (float) spacesCount / lettersCount * 100);
    }
}
