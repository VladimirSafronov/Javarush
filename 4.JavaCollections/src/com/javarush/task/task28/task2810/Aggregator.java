package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Provider;

public class Aggregator {
    public static void main(String[] args) {
        Provider first = new Provider(null);
        Controller controller = new Controller(first);
        System.out.println(controller.toString());
    }
}
