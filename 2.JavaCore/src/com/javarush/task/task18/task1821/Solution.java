package com.javarush.task.task18.task1821;

/*
Встречаемость символов
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        int[] symbols = new int[128];
        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(args[0]))) {
            while (input.available() > 0) {
                symbols[input.read()]++;
            }
        }
        for(int i = 0; i < symbols.length; i++) {
            if (symbols[i] > 0) {
                System.out.printf("%c %d\n", i, symbols[i]);
            }
        }
    }
}
