package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;/*
Самый богатый
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, Double> salary = new HashMap<>();
        String[] line = new String[2];
        String key;
        double value;
        double max = 0;
        StringBuilder sb = new StringBuilder();;
        try (BufferedReader input = new BufferedReader(new FileReader(args[0]))) {
            while (input.ready()) {
                line = input.readLine().split(" ");
                key = line[0];
                value = Double.parseDouble(line[1]);
                if (salary.containsKey(key)) {
                    salary.put(key, salary.get(key) + value);
                } else {
                    salary.put(key, value);
                }

                if (max < salary.get(key)) {
                    sb = new StringBuilder();
                    sb.append(key).append(" ");
                    max = salary.get(key);
                } else if (max == salary.get(key)) {
                    sb.append(key).append(" ");
                }
            }
        }
        System.out.println(sb.toString().trim());
    }
}
