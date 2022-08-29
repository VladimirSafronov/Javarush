package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {

        if (string == null) {
            throw new TooShortStringException();
        }
        StringBuilder answer = new StringBuilder();
        String[] words = string.split(" ");
        try {
            for (int i = 1; i <= 4; i++) {
                answer.append(words[i]).append(" ");
            }
        } catch (Exception e) {
            throw new TooShortStringException();
        }
        return answer.toString().trim();
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
