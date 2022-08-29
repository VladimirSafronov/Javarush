package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/

public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null || string.isEmpty()) {
            throw new Solution.TooShortStringException();
        }
        String answer = "";
        try {
            int startString = string.indexOf("\t") + 1;
            int endString = string.indexOf("\t", startString);
            answer = string.substring(startString, endString);
        } catch (Exception e) {
            throw new Solution.TooShortStringException();
        }
        return answer;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
