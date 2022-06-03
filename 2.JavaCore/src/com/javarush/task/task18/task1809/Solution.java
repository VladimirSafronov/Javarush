package com.javarush.task.task18.task1809;

/*
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
//        String file1 = "/Users/vladimirsafronov/Desktop/file.txt";
//        String file2 = "/Users/vladimirsafronov/Desktop/file2.txt";


        try (FileInputStream input = new FileInputStream(file1);
             FileOutputStream output = new FileOutputStream(file2)) {
            int fileSize = input.available();
            byte[] buffer = new byte[fileSize];
            input.read(buffer);
            for (int i = fileSize - 1; i >= 0; i--) {
                output.write(buffer[i]);
            }
        }
    }
}
