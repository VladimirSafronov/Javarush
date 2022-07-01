package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        String line;
        String[] data;
        String name;
        Date birthday;
        try (BufferedReader input = new BufferedReader(new FileReader(args[0]))) {
            while (input.ready()) {
                line = input.readLine();
                data = line.split(" ");
                name = findName(data);
                birthday = new Date(Integer.parseInt(data[data.length - 1]) - 1900,
                             Integer.parseInt(data[data.length - 2]) - 1,
                                    Integer.parseInt(data[data.length - 3]));
                PEOPLE.add(new Person(name, birthday));
            }
        }
    }

    public static String findName(String[] data) {
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < data.length - 3; i++) {
            name.append(data[i]).append(" ");
        }
        return name.toString().trim();
    }
}
