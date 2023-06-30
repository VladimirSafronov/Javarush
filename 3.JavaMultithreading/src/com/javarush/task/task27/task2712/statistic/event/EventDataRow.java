package com.javarush.task.task27.task2712.statistic.event;

import java.util.Date;

/*
Интерфейс-маркер. По нему определяем является ли переданный объект событием.
 */
public interface EventDataRow {

    EventType getType();
    Date getDate();
    int getTime();
}
