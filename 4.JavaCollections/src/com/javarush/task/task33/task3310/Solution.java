package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(), 10000);
        testStrategy(new OurHashMapStorageStrategy(), 10000);
        testStrategy(new FileStorageStrategy(), 500);
        testStrategy(new OurHashBiMapStorageStrategy(), 10000);
        testStrategy(new HashBiMapStorageStrategy(), 10000);
        testStrategy(new DualHashBidiMapStorageStrategy(), 10000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> totalSet = new HashSet<>();
        for (String str : strings) {
            totalSet.add(shortener.getId(str));
        }
        return totalSet;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> totalSet = new HashSet<>();
        for (Long key : keys) {
            totalSet.add(shortener.getString(key));
        }
        return totalSet;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());

        Set<String> randomStrings = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            randomStrings.add(Helper.generateRandomString());
        }

        Shortener shortener = new Shortener(strategy);
        Date startMethod = new Date();
        Set<Long> ids = Solution.getIds(shortener, randomStrings);
        Date finishMethod = new Date();
        Helper.printMessage(String.valueOf(finishMethod.getTime() - startMethod.getTime()));

        startMethod = new Date();
        Set<String> strings = Solution.getStrings(shortener, ids);
        finishMethod = new Date();
        Helper.printMessage(String.valueOf(finishMethod.getTime() - startMethod.getTime()));

        Helper.printMessage(isSetsSame(randomStrings, strings) ? "Тест пройден." : "Тест не пройден.");

    }

    private static boolean isSetsSame(Set<String> set1, Set<String> set2) {
        for (String str : set1) {
            if (!set2.remove(str)) {
                return false;
            }
        }
        return set2.isEmpty();
    }
}
