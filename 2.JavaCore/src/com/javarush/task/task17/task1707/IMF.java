package com.javarush.task.task17.task1707;


public class IMF {

    private static IMF imf;

    public static IMF getFund() {
        IMF localImf = imf;
        if (localImf == null) {
            synchronized (IMF.class) {
                localImf = imf = new IMF();
            }
        }
        return localImf;
    }

    private IMF() {
    }
}
