package com.javarush.task.task35.task3505;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static<T, V> Map convert(List<? extends Convertable<V>> list) {
        Map<V, T> result = new HashMap<>();
        for (Convertable<V> l : list) {
            result.put(l.getKey(), (T) l);
        }
        return result;
    }
}
