package com.javarush.task.task18.task1803;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static String findMaxBiteRepeat(File f) throws IOException {
        Map<Integer, Integer> bites = new HashMap<>();
        FileInputStream input = new FileInputStream(f);

        while (input.available() > 0) {
            int data = input.read();
            if (bites.isEmpty() || !bites.containsKey(data)) {
                bites.put(data, 1);
            }
            else {
                bites.put(data, bites.get(data) + 1);
            }
        }
        input.close();

        int maxRep = 1;
        for (int value : bites.values()) {
            if (value > maxRep) {
                maxRep = value;
            }
        }

        StringBuilder ans = new StringBuilder();
        for (Map.Entry<Integer, Integer> pair : bites.entrySet()) {
            if (pair.getValue() == maxRep) {
                ans.append(pair.getKey()).append(" ");
            }
        }
        return ans.toString().trim();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file1 = new File(reader.readLine());
        System.out.println(findMaxBiteRepeat(file1));
        reader.close();
    }
}
