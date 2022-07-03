package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;/*
Перевертыши
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader input = new BufferedReader(new FileReader(fileNameReader.readLine()))) {
            String line;
            while ((line = input.readLine()) != null) {
                sb.append(line);
                System.out.println(sb.reverse());
                sb = new StringBuilder();
            }
        }
    }
}
