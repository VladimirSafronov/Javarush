package com.javarush.task.pro.task05.task0509;

/* 
Таблица умножения
*/

public class Solution {

    public static int[][] MULTIPLICATION_TABLE;

    public static void main(String[] args) {
        int length = 10;
        MULTIPLICATION_TABLE = new int[length][length];

        for (int i = 0; i < length; i++)
        {
            for (int j = 0; j < length; j++)
            {
                MULTIPLICATION_TABLE[i][j] = (i + 1) * (j + 1);
            }
        }

        for (int i = 0; i < length; i++)
        {
            for (int j = 0; j < length; j++)
            {
                System.out.print(MULTIPLICATION_TABLE[i][j] + " ");
            }
            System.out.println();
        }
    }
}
