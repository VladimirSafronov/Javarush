package com.javarush.task.task13.task1318;

/*
Чтение файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {

        try {
            Scanner scanner = new Scanner(System.in);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(scanner.nextLine()));
            BufferedReader buffer = new BufferedReader(reader);

            while (buffer.ready()) {
                String str = buffer.readLine();
                System.out.println(str);
            }

            buffer.close();
            reader.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}