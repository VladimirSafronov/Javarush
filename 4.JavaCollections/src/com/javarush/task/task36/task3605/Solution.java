package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/* 
Использование TreeSet
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Set<Character> numbers = new TreeSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            char symbol;
            while (reader.ready()) {
                symbol = (char) reader.read();
                if (Character.isLetter(symbol)) {
                    numbers.add(Character.toLowerCase(symbol));
                }
            }
        }

        numbers.stream().limit(5).forEach(System.out::print);
    }
}
