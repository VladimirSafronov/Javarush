package com.javarush.task.task19.task1919;

/*
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) throws IOException {
        Map<String, Double> salary = new TreeMap<>();
        String[] data = new String[2];
        try (BufferedReader input = new BufferedReader(new FileReader(args[0]))) {
            while (input.ready()) {
                data = input.readLine().split(" ");
                if (salary.containsKey(data[0])) {
                    salary.put(data[0], (salary.get(data[0]) + Double.parseDouble(data[1])));
                } else {
                    salary.put(data[0], Double.parseDouble(data[1]));
                }
            }
        }
        for (String name : salary.keySet()) {
            System.out.println(name + " " + salary.get(name));
        }
    }
}
