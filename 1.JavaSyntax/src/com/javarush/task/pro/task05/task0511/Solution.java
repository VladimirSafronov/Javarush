package com.javarush.task.pro.task05.task0511;

import java.util.Scanner;

/* 
Создаем двумерный массив
*/

public class Solution {
    public static int[][] multiArray;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        multiArray = new int[n][];

        for (int i = 0; i < n; i++)
        {
            multiArray[i] = new int[scan.nextInt()];
        }


    }
}
