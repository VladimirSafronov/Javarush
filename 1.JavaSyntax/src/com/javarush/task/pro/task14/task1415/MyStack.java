package com.javarush.task.pro.task14.task1415;

import java.util.ArrayList;
import java.util.List;

/* 
Стек в домашних условиях
*/

public class MyStack {

    private final List<String> storage = new ArrayList<>();
    private final int FIRST_ELEMENT = 0;

    public void push(String s) {
        storage.add(FIRST_ELEMENT, s);
    }

    public String pop() {
        String s = storage.get(FIRST_ELEMENT);
        storage.remove(FIRST_ELEMENT);
        return s;
    }

    public String peek() {
        return storage.get(FIRST_ELEMENT);
    }

    public boolean empty() {
        return storage.isEmpty();
    }

    public int search(String s) {
        return storage.indexOf(s);
    }
}
