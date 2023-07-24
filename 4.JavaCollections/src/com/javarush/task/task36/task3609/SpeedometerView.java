package com.javarush.task.task36.task3609;

public class SpeedometerView {
    private CarModel carModel;

    public SpeedometerView(CarModel carModel) {
        this.carModel = carModel;
    }

    public void printCarDetails() {
        System.out.println("Car: \nBrand: " + carModel.getBrand() + "\nModel: " + carModel.getModel()
                + "\nCurrent Speed: " + carModel.getSpeed() + "\n");
    }
}