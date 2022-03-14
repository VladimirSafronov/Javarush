package com.javarush.task.pro.task12.task1212;

/* 
Создаем свой список
*/

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class CustomStringArrayList {

    private int size;
    private int capacity;
    private String[] elements;

    public CustomStringArrayList() {
        capacity = 10;
        size = 0;
        elements = new String[capacity];
    }

    public void add(String element) {
        if (size == capacity) {
            grow();
        }
        elements[size] = element;
        size++;
    }

    private void grow() {
        capacity += capacity / 2;
        elements = Arrays.copyOf(elements, capacity);
    }

}