package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    static Hippodrome game;

    private List<Horse> horses;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    void run() {}

    void print() {}

    void move () {}

    public static void main(String[] args) {
        Hippodrome hippodrome = new Hippodrome(new ArrayList<>());
        hippodrome.horses.add(new Horse("Alpha", 3, 0));
        hippodrome.horses.add(new Horse("Beta", 3, 0));
        hippodrome.horses.add(new Horse("Hamma", 3, 0));
        Hippodrome.game = hippodrome;
    }
}
