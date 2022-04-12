package com.javarush.task.task13.task1319;

/*
Писатель в файл с консоли
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = new Scanner(System.in).nextLine();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                String line;
                while (!(line = reader.readLine()).equals("exit")) {
                    writer.write(line + "\n");
                }
                writer.write(line);
                writer.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            reader.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
