package com.javarush.task.task13.task1326;

/*
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {

        ArrayList<Integer> list = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in);
            InputStreamReader input = new InputStreamReader(new FileInputStream(scanner.nextLine()));
            BufferedReader buffer = new BufferedReader(input)) {

            while (buffer.ready()) {
                int i = Integer.parseInt(buffer.readLine());
                if (i % 2 == 0) {
                    list.add(i);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        Collections.sort(list, (i1, i2) -> i1.compareTo(i2));
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
