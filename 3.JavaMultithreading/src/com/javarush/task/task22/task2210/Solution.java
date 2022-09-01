package com.javarush.task.task22.task2210;

/*
StringTokenizer
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution.getTokens("level22.lesson13.task01", ".")));

    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        List<String> answer = new ArrayList<>();

        while (tokenizer.hasMoreTokens()) {
            answer.add(tokenizer.nextToken());
        }

        return answer.toArray(new String[0]);
    }
}
