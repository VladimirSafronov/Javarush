package com.javarush.task.task24.task2401;

public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker {
    public int sum(int a, int b) {
        return a + b;
    }

    public String addPoint(String str) {
        return str + ".";
    }
}
