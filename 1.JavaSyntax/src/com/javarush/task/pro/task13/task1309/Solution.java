package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        grades.put("John", 4.5);
        grades.put("Bob", 4.4);
        grades.put("Mark", 3.5);
        grades.put("Alla", 4.0);
        grades.put("Nona", 2.5);
    }
}
