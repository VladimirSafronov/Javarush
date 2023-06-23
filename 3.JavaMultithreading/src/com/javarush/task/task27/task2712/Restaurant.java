package com.javarush.task.task27.task2712;


import com.javarush.task.task27.task2712.kitchen.Cook;

public class Restaurant {
    public static void main(String[] args) {
        Cook cooker = new Cook("Cooker");
        Tablet tablet = new Tablet(1);
        tablet.addObserver(cooker);
        tablet.createOrder();

    }
}
