package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
При помощи данного класса будем регистрировать события в хранилище
 */
public class StatisticManager {
    private static volatile StatisticManager instance;
    private StatisticStorage statisticStorage = new StatisticStorage();

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

    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage;

        public StatisticStorage() {
            this.storage = new HashMap<>();
            for (EventType eventType : EventType.values()) {
                storage.put(eventType, new ArrayList<EventDataRow>());
            }
        }
    }
}
