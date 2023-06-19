package com.javarush.task.task28.task2807;

import java.util.concurrent.LinkedBlockingQueue;/*
Знакомство с ThreadPoolExecutor
*/
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Runnable> tasksQueue = new LinkedBlockingQueue<>();
        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            tasksQueue.add(new Runnable() {
                @Override
                public void run() {
                    doExpensiveOperation(finalI);
                }
            });
        }

        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(3, 5, 1000, TimeUnit.MILLISECONDS, tasksQueue);
        executor.prestartAllCoreThreads();
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        /* Example output
pool-1-thread-2, localId=2
pool-1-thread-3, localId=3
pool-1-thread-1, localId=1
pool-1-thread-3, localId=5
pool-1-thread-2, localId=4
pool-1-thread-3, localId=7
pool-1-thread-1, localId=6
pool-1-thread-3, localId=9
pool-1-thread-2, localId=8
pool-1-thread-1, localId=10
         */
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }
}
