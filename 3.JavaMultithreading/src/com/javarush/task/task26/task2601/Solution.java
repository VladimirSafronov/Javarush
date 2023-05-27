package com.javarush.task.task26.task2601;

/*
Почитать в инете про медиану выборки
*/

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {
    }

    public static Integer[] sort(Integer[] array) {
        if (array.length == 0) {
            return array;
        }

        Comparator<Integer> comparator = Comparator.comparingInt(o -> o); //(o1, o2) -> o1 - o2;
        Arrays.sort(array, comparator);

        int med;
        int medIndex;
        if (array.length % 2 == 0) {
            med = (array[array.length / 2] + array[array.length / 2 - 1]) / 2;
            medIndex = array.length / 2 - 1;
        } else {
            med = array[array.length / 2];
            medIndex = array.length / 2;
        }

        Integer[] ans = new Integer[array.length];
        ans[0] = array[medIndex];
        int low = medIndex - 1;
        int high = medIndex + 1;
        int i = 1;
        while (low >= 0 && high < array.length) {
            if (med - array[low] <= array[high] - med) {
                ans[i] = array[low];
                low--;
            } else {
                ans[i] = array[high];
                high++;
            }
            i++;
        }

        while (low >= 0) {
            ans[i] = array[low];
            low--;
            i++;
        }
        while (high < array.length) {
            ans[i] = array[high];
            high++;
            i++;
        }

        return ans;
    }
}
