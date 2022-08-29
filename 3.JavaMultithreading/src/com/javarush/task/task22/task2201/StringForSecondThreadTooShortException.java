package com.javarush.task.task22.task2201;

public class StringForSecondThreadTooShortException extends RuntimeException {
    public StringForSecondThreadTooShortException(Throwable cause) {
    }

    @Override
    public synchronized Throwable getCause() {
        return new IndexOutOfBoundsException("string index out of range: -1");
    }
}
