package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.female.FemaleFactory;
import com.javarush.task.task37.task3702.male.MaleFactory;

public class FactoryProducer {

    public static AbstractFactory getFactory(HumanFactoryType sex) {
        AbstractFactory result = null;
        switch (sex) {
            case MALE:
                result = new MaleFactory();
                break;
            case FEMALE:
                result = new FemaleFactory();
                break;
        }
        return result;
    }

    public static enum HumanFactoryType {
        MALE,
        FEMALE
    }
}
