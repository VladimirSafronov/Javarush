package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;

public class Cook extends Observable{
    private String name;
    private boolean busy;

    public Cook(String name) {
        this.name = name;
    }

    public boolean isBusy() {
        return busy;
    }

    @Override
    public String toString() {
        return name;
    }

    public void startCookingOrder(Order order) {
        this.busy = true;
        ConsoleHelper.writeMessage("Start cooking - " + order.dishes + ", cooking time " + order.getTotalCookingTime() + "min");
        try {
            Thread.sleep(order.getTotalCookingTime() * 10L); //имитация приготовления еды
        } catch (InterruptedException e) {
        }
        int totalCookingTimeSec = order.getTotalCookingTime() * 60; //переводим общее время приготовления в секунды
        StatisticManager.getInstance().register(
                new CookedOrderEventDataRow(order.getTablet().toString(), this.name, totalCookingTimeSec, order.getDishes()));

        //уведомляем оффицианта о готовности заказа
        setChanged();
        notifyObservers(order);
        this.busy = false;
    }
}
