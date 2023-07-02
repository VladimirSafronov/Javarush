package com.javarush.task.task27.task2712.ad;

import java.util.*;

//Класс будет предоставлять информацию из AdvertisementStorage в нужном нам виде
public class StatisticAdvertisementManager {
    private static volatile StatisticAdvertisementManager instance;
    public final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager() {
    }

    public static StatisticAdvertisementManager getInstance() {
        if (instance == null) {
            synchronized (StatisticAdvertisementManager.class) {
                if (instance == null) {
                    instance = new StatisticAdvertisementManager();
                }
            }
        }
        return instance;
    }

    /**
     * Создает список с оплаченной или не оплаченной рекламой
     *
     * @param isActive указывет какого типа список составлять
     * @return
     */
    public List<Advertisement> getActiveOrNotAdvertisements(boolean isActive) {
        List<Advertisement> list = new ArrayList<>();
        for (Advertisement ad : storage.list()) {
            if (isActive) {
                if (ad.isActive()) {
                    list.add(ad);
                }
            } else {
                if (!ad.isActive()) {
                    list.add(ad);
                }
            }
        }
        Collections.sort(list, Comparator.comparing(ad -> ad.getName().toLowerCase()));

        return list;
    }
}
