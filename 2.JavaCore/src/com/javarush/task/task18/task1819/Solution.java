package com.javarush.task.task18.task1819;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1;
        String file2;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = br.readLine();
            file2 = br.readLine();
        }

        byte[] buffer = new byte[1000];
        int sizeFile1 = 0;
        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(file1))) {
            while (input.available() > 0) {
                sizeFile1 = input.read(buffer);
            }
        }

        try (BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(file1));
        BufferedInputStream input = new BufferedInputStream(new FileInputStream(file2))) {
            while (input.available() > 0) {
                output.write(input.read());
            }
            output.write(buffer, 0, sizeFile1);
        }
    }
}
