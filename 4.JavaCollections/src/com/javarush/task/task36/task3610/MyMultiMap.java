package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        int s = 0;
        for (V value : values()) {
            s++;
        }
        return s;
    }

    @Override
    public V put(K key, V value) {
        V ans = null;
        if (map.containsKey(key)) {
            int listSize = map.get(key).size();
            if (listSize == repeatCount) {
                map.get(key).remove(0);
                listSize--;
            }
            ans = map.get(key).get(listSize - 1);
            map.get(key).add(value);
        } else {
            List<V> newList = new ArrayList<>();
            newList.add(value);
            map.put(key, newList);
        }
        return ans;
    }

    @Override
    public V remove(Object key) {
        V ans = null;
        K k = (K) key;
        if (map.containsKey(k)) {
            ans = map.get(k).remove(0);
            if (map.get(k).size() == 0) {
                map.remove(k);
            }
        }
        return ans;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for (K key : map.keySet()) {
            keys.add(key);
        }
        return keys;
    }

    @Override
    public Collection<V> values() {
        Collection<V> collection = new ArrayList<>();
        for (K key : map.keySet()) {
            for (int i = 0; i < map.get(key).size(); i++) {
                collection.add(map.get(key).get(i));
            }
        }
        return collection;
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        V v = (V) value;
        for (K key : map.keySet()) {
            if (map.get(key).contains(v)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}