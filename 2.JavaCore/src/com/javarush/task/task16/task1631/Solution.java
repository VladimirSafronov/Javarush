package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.ImageReader;
import com.javarush.task.task16.task1631.common.ImageTypes;

/* 
Factory method pattern
*/
//https://vertex-academy.com/tutorials/ru/pattern-factory-java/

public class Solution {
    public static void main(String[] args) {
        ImageReader reader = ImageReaderFactory.getImageReader(ImageTypes.JPG);
    }
}