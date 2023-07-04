package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(2);
    }

    public void createExpression(int number) {
        List<Integer> grounds = getGrounds(number); //список оснований из троичной симметричной с.с.

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(number).append(" =");
        int ground = 1; //переменная для основания
        for (int i = 0; i < grounds.size(); i++) {
            if (grounds.get(i) == 1) {
                stringBuilder.append(" + ").append(ground);
            } else if (grounds.get(i) == -1) {
                stringBuilder.append(" - ").append(ground);
            }
            ground *= 3;
        }
        System.out.println(stringBuilder);
    }

    /**
     * Создание и заполнение списка оснований для троичной симметричной с.с.
     *
     * @param number
     * @return
     */
    private static List<Integer> getGrounds(int number) {
        List<Integer> grounds = new ArrayList<>();
        do {
            int remainder = number % 3;
            number /= 3;
            if (remainder == 2) {
                grounds.add(-1);
                number += 1;
            } else if (remainder == 1) {
                grounds.add(1);
            } else {
                grounds.add(0);
            }
        } while (number != 0);
        return grounds;
    }
}