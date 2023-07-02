package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;

public class TestOrder extends Order {

    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
        initDishes();
    }

    @Override
    protected void initDishes() {
        dishes = new ArrayList<>();
        Dish[] allDishes = Dish.values();
        int count = rnd(1, allDishes.length); //рандомное количество блюд для заказа
        for (int i = 0; i < count; i++) {
            Dish dish = allDishes[rnd(0, allDishes.length - 1)]; //создание рандомного блюда
            dishes.add(dish);
        }
    }

    /**
     * Метод получения псевдослучайного целого числа от min до max (включая max);
     */
    public static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
