package com.javarush.task.task18.task1812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream original;

    public QuestionFileOutputStream (AmigoOutputStream original) {
        this.original = original;
    }

    @Override
    public void flush() throws IOException {
        System.out.println("My aos flush()");
        original.flush();
    }

    @Override
    public void write(int b) throws IOException {
        System.out.println("My aos write(int b)");
        original.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        System.out.println("My aos write(byte[] b)");
        original.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        System.out.println("My aos write(byte[] b, int off, int len)");
        original.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String answer = reader.readLine();
        if (answer.equals("Д")) {
            original.close();
        }

    }
}

