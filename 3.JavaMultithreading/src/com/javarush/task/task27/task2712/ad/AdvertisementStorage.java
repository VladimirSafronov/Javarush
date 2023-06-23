package com.javarush.task.task27.task2712.ad;

//Хранилище рекламных роликов

public class AdvertisementStorage {
    private static volatile AdvertisementStorage instance;

    private AdvertisementStorage() {
    }

    public static AdvertisementStorage getInstance() {
        if (instance == null) {
            synchronized (AdvertisementStorage.class) {
                if (instance == null) {
                    instance = new AdvertisementStorage();
                }
            }
        }
        return instance;
    }
}
