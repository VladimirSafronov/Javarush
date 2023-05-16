package com.javarush.task.task25.task2502;

import java.util.LinkedList;
import java.util.List;

/* 
Машину на СТО не повезем!
*/

public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels here
            wheels = new LinkedList<>();
            int wheelsCount = 4;
            if (loadWheelNamesFromDB().length != wheelsCount) {
                throw new IllegalArgumentException();
            }
            for (int i = 0; i < wheelsCount; i++) {
                String wheelName = String.valueOf(loadWheelNamesFromDB()[i]);
                wheels.add(i, Wheel.valueOf(wheelName));
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
    }
}
