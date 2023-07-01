package com.javarush.task.task27.task2712;

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
            double amount = 1.0 * profitMap.get(key) / 100; //переводим заработок из копеек в рубли
            ConsoleHelper.writeMessage(key + " - " + String.format("%.2f", amount)); //оставляем 2 знака после точки
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
                if (workSec == 0) { //не выводим на экран если повар не работал в этот день
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

    }

    /**
     * Отображает список неактивных роликов (с оставшемся количеством показов равным нулю)
     */
    public void printArchivedVideoSet() {

    }
}
