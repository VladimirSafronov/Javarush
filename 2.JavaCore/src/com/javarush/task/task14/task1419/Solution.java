package com.javarush.task.task14.task1419;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try { //the second exception
            String s = null;
            System.out.println(s.length());
        } catch (NullPointerException npe) {
            exceptions.add(npe);
        }

        try { //the third exception
            int[] array = new int[10];
            int value = array[11];
        } catch (ArrayIndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        try { //the fourth exception
            Object o = new Object();
            String s = (String) o;
        } catch (ClassCastException e) {
            exceptions.add(e);
        }

        try { //the fifth exception
            Thread t = new Thread();
            t.setPriority(1000);
        } catch (IllegalArgumentException e) {
            exceptions.add(e);
        }

        try { //the sixth exception
            int i = Integer.parseInt("one");
        } catch (NumberFormatException e) {
            exceptions.add(e);
        }

        try { // the seventh exception
            Thread t = new Thread();
            t.start();
            t.start();
        } catch (IllegalThreadStateException e) {
            exceptions.add(e);
        }

        try { // the eighth exception
            BufferedReader reader = new BufferedReader(new FileReader("Users/unit1"));
        } catch (FileNotFoundException e) {
            exceptions.add(e);
        }

        try { // the ninth exception
            int[] array = new int[-10];
        } catch (NegativeArraySizeException e) {
            exceptions.add(e);
        }

        // the tenth exception
        IOException exception = new IOException();
        exceptions.add(exception);
    }
}
