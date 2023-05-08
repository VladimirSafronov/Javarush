package com.javarush.task.task34.task3404;

/*
Рекурсия для мат. выражения
*/

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recurse("sin(2*(-5+1.5*4)+28)", 0); // Expected output: 0.5 6
    }

    public void recurse(final String expression, int countOperation) {

        if (!hasBrackets(expression)) {
            Set<String> operations = new HashSet<>();
            operations.add("+");
            operations.add("-");
            operations.add("*");
            operations.add("/");
            operations.add("sin");
            operations.add("tan");
            operations.add("cos");
            operations.add("ˆ");


        }
    }

    public boolean hasBrackets(String str) {
        return str.contains(")");
    }

    public Solution() {
        //don't delete
    }
}
