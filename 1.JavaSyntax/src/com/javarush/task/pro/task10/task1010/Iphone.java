package com.javarush.task.pro.task10.task1010;

import java.util.Objects;

/* 
Два айфона
*/

public class Iphone {
    private String model;
    private String color;
    private int price;

    public Iphone(String model, String color, int price) {
        this.model = model;
        this.color = color;
        this.price = price;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Iphone)) {
            return false;
        }

        Iphone iphone = (Iphone) obj;

        if (this.price != iphone.price) {
            return false;
        }

//        if (this.color == null) {   //валидатор javarush не пропускал такое решение, хотя мне оно кажется более читабельным
//            return iphone.color == null;
//        }
//
//        if (this.model == null) {
//            return iphone.model == null;
//        }

        return this.model != null && this.model.equals(iphone.model) && this.color != null && this.color.equals(iphone.color);
    }

    public static void main(String[] args) {
        Iphone iphone1 = new Iphone("X", "Black", 999);
        Iphone iphone2 = new Iphone("X", "Black", 999);

        System.out.println(iphone1.equals(iphone2));
    }

}
