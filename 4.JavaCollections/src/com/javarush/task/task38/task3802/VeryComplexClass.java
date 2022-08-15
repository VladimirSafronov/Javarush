package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.io.BufferedReader;
import java.io.FileReader;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("not_file_here.txt"));
        StringBuilder s = new StringBuilder();
        while (reader.ready()) {
            s.append(reader.readLine());
        }
        reader.close();
    }

    public static void main(String[] args) throws Exception {
        VeryComplexClass vcc = new VeryComplexClass();
        vcc.veryComplexMethod();
    }
}
