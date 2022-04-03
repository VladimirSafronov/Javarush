package com.javarush.task.pro.task16.task1604;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* 
День недели рождения твоего
*/

public class Solution {

    static Calendar birthDate = new GregorianCalendar(1987, 2, 13);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Calendar calendar) {
        String day = null;
        switch (calendar.get(Calendar.DAY_OF_WEEK))
        {
            case (1):
                day = "Воскресенье";
                break;
            case (2):
                day = "Понедельник";
                break;
            case (3):
                day = "Вторник";
                break;
            case (4):
                day = "Среда";
                break;
            case (5):
                day = "Четверг";
                break;
            case (6):
                day = "Пятница";
                break;
            case (7):
                day = "Суббота";
                break;
        }
        return day;
    }
}
