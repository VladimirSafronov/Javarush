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

    void run() {
        for (int i = 100; i > 0; i--) {
            move();
            print();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 10; i > 0; i--) {
            System.out.println();
        }
    }

    void move () {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public Horse getWinner() {
        double winnerDist = 0.0;
        Horse winner = null;
        for (Horse horse : horses) {
            if (horse.distance > winnerDist) {
                winner = horse;
                winnerDist = horse.distance;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().name + "!");
    }

    public static void main(String[] args) {
        Hippodrome hippodrome = new Hippodrome(new ArrayList<>());
        hippodrome.horses.add(new Horse("Alpha", 3, 0));
        hippodrome.horses.add(new Horse("Beta", 3, 0));
        hippodrome.horses.add(new Horse("Hamma", 3, 0));
        Hippodrome.game = hippodrome;

        Hippodrome.game.run();
        hippodrome.printWinner();
    }
}
