package com.javarush.task.task19.task1907;

/*
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        String fileName;
        int count = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = br.readLine();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                for(String str : reader.readLine().split("\\W")) {
                    if (str.equals("world")) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
