package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.logging.Level.SEVERE;

/**
 * Планшет клиента
 */
public class Tablet {
    private final int number; //номер планшета
    private LinkedBlockingQueue<Order> queue;
    public static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    /**
     * будет создавать заказ из тех блюд, которые выберет пользователь
     */
    public Order createOrder() {
        Order order = null;
        try {
            order = new Order(this);
            createAndStartAdvertisement(order);
        } catch (IOException e) {
            logger.log(SEVERE, "Console is unavailable.");
        }
        return order;
    }

    /**
     * будет создавать заказ из тех блюд, которые выберет пользователь
     */
    public void createTestOrder() {
        TestOrder order = null;
        try {
            order = new TestOrder(this);
            createAndStartAdvertisement(order);
        } catch (IOException e) {
            logger.log(SEVERE, "Test order didn't create.");
        }
    }

    private void createAndStartAdvertisement(Order order) {
        try {
            queue.put(order);
        } catch (InterruptedException e) {
        }
        ConsoleHelper.writeMessage(order.toString());
        AdvertisementManager advertisementManager =
                new AdvertisementManager(order.getTotalCookingTime() * 60); //создание объекта для рекламы
        try {
            advertisementManager.processVideos(); //запуск рекламы
        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}
