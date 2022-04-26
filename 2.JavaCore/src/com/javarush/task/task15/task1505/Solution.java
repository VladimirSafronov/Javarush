package com.javarush.task.task15.task1505;

/* 
ООП - исправь ошибки в наследовании
*/

public class Solution {
    public interface HasWeight {
        int getWeight();
    }

    public interface HasHeight {
        int getHeight();
    }

    public static class Human implements HasWeight, HasHeight {
        final double max = 101;
        final double min = 10;

        public int rnd(double min, double max) {
            max -= min;
            return (int) (Math.random() * max + min);
        }

        @Override
        public int getHeight() {
            return rnd(min, max);
        }

        @Override
        public int getWeight() {
            return rnd(min, max);
        }
    }

        public static void main(String[] args) {
        Human human = new Human();
        System.out.println(human.getHeight());
        System.out.println(human.getWeight());
    }
}