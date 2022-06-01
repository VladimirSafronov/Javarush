package com.javarush.task.task18.task1801;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file1 = new File(reader.readLine());

        System.out.println(findMaxBite(file1));
        reader.close();
    }

    public static int findMaxBite(File f) throws IOException {
        FileInputStream input = new FileInputStream(f);
        int maxBite = 0;
        while (input.available() > 0) {
            int data = input.read();
            if (data > maxBite) {
                maxBite = data;
            }
        }
        input.close();
        return maxBite;
    }
}
