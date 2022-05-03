package com.javarush.task.task15.task1529;

/*
Осваивание статического блока
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

    }

    static {
        reset();
    }

    public static CanFly result;

    public static void reset() throws IllegalArgumentException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str = reader.readLine();
            if (str.equals("helicopter")) {
                result = new Helicopter();
            }
            else if (str.equals("plane")) {
                int n = Integer.parseInt(reader.readLine());
                result = new Plane(n);
            }
//            switch (str) {
//                case "plane" -> {
//                    int n = Integer.parseInt(reader.readLine());
//                    result = new Plane(n);
//                }
//                case "helicopter" -> result = new Helicopter();
//            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
