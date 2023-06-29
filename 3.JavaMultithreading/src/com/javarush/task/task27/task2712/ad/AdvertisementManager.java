package com.javarush.task.task27.task2712.ad;

/*
у каждого планшета будет свой объект менеджера, который будет подбирать оптимальный набор роликов и их
последовательность для каждого заказа. Он также будет взаимодействовать с плеером и отображать ролики.
 */

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.NoAvailableVideoEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private int timeSeconds; //время приготовления пищи (время показа рекламы)

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    //Метод подбора самого выгодного рекламного плейлиста. Используется динамическое программирование (задача о рюкзаке)
    public void processVideos() {
        if (storage.list().size() == 0) {
            StatisticManager.getInstance().register(new NoAvailableVideoEventDataRow(timeSeconds));
            throw new NoVideoAvailableException();
        }

        int totalVideos = storage.list().size();
        int[][] priceMatrix = new int[totalVideos + 1][timeSeconds + 1]; //в значении будет храниться цена плейлиста
        fillMatrix(priceMatrix, totalVideos, timeSeconds);
        List<Integer> currentList = new ArrayList<>();
        List<List<Integer>> allLists = new ArrayList<>();
        allLists.add(currentList);
        restoreItemList(priceMatrix, totalVideos, timeSeconds, currentList, allLists);

        List<Advertisement> videos = new ArrayList<>();
        for (Integer i : currentList) {
            videos.add(storage.list().get(i - 1));
        }

        videos.sort((o1, o2) -> {
            long price = o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying();
            return (int) (price != 0 ? price : o2.getDuration() - o1.getDuration());
        });

        registerEvent(videos); //регистрируем событие

        for (Advertisement ad : videos) {
            ConsoleHelper.writeMessage(ad.toString());
            ad.revalidate();
        }
    }

    private void registerEvent(List<Advertisement> videos) {
        long amount = 0;
        int totalDuration = 0;
        for (Advertisement ad : videos) {
            amount += ad.getAmountPerOneDisplaying();
            totalDuration += ad.getDuration();
        }
        StatisticManager.getInstance().register(new VideoSelectedEventDataRow(
                videos, amount, totalDuration));
    }

    private void restoreItemList(int[][] matrix, int s, int n, List<Integer> currentList, List<List<Integer>> allLists) {
        //мы пойдем с конца матрицы к ее началу
        if (matrix[s][n] == 0) { //если плейлист ничего не стоит
            return;
        } else if (matrix[s - 1][n] == matrix[s][n]) { //если цены без текущего видео и с ним равны
            //если цена ролика выше, чем у предыдущего
            if (n >= storage.list().get(s - 1).getDuration()
                    && storage.list().get(s - 1).getAmountPerOneDisplaying() > storage.list().get(s - 2).getAmountPerOneDisplaying()) {
                List<Integer> newList = new ArrayList<>(currentList);
                allLists.add(newList);
                newList.add(s);
                //вызываем рекурсию с предыдущим видео,уменьшенным временем плейлиста, и новым списком
                restoreItemList(matrix, s - 1, n - storage.list().get(s - 1).getDuration(), newList, allLists);
            }
            restoreItemList(matrix, s - 1, n, currentList, allLists);
        } else {
            currentList.add(s);
            restoreItemList(matrix, s - 1, n - storage.list().get(s - 1).getDuration(), currentList, allLists);
        }
    }

    private void fillMatrix(int[][] matrix, int totalVideos, int totalTime) {
        for (int k = 1; k <= totalVideos; k++) {
            for (int s = 1; s <= totalTime; s++) { //вместимость плейлиста
                if (s >= storage.list().get(k - 1).getDuration()) { //если продолжительность оставшегося плейлиста >= длине рекламного ролика
                    //то выбираем более прибыльное - цена плейлиста без текущего ролика либо с ним
                    matrix[k][s] = Math.max(matrix[k - 1][s],
                            matrix[k - 1][s - storage.list().get(k - 1).getDuration()] + (int) storage.list().get(k - 1).getAmountPerOneDisplaying()); //?но ведь цена всегда должна быть выше
                } else {
                    matrix[k][s] = matrix[k - 1][s];
                }
            }
        }
    }
}
