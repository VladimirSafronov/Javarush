package com.javarush.task.task26.task2603;

/*
Убежденному убеждать других не трудно
*/

import java.util.Comparator;

public class Solution {

    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator... comparators) {
            this.comparators = comparators;
        }

        @Override
        public int compare(T o1, T o2) {
            int result = 0;
            int i = 0;
            while (result == 0 && i < comparators.length) {
                result = comparators[i].compare(o1, o2);
                i++;
            }
            return result;
        }
    }

    public static void main(String[] args) {

    }
}
