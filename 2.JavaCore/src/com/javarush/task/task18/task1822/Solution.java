package com.javarush.task.task18.task1822;

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = br.readLine();
        }

        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(fileName));
             Scanner scan = new Scanner(input)) {
            String line;
            int indexId;
            while (scan.hasNext()) {
                line = scan.nextLine();
                indexId = line.indexOf(32);
                if (args[0].equals(line.substring(0, indexId))) {
                    System.out.println(line);
                    return;
                }
            }
        }
    }
}
