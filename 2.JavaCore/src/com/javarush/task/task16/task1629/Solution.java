package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Только по-очереди!
*/

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final int THREE = 3;

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();

        t1.start();
        t1.join();
        t2.start();
        t2.join();

        t1.printResult();
        t2.printResult();
    }

    public static class Read3Strings extends Thread {
        ArrayList <String> strings = new ArrayList<>();

        @Override
        public void run() {
            for (int i = 0; i < THREE; i++) {
                try {
                    strings.add(reader.readLine());
                } catch (IOException e) {
                    System.out.println("Ошибка ввода");
                }
            }
        }

        public void printResult() {
            String str = "";
            for (int i = 0; i < THREE; i++) {
                str += strings.get(0) + " ";
                strings.remove(0);
            }
            System.out.println(str.trim());
        }
    }
}
