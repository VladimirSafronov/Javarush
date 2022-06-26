package com.javarush.task.task19.task1908;

/*
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1;
        String file2;
        try (BufferedReader readerFileName = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = readerFileName.readLine();
            file2 = readerFileName.readLine();
        }

        try (BufferedReader input = new BufferedReader(new FileReader(file1));
             BufferedWriter output = new BufferedWriter(new FileWriter(file2))) {
            StringBuilder sb = new StringBuilder();
            Pattern pattern = Pattern.compile("\\b\\d+?\\b");
            String line = "";
            while (input.ready()) {
                line = input.readLine();
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    sb.append(line.substring(matcher.start(), matcher.end())).append(" ");
                }
            }
            line = sb.toString().trim();
            output.write(line);
        }
    }
}
