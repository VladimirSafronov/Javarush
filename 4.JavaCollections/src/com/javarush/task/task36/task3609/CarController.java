package com.javarush.task.task36.task3609;

public class CarController {
    private CarModel model;
    private SpeedometerView view;

    public CarController(CarModel model, SpeedometerView view) {
        this.model = model;
        this.view = view;
    }

    public void increaseSpeed(int seconds) {
        model.incrementSpeed(seconds);
    }

    public void decreaseSpeed(int seconds) {
        model.decrementSpeed(seconds);
    }

    public void updateView() {
        view.printCarDetails();
    }
}