package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        SpecialThread st1 = new SpecialThread();
        Thread thread1 = new Thread(st1);
        list.add(thread1);

        SpecialThread st2 = new SpecialThread();
        Thread thread2 = new Thread(st2);
        list.add(thread2);

        SpecialThread st3 = new SpecialThread();
        Thread thread3 = new Thread(st3);
        list.add(thread3);

        SpecialThread st4 = new SpecialThread();
        Thread thread4 = new Thread(st4);
        list.add(thread4);

        SpecialThread st5 = new SpecialThread();
        Thread thread5 = new Thread(st5);
        list.add(thread5);
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
