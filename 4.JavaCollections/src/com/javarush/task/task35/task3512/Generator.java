package com.javarush.task.task35.task3512;

public class Generator<T> {
    private Class<T> inst;

    public Generator(Class<T> inst) {
        this.inst = inst;
    }

    T newInstance() throws InstantiationException, IllegalAccessException {
        return inst.newInstance();
    }
}
