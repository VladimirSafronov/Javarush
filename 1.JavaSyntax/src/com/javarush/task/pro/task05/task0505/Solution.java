package com.javarush.task.pro.task05.task0505;

import java.util.Scanner;

/* 
Reverse
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if (n > 0)
        {
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++)
            {
                numbers[i] = scan.nextInt();
            }
            if (n % 2 != 0)
            {
                for (int i = 0; i < numbers.length; i++)
                {
                    System.out.println(numbers[i]);
                }
            }
            else
                for (int i = numbers.length - 1; i >= 0; i--)
                {
                    System.out.println(numbers[i]);
                }
        }
    }
}
