package com.javarush.task.task27.task2702;

/* 
Нужный оператор
*/

public class Solution {
    public static void main(String args[]) {
        label:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j > i) {
                    continue;
                }
                System.out.print("S");
            }
            System.out.println();
        }
    }
}
