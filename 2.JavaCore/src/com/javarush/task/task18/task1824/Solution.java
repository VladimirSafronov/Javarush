package com.javarush.task.task18.task1824;

/*
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                fileName = reader.readLine();
                try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(fileName))) {}
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(fileName);
        }
    }
}
