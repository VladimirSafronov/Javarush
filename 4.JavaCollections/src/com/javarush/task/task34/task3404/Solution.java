package com.javarush.task.task34.task3404;

/*
Рекурсия для мат. выражения
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recurse("sin(2*(-5+1.5*4)+28)", 0); // Expected output: 0.5 6
    }

    public void recurse(final String expression, int countOperation) {
        if (expression.equals("")) {

        }
    }

    public Solution() {
        //don't delete
    }
}
