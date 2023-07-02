package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

public class Waiter implements Observer {

    /**
     * Реализация паттерна Observer (Waiter - слушатель)
     *
     * @param o   отправляет заказ (здесь - Cook)
     * @param arg сам заказ
     */
    @Override
    public void update(Observable o, Object arg) {
        ConsoleHelper.writeMessage(arg + " was cooked by " + o);
    }
}
