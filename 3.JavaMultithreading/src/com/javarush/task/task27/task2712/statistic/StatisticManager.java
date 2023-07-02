package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

/*
При помощи данного класса будем регистрировать события в хранилище
 */
public class StatisticManager {
    private static volatile StatisticManager instance;
    private StatisticStorage statisticStorage = new StatisticStorage();
    private Set<Cook> cooks = new HashSet<>();

    private StatisticManager() {
    }

    public Set<Cook> getCooks() {
        return cooks;
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
        statisticStorage.put(data);
    }

    public void register(Cook cook) {
        cooks.add(cook);
    }

    /**
     * Высчитывает прибыль за рекламу по дням
     *
     * @return
     */
    public Map<String, Long> getDaysProfit() {
        Map<String, Long> daysProfit = new HashMap();
        List<EventDataRow> videoEvents = statisticStorage.get(EventType.SELECTED_VIDEOS);
        SimpleDateFormat formatter = getFormatter();
        long total = 0L;
        for (EventDataRow event : videoEvents) {
            VideoSelectedEventDataRow videoEvent = (VideoSelectedEventDataRow) event;
            String date = formatter.format(videoEvent.getDate());
            if (!daysProfit.containsKey(date)) {
                daysProfit.put(date, 0L);
            }
            total += videoEvent.getAmount();
            daysProfit.put(date, daysProfit.get(date) + videoEvent.getAmount());
        }

        daysProfit.put("Total", total);

        return daysProfit;
    }

    public Map<String, Map<String, Integer>> getCookerWork() {
        Map<String, Map<String, Integer>> allData = new HashMap<>();
        Map<String, Integer> cookerHours = new HashMap<>();
        List<EventDataRow> cookedEvents = statisticStorage.get(EventType.COOKED_ORDER);
        SimpleDateFormat formatter = getFormatter();
        for (EventDataRow event : cookedEvents) {
            CookedOrderEventDataRow cookEvent = (CookedOrderEventDataRow) event;
            String date = formatter.format(cookEvent.getDate());

            String cookerName = cookEvent.getCookName();
            int cookingTime = cookerHours.containsKey(cookerName) ?
                    cookerHours.get(cookerName) + cookEvent.getTime() : cookEvent.getTime();
            cookerHours.put(cookerName, cookingTime);
            allData.put(date, cookerHours);
        }
        return allData;
    }


    /**
     * Задаем паттерн вывода даты (он общий для всех)
     *
     * @return
     */
    private SimpleDateFormat getFormatter() {
        return new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
    }

    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage;

        public StatisticStorage() {
            this.storage = new HashMap<>();
            for (EventType eventType : EventType.values()) {
                storage.put(eventType, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            EventType eventType = data.getType();
            List<EventDataRow> list = storage.get(eventType);
            list.add(data);
            storage.put(eventType, list);
        }

        public List<EventDataRow> get(EventType eventType) {
            return storage.get(eventType);
        }
    }
}
