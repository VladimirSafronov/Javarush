package com.javarush.task.task27.task2712;


import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

public class Restaurant {
    private final static int ORDER_CREATING_INTERVAL = 100;

    public static void main(String[] args) {
        Cook cooker = new Cook("Cooker");
        Tablet tablet = new Tablet(1);
        tablet.addObserver(cooker);
        Waiter waiter = new Waiter();
        cooker.addObserver(waiter);
        tablet.createOrder();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
