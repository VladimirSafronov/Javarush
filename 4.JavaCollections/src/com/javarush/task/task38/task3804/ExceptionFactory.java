package com.javarush.task.task38.task3804;

public class ExceptionFactory {
    static Throwable getException(Enum en) {
        if (en == null) {
            return new IllegalArgumentException();
        }
        String message = en.name().toLowerCase().replace("_", " ");
        String firstSymbol = message.substring(0, 1).toUpperCase();
        message = firstSymbol + message.substring(1);

        switch (en.getClass().getSimpleName()) {
            case "ApplicationExceptionMessage":
                return new Exception(message);
            case "DatabaseExceptionMessage":
                return new RuntimeException(message);
            case "UserExceptionMessage":
                return new Error(message);
            default:
                return new IllegalArgumentException();
        }
    }
}
