package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* 
Знакомство с properties
*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        if (!runtimeStorage.isEmpty()) {
            Properties properties = new Properties();
            properties.putAll(runtimeStorage);
            properties.store(outputStream, "");
        }
    }

    public static void load(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            while (reader.ready()) {
                properties.load(reader);
            }
            Set<String> keys = properties.stringPropertyNames();
            for (String key : keys) {
                runtimeStorage.put(key, properties.getProperty(key));
            }
        }

//        properties.load(inputStream);
//        Map convert = properties;
//        runtimeStorage = (Map<String, String>) convert;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);
    }
}
