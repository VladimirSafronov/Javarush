package com.javarush.task.task19.task1910;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1;
        String file2;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = reader.readLine();
            file2 = reader.readLine();
        }

        try (BufferedReader input = new BufferedReader(new FileReader(file1));
             BufferedWriter output = new BufferedWriter(new FileWriter(file2))) {
            while (input.ready()) {
                output.write(input.readLine().replaceAll("\\p{P}", ""));
            }
        }
    }
}
