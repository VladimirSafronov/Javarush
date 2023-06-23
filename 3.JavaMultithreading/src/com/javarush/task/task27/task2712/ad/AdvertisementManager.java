package com.javarush.task.task27.task2712.ad;

/*
у каждого планшета будет свой объект менеджера, который будет подбирать оптимальный набор роликов и их
последовательность для каждого заказа. Он также будет взаимодействовать с плеером и отображать ролики.
 */

import com.javarush.task.task27.task2712.ConsoleHelper;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private int timeSeconds; //время приготовления пищи (время показа рекламы)

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        ConsoleHelper.writeMessage("calling processVideos method");
    }
}
