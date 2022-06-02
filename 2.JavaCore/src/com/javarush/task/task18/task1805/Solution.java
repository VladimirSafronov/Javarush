package com.javarush.task.task18.task1805;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        int[] bytes = new int[256];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file1 = new File(reader.readLine());
        reader.close();

        FileInputStream input = new FileInputStream(file1);
        while (input.available() > 0) {
            bytes[input.read()] += 1;
        }
        input.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] > 0) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}
