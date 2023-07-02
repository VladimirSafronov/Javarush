package com.javarush.task.task27.task2712;


import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private final static int ORDER_CREATING_INTERVAL = 100;
    private final static int TABLET_COUNT = 5;
    private final static LinkedBlockingQueue<Order> ORDER_QUEUE = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        Cook cooker1 = new Cook("Amigo");
        cooker1.setQueue(ORDER_QUEUE);
        Cook cooker2 = new Cook("Bob");
        cooker2.setQueue(ORDER_QUEUE);

        List<Tablet> tablets = new ArrayList<>();
        for (int i = 1; i <= TABLET_COUNT; i++) {
            Tablet tablet = new Tablet(i);
            tablet.setQueue(ORDER_QUEUE);
            tablets.add(tablet);
        }

        Thread task = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        task.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        task.stop();

        Waiter waiter = new Waiter();
        cooker1.addObserver(waiter);
        cooker2.addObserver(waiter);

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
