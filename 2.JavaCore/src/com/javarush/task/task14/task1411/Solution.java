package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key;
        String[] keys = {"user", "loser", "coder", "proger"};
        ArrayList<String> objects = new ArrayList<String>();

        while (Arrays.asList(keys).contains(key = reader.readLine())) {
            objects.add(key);
        }

        for (String obj : objects) {
            switch (obj) {
                case "user":
                    person = new Person.User();
                    break;
                case "loser":
                    person = new Person.Loser();
                    break;
                case "coder":
                    person = new Person.Coder();
                    break;
                case "proger":
                    person = new Person.Proger();
                    break;
            }

            doWork(person);

        }
    }

    public static void doWork(Person person) {
        if (person instanceof Person.User) {
            ((Person.User) person).live();
        }
        else if (person instanceof Person.Loser) {
            ((Person.Loser) person).doNothing();
        }
        else if (person instanceof Person.Coder) {
            ((Person.Coder) person).writeCode();
        }
        else if (person instanceof Person.Proger) {
            ((Person.Proger) person).enjoy();
        }
    }

}
