package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static  {
        threads.add(new FirstThread());
        threads.add(new SecondThread());
        threads.add(new ThirdThread());
        threads.add(new FourthThread());
        threads.add(new FifthThread());
    }

    public static void main(String[] args) {
//        for (Thread t : threads) {
//            t.start();
//        }
    }

    public static class FirstThread extends Thread {
        @Override
        public void run() {
            while (!isInterrupted()) {}
        }
    }

    public static class SecondThread extends Thread {
        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class ThirdThread extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }
    }

    public static class FourthThread extends Thread implements Message {
        private boolean isRun = true;
        @Override
        public void run() {
            while (isRun) {
            }
        }

        @Override
        public void showWarning() {
            this.isRun = false;
        }
    }

    public static class FifthThread extends Thread {
        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                String str = reader.readLine();
                int sum = 0;
                while (!str.equals("N")) {
                    sum += Integer.parseInt(str);
                    str = reader.readLine();
                }
                System.out.println(sum);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
