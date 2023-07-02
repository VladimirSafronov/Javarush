package com.javarush.task.task27.task2712;


import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private final static int ORDER_CREATING_INTERVAL = 100;
    private final static int TABLET_COUNT = 5;

    public static void main(String[] args) {
        Cook cooker1 = new Cook("Amigo");
        Cook cooker2 = new Cook("Bob");
        StatisticManager statisticManager = StatisticManager.getInstance();
        statisticManager.register(cooker1); //добавляем повара во множество поваров
        statisticManager.register(cooker2);

        List<Tablet> tablets = new ArrayList<>();
        for (int i = 1; i <= TABLET_COUNT; i++) {
            Tablet tablet = new Tablet(i);
            tablet.addObserver(cooker1); //добавление повара в качестве наблюдателя за планшетом
            tablet.addObserver(cooker2);
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
