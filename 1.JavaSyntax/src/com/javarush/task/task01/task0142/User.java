package com.javarush.task.task01.task0142;

public class User {
    String name;
    short age;
    int height;

    public User (String name, short age, int height) {
        this. name = name;
        this.age = age;
        this.height = height;
    }

    public User (short age, String name, int height) {
        this.age = age;
        this. name = name;
        this.height = height;
    }

    public User (int height, short age, String name) {
        this.height = height;
        this.age = age;
        this. name = name;

    }
}
