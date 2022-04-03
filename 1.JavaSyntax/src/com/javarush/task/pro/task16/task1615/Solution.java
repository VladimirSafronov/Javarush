package com.javarush.task.pro.task16.task1615;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

/* 
Ой как много методов!
*/

public class Solution {
    private final static int MINUTE = 60;
    private final static int HOUR = 3600;
    private final static int DAY = 86400;

    public static void main(String[] args) {
        Instant instant = Instant.ofEpochSecond(10);
        System.out.println(instant);
        System.out.println(plusMinutes(instant, 2));
        System.out.println(plusHours(instant, 2));
        System.out.println(plusDays(instant, 2));
        System.out.println(minusMinutes(instant, 2));
        System.out.println(minusHours(instant, 2));
        System.out.println(minusDays(instant, 2));
    }

    static public Instant plusMinutes(Instant instant, long minutes) {
        return instant.plusSeconds(minutes * MINUTE);
    }

    static public Instant plusHours(Instant instant, long hours) {
        return instant.plusSeconds(hours * HOUR);
    }

    static public Instant plusDays(Instant instant, long days) {
        return instant.plusSeconds(days * DAY);
    }

    static public Instant minusMinutes(Instant instant, long minutes) {
        return instant.minusSeconds(minutes * MINUTE);
    }

    static public Instant minusHours(Instant instant, long hours) {
        return instant.minusSeconds(hours * HOUR);
    }

    static public Instant minusDays(Instant instant, long days) {
        return instant.minusSeconds(days * DAY);
    }
}
