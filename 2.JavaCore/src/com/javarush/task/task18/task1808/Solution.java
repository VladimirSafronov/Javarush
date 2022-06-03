package com.javarush.task.task18.task1808;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
//        String file1 = "/Users/vladimirsafronov/Desktop/file.txt";
//        String file2 = "/Users/vladimirsafronov/Desktop/file2.txt";
//        String file3 = "/Users/vladimirsafronov/Desktop/file3.txt";
        reader.close();

        try (FileInputStream input = new FileInputStream(file1);
             FileOutputStream firstOutput = new FileOutputStream(file2);
             FileOutputStream secondOutput = new FileOutputStream(file3)) {
            int totalSize = input.available();
            int file3Size = totalSize/2;
            int file2Size = totalSize - file3Size;

            byte[] buffer = new byte[totalSize];
            while (input.available() > 0) {
                input.read(buffer);
                firstOutput.write(buffer, 0, file2Size);
                secondOutput.write(buffer, file2Size, file3Size);
            }
        }
    }
}
