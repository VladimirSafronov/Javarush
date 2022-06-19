package com.javarush.task.task18.task1825;

/*
Собираем файл
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> files = new ArrayList<>();
        String fileName;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (!(fileName = reader.readLine()).equals("end")) {
                files.add(fileName);
            }
            Collections.sort(files);
            files.sort(Comparator.comparingInt(String::length)); //отсортировал коллекцию по part
        }

        fileName = files.get(0).substring(0, files.get(0).indexOf(".part"));
        try (BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(fileName, true))) {
            for (int i = 0; i < files.size(); i++) {
                try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(files.get(i)))) {
                    while (input.available() > 0) {
                        output.write(input.read());
                    }
                }
            }
        }
    }
}
