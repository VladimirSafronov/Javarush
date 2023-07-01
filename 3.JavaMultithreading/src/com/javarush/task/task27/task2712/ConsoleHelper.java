package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    ;

    /**
     * вывод строки в консоль
     */
    public static void writeMessage(String message) {
        System.out.println(message);
    }

    /**
     * чтение строки с консоли
     */
    public static String readString() throws IOException {
        return reader.readLine();
    }

    /**
     * просит пользователя выбрать блюдо и добавляет его в список заказа.
     * Введенное 'exit' означает завершение заказа.
     *
     * @return заказ пользователя
     */
    public static List<Dish> getAllDishesForOrder() throws IOException {
        writeMessage(Dish.allDishesToString());
        List<Dish> menu = new ArrayList<>();
        menu.addAll(Arrays.asList(Dish.values()));
        List<Dish> orderList = new ArrayList<>();
        String order;
        writeMessage("Введите блюдо: ");
        while (!(order = reader.readLine()).equals("exit")) {
            writeMessage("Введите блюдо: ");
            try {
                if (menu.contains(Dish.valueOf(order.toUpperCase(Locale.ROOT)))) {
                    orderList.add(Dish.valueOf(order.toUpperCase(Locale.ROOT)));
                }
            } catch (IllegalArgumentException e) {
                writeMessage("Такого блюда нет.");
            }
        }
        return orderList;
    }
}
