package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        String fileName;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (!(fileName = br.readLine()).equals("exit")) {
                new ReadThread(fileName).start();
            }
        }

    }

    public static class ReadThread extends Thread {
        private String name;
        int[] bytes = new int[256];
        int symbol = 0;
        int theMostPopularByte;

        public ReadThread(String fileName) {
            this.name = fileName;
        }

        @Override
        public void run() {
            try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(this.name))) {
                while (input.available() > 0) {
                    bytes[input.read()]++;
                }

                for(int i = 0; i < bytes.length; i++) {
                    if (symbol < bytes[i]) {
                        symbol = bytes[i];
                        theMostPopularByte = i;
                    }
                }

                resultMap.put(this.name, theMostPopularByte);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
