package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderManager implements Observer {
    private LinkedBlockingQueue<Order> orderQueue;

    public OrderManager() {
        this.orderQueue = new LinkedBlockingQueue<>();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    for (Cook cook : StatisticManager.getInstance().getCooks()) {
                        if (!cook.isBusy() && !orderQueue.isEmpty()) {
                            try {
                                cook.startCookingOrder(orderQueue.take());
                            } catch (InterruptedException e) {
                            }
                        }
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    /**
     * Реализация паттерна Observer (OrderManager - слушатель)
     *
     * @param o   отправляет заказ (здесь - планшет)
     * @param arg сам заказ
     */
    @Override
    public void update(Observable o, Object arg) {
        orderQueue.add((Order) arg);
    }
}
