package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.*;

public class DirectorTablet {

    /**
     * Отображает какую сумму заработали на рекламе, группирует по дням
     */
    public void printAdvertisementProfit() {
        Map<String, Long> profitMap = StatisticManager.getInstance().getDaysProfit();
        List<String> list = new ArrayList<>(profitMap.keySet());
        Collections.sort(list);

        for (String key : list) {
            double amount = 1.0 * profitMap.get(key) / 100;
            System.out.println(key + " - " + String.format(Locale.ENGLISH, "%.2f", amount));
        }
    }

    /**
     * Отображает загрузку (рабочее время) повара, группирует по дням
     */
    public void printCookWorkloading() {
        Map<String, Map<String, Integer>> cookerHoursMap = StatisticManager.getInstance().getCookerWork();
        List<String> days = new ArrayList<>(cookerHoursMap.keySet());
        Collections.sort(days);
        for (String day : days) {
            Map<String, Integer> cookersWork = cookerHoursMap.get(day);
            ConsoleHelper.writeMessage(day);

            List<String> cookerNames = new ArrayList<>(cookersWork.keySet());
            Collections.sort(cookerNames);
            for (String cooker : cookerNames) {
                int workSec = cookersWork.get(cooker);
                if (workSec == 0) {
                    continue;
                }
                int workMin = workSec % 60 == 0 ? workSec / 60 : workSec / 60 + 1;
                ConsoleHelper.writeMessage(cooker + " - " + workMin + " min");
            }
            ConsoleHelper.writeMessage("");
        }
    }

    /**
     * Отображает список активных роликов и оставшееся количество показов по каждому
     */
    public void printActiveVideoSet() {
        for (Advertisement ad : StatisticAdvertisementManager.getInstance().getActiveOrNotAdvertisements(true)) {
            ConsoleHelper.writeMessage(ad.getName() + " - " + ad.getHits());
        }
    }

    /**
     * Отображает список неактивных роликов (с оставшемся количеством показов равным нулю)
     */
    public void printArchivedVideoSet() {
        for (Advertisement ad : StatisticAdvertisementManager.getInstance().getActiveOrNotAdvertisements(false)) {
            ConsoleHelper.writeMessage(ad.getName());
        }
    }
}
