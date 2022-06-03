package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;/*
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream input = new FileInputStream(fileName);
        int count = 0;

        while (input.available() > 0) {
            if (input.read() == 44) {
                count++;
            }
        }

        System.out.println(count);
        reader.close();
        input.close();
    }
}
