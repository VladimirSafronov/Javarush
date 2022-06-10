package com.javarush.task.task18.task1820;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1 = null;
        String file2 = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = br.readLine();
            file2 = br.readLine();
        }

        String[] numbers;
        try (BufferedReader buffer = new BufferedReader(new FileReader(file1))) {
            StringBuilder sb = new StringBuilder();
            while (buffer.ready()) {
                sb.append(buffer.readLine());
            }
            numbers = sb.toString().split(" ");
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file2))) {
            StringBuilder sb = new StringBuilder();
            int number;
            for(int i = 0; i < numbers.length; i++) {
                number = (int) Math.round(Double.parseDouble(numbers[i]));
                sb.append(number).append(" ");
            }
            writer.write(sb.toString().trim());
        }
    }
}
