package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    FISH,
    STEAK,
    SOUP,
    JUICE,
    WATER;

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
