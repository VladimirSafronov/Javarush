package com.javarush.task.task19.task1906;

/*
Четные символы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1;
        String file2;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = bufferedReader.readLine();
            file2 = bufferedReader.readLine();
        }

        try (FileReader reader = new FileReader(file1);
             FileWriter writer = new FileWriter(file2)) {
            List<Integer> buffer = new ArrayList<>();
            while (reader.ready()) {
                buffer.add(reader.read());
            }
            for(int i = 0; i < buffer.size(); i++) {
                if(i % 2 != 0) {
                    writer.write(buffer.get(i));
                }
            }
        }
    }
}
