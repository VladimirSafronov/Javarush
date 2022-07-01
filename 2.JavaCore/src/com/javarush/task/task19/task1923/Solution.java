package com.javarush.task.task19.task1923;

/*
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader input = new BufferedReader(new FileReader(args[0]));
             BufferedWriter output = new BufferedWriter(new FileWriter(args[1]))) {
            StringBuilder sb = new StringBuilder();
            String[] str;
            while (input.ready()) {
                str = input.readLine().split(" ");
                for (String word : str) {
                    if (hasNumber(word)) {
                        sb.append(word).append(" ");
                    }
                }
            }
            output.write(sb.toString().trim());
        }
    }

    public static boolean hasNumber(String str) {
        return str.matches(".*\\d+.*");
    }
}
