package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.female.FemaleFactory;
import com.javarush.task.task37.task3702.male.MaleFactory;

public class Solution {
    public static void main(String[] args) {
        MaleFactory factory = new MaleFactory();
        Human person1 = (Human) factory.getPerson(99);
        System.out.println(person1);
        Human person2 = (Human) factory.getPerson(4);
        System.out.println(person2);
        Human person3 = (Human) factory.getPerson(15);
        System.out.println(person3);

        FemaleFactory factory2 = new FemaleFactory();
        Human person4 = (Human) factory2.getPerson(99);
        System.out.println(person4);
        Human person5 = (Human) factory2.getPerson(4);
        System.out.println(person5);
        Human person6 = (Human) factory2.getPerson(15);
        System.out.println(person6);
    }
}
