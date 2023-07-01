package com.javarush.task.task27.task2712.ad;

/*
у каждого планшета будет свой объект менеджера, который будет подбирать оптимальный набор роликов и их
последовательность для каждого заказа. Он также будет взаимодействовать с плеером и отображать ролики.
 */

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds; //время приготовления пищи (время показа рекламы)
    private long maxAmount; //максимальная выгода
    private List<Advertisement> optimalVideoSet;
    private int totalTimeSecondsLeft;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
        this.totalTimeSecondsLeft = Integer.MAX_VALUE;
    }

    /**
     * Создание самого выгодного плейлиста (без повторяющихся и неоплаченных треков)
     */
    public void processVideos() {
        getOptimalVideoSet(new ArrayList<>(), timeSeconds, 0L); //вызываем рекурсивный метод
        //создаем событие
        VideoSelectedEventDataRow videoEvent = new VideoSelectedEventDataRow(optimalVideoSet, maxAmount, timeSeconds - totalTimeSecondsLeft);
        StatisticManager.getInstance().register(videoEvent); //и регестрируем его

        displayAdvertisement();
    }

    private void getOptimalVideoSet(List<Advertisement> totalList, int currentTimeSecondsLeft, long currentAmount) {
        if (currentTimeSecondsLeft < 0) { //пока время отведенное на рекламу не закончится
            return;
        } else if (currentAmount > maxAmount //если текущая стоимость больше, чем максимальная
                || currentAmount == maxAmount && (totalTimeSecondsLeft > currentTimeSecondsLeft //или они равны И общее оставшееся время больше текущего оставшегося времени
                || totalTimeSecondsLeft == currentTimeSecondsLeft && totalList.size() < optimalVideoSet.size())) { //или они равны И в данном списке рекламные ролики более длинные
            totalTimeSecondsLeft = currentTimeSecondsLeft;
            optimalVideoSet = totalList;
            maxAmount = currentAmount;
            if (currentTimeSecondsLeft == 0) { //время отведенное на рекламу закончилось
                return;
            }
        }

        List<Advertisement> tmp = getActualAdvertisements(); //получаем список проплаченных видео из БД
        tmp.removeAll(totalList); //удаляем все видео, находящиеся в оптимальном плейлисте
        for (Advertisement ad : tmp) {
            if (!ad.isActive()) continue; //продолжаем только с проплаченными видео
            List<Advertisement> currentList = new ArrayList<>(totalList); //создаем список на основе оптимального плейлиста
            currentList.add(ad); //и добавляем в него рекламны ролик
            //рекурсивно проходим по всем возможным вариантам
            getOptimalVideoSet(currentList, currentTimeSecondsLeft - ad.getDuration(), currentAmount + ad.getAmountPerOneDisplaying());
        }
    }

    private List<Advertisement> getActualAdvertisements() {
        List<Advertisement> advertisements = new ArrayList<>();
        for (Advertisement ad : storage.list()) {
            if (ad.isActive()) {
                advertisements.add(ad);
            }
        }
        return advertisements;
    }

    private void displayAdvertisement() {
        //если нет роликов для показа
        if (optimalVideoSet == null || optimalVideoSet.isEmpty()) {
            throw new NoVideoAvailableException();
        }
        //сортируем плейлист по цене за показ, затем по длинне ролика
        Collections.sort(optimalVideoSet, (o1, o2) -> {
            long bestAmount = o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying();
            return (int) (bestAmount != 0 ? bestAmount : o2.getDuration() - o1.getDuration());
        });

        for (Advertisement ad : optimalVideoSet) {
            ConsoleHelper.writeMessage(ad.toString());
            ad.revalidate(); //уменьшаем значение количества проплаченной рекламы
        }
    }
}
