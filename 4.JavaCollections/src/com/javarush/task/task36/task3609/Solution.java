package com.javarush.task.task36.task3609;

/* 
Рефакторинг MVC
*/

public class Solution {
    public static void main(String[] args) {
        // Fetch car record from the database
        CarModel model = CarModel.retrieveCarFromDatabase();

        // Create a view to show the car's speed on a speedometer (the console)
        SpeedometerView view = new SpeedometerView(model);

        CarController controller = new CarController(model, view);
        controller.updateView();

        // Update the model data
        controller.increaseSpeed(15);
        controller.updateView();

        // Update the model data
        controller.increaseSpeed(50);
        controller.updateView();

        // Update the model data
        controller.decreaseSpeed(7);
        controller.updateView();
    }
}