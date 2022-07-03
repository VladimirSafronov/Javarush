package com.javarush.task.task19.task1925;

/*
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String[] line;
        StringBuilder sb = new StringBuilder();
        try (BufferedReader input = new BufferedReader(new FileReader(args[0]))) {
            while (input.ready()) {
                line = input.readLine().split(" ");
                for (String word : line) {
                    if (word.length() > 6) {
                        sb.append(word).append(",");
                    }
                }
            }
            sb.deleteCharAt(sb.length() - 1);
        }

        try (BufferedWriter output = new BufferedWriter(new FileWriter(args[1]))) {
            output.write(sb.toString());
        }
    }
}
