package com.javarush.task.task18.task1818;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1;
        String file2;
        String file3;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = br.readLine();
            file2 = br.readLine();
            file3 = br.readLine();
        }

        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(file2));
        BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(file1))) {
            int data;
            while (input.available() > 0) {
                data = input.read();
                output.write(data);
            }
        }

        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(file3));
        BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(file1, true))) {
            int data;
            while (input.available() > 0) {
                data = input.read();
                output.write(data);
            }
        }
    }
}
