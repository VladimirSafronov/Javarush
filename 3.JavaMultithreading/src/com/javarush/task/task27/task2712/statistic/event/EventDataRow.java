package com.javarush.task.task27.task2712.statistic.event;

/*
Интерфейс-маркер. По нему определяем является ли переданный объект событием.
 */
public interface EventDataRow {

    EventType getType();
}
