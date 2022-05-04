package com.javarush.task.task15.task1530;

/* 
Template pattern
*/

public class Solution {
    public static void main(String[] args) {
        DrinkMaker tea = new TeaMaker();
        tea.makeDrink();

        DrinkMaker coffee = new LatteMaker();
        coffee.makeDrink();
    }
}
