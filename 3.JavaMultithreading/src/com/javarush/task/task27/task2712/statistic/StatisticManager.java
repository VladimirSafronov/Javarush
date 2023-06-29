package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.EventDataRow;

/*
При помощи данного класса будем регистрировать события в хранилище
 */
public class StatisticManager {
    private static volatile StatisticManager instance;

    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        if (instance == null) {
            synchronized (StatisticManager.class) {
                if (instance == null) {
                    instance = new StatisticManager();
                }
            }
        }
        return instance;
    }

    public void register(EventDataRow data) {
    }
}
