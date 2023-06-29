package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer {
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Реализация паттерна Observer (повар - слушатель)
     * @param o отправляет заказ (здесь - планшет)
     * @param arg сам заказ
     */
    @Override
    public void update(Observable o, Object arg) {

        //регистрируем событие
        Order order = (Order) arg;
        ConsoleHelper.writeMessage("Start cooking - " + arg + ", cooking time " + order.getTotalCookingTime() + "min");
        int totalCookingTimeSec = order.getTotalCookingTime() * 60; //переводим общее время приготовления в секунды
        StatisticManager.getInstance().register(
                new CookedOrderEventDataRow(o.toString(), this.name, totalCookingTimeSec, order.getDishes()));

        //уведомляем оффицианта о готовности заказа
        setChanged();
        notifyObservers(arg);
    }
}
