package com.javarush.task.pro.task15.task1506;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Фейсконтроль
*/

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<String> lines = new ArrayList(Files.readAllLines(Paths.get(scanner.nextLine())));
            for (String str : lines) {
                System.out.println(str.replaceAll("[., ]", ""));
            }
        } catch (Exception e) {
            System.out.println("Something went wrong" + e);
        }
    }
}

