package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        String fileName;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        }
        try (BufferedReader input = new BufferedReader(new FileReader(fileName))) {
            String[] line;
            String str;
            while (input.ready()) {
                int count = 0;
                str = input.readLine();
                line = str.split(" ");
                for (String word : line) {
                    if (words.contains(word)) {
                        count++;
                    }
                }
                if (count == 2) {
                    System.out.println(str);
                }
            }
        }
    }
}
