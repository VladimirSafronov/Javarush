package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    FISH(25),
    STEAK(30),
    SOUP(15),
    JUICE(5),
    WATER(3);

    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString() {
        StringBuilder allDishes = new StringBuilder();
        for (Dish d : Dish.values()) {
            allDishes.append(d.toString()).append(", ");
        }
        allDishes.delete(allDishes.lastIndexOf(","), allDishes.length());
        allDishes.append(".");
        return allDishes.toString();
    }
}
