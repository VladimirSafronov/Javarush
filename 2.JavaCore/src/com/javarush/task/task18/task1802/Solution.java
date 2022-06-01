package com.javarush.task.task18.task1802;

/*
Минимальный байт
*/

import java.io.*;

public class Solution {
    public static int findMinBite(File f) throws IOException {
        FileInputStream input = new FileInputStream(f);
        int minBite = Integer.MAX_VALUE;
        while (input.available() > 0) {
            int data = input.read();
            if (data < minBite) {
                minBite = data;
            }
        }
        input.close();
        return minBite;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file1 = new File(reader.readLine());

        System.out.println(findMinBite(file1));
        reader.close();
    }
}
