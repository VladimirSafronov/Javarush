package com.javarush.task.task14.task1420;

/*
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Введите первое число:");
//        int a = Integer.parseInt(scan.nextLine());
//        System.out.println("Введите второе число:");
//        int b = Integer.parseInt(scan.nextLine());
//
//        System.out.println(findNOD(a, b));
//    }
//
//    static int findNOD(int a, int b) {
//        int min = Math.min(a, b);
//        int max = Math.max(a, b);
//        int remains;
//
//        if (max % min == 0) {
//            return min;
//        } else
//            remains = max % min;
//        while (remains != 0) {
//            int temporary = remains;
//            remains = min % remains;
//            min = temporary;
//        }
//        return min;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        System.out.println(findNOD(a, b));
    }

    static int findNOD(int a, int b) {
        if (b == 0) {
            return a;
        }
        int x = a % b;

        return findNOD(b, x);
    }
}
