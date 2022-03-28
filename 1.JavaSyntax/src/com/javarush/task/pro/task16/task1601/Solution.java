package com.javarush.task.pro.task16.task1601;

import java.util.Calendar;
import java.util.Date;

/* 
Лишь бы не в понедельник :)
*/

public class Solution {

    static Date birthDate = new Date(61, 1, 27);//@Deprecated

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Date date) {
        String dayOfWeek = null;
        int day = date.getDay();
        switch (day)
        {
            case (1):
                dayOfWeek = "Понедельник";
                break;
            case (2):
                dayOfWeek = "Вторник";
                break;
            case (3):
                dayOfWeek = "Среда";
                break;
            case (4):
                dayOfWeek = "Четверг";
                break;
            case (5):
                dayOfWeek = "Пятница";
                break;
            case (6):
                dayOfWeek = "Суббота";
                break;
            case (0):
                dayOfWeek = "Воскресенье";
                break;
        }
        return dayOfWeek;
    }
}
