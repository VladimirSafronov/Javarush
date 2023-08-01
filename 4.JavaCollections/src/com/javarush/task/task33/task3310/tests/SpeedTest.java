package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {
    
    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        Date startMethod = new Date();
        for (String str : strings) {
            ids.add(shortener.getId(str));
        }
        Date finishMethod = new Date();

        return finishMethod.getTime() - startMethod.getTime();
    }

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        Date startMethod = new Date();
        for (Long key : ids) {
            strings.add(shortener.getString(key));
        }
        Date finishMethod = new Date();

        return finishMethod.getTime() - startMethod.getTime();
    }

    @Test
    public void testHashMapStorage() {
        HashMapStorageStrategy strategy1 = new HashMapStorageStrategy();
        Shortener shortener1 = new Shortener(strategy1);
        HashBiMapStorageStrategy strategy2 = new HashBiMapStorageStrategy();
        Shortener shortener2 = new Shortener(strategy2);

        Set<String> origStrings = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }

        Set<Long> ids1 = new HashSet<>();
        Set<Long> ids2 = new HashSet<>();
        long timeGetIds1 = getTimeToGetIds(shortener1, origStrings, ids1);
        long timeGetIds2 = getTimeToGetIds(shortener2, origStrings, ids2);

        Assert.assertTrue(timeGetIds1 > timeGetIds2);

        long timeGetStr1 = getTimeToGetStrings(shortener1, ids1, new HashSet<>());
        long timeGetStr2 = getTimeToGetStrings(shortener2, ids1, new HashSet<>());

        Assert.assertEquals(timeGetStr1, timeGetStr2, 30);
    }
}
