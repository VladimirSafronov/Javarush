package com.javarush.task.task18.task1804;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file1 = new File(reader.readLine());
        StringBuilder sb = new StringBuilder();
        int[] bytes = new int[256];

        FileInputStream input = new FileInputStream(file1);
        while (input.available() > 0) {
            bytes[input.read()] += 1;
        }
        input.close();

        int min = Integer.MAX_VALUE;
        for (int i : bytes) {
            if (i < min && i > 0) {
                min = i;
            }
        }

        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == min) {
                sb.append(i).append(" ");
            }
        }
        reader.close();
        System.out.print(sb.toString().trim());
    }
}
