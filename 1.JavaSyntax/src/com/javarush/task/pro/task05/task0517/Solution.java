package com.javarush.task.pro.task05.task0517;

import java.util.Arrays;

/* 
Делим массив
*/

public class Solution {

    public static int[][] result = new int[2][];
    public static int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

    public static void main(String[] args) {
        int[] firstHalf;
        int[] secondHalf;
        if (array.length % 2 == 0)
        {
            firstHalf = Arrays.copyOfRange(array, 0, array.length / 2);
            secondHalf = Arrays.copyOfRange(array, array.length / 2, array.length);
        }
        else
        {
            firstHalf = Arrays.copyOfRange(array, 0, array.length / 2 + 1);
            secondHalf = Arrays.copyOfRange(array, array.length / 2 + 1, array.length);
        }

        result[0] = firstHalf;
        result[1] = secondHalf;

        System.out.println(Arrays.deepToString(result));
    }
}
