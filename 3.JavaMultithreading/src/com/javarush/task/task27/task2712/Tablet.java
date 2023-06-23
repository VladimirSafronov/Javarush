package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Logger;

import static java.util.logging.Level.SEVERE;

/**
 * Планшет клиента
 */
public class Tablet extends Observable {
    private final int number; //номер планшета
    public static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    /**
     * будет создавать заказ из тех блюд, которые выберет пользователь
     */
    public Order createOrder() {
        Order order = null;
        try {
            order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());
            AdvertisementManager advertisementManager =
                    new AdvertisementManager(order.getTotalCookingTime() * 60); //создание объекта для рекламы
            advertisementManager.processVideos(); //запуск рекламы
        } catch (IOException e) {
            logger.log(SEVERE, "Console is unavailable.");
        } finally {
            assert order != null;
            if (!order.isEmpty()) {
                setChanged();
                notifyObservers(order);
            }
        }
        return order;
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}
