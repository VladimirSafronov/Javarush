package com.javarush.task.pro.task15.task1512;

import java.io.*;
import java.util.Scanner;

/* 
Задом наперед
*/

public class Solution {
    public static ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    public static PrintStream stream = new PrintStream(outputStream);

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        printSomething(scanner.nextLine());
        String result = outputStream.toString();

        outputStream.reset();//очищаю поток
        byte[] temporary = result.getBytes();//создаю временный массив байт на основе очищенного потока
        int length = temporary.length;
        for (int i = length - 1; i >= 0; i--) {
            outputStream.write(temporary[i]);//направляю в поток данные с конца
        }
        String res = outputStream.toString();
        System.out.println(res);
        stream.close();
    }

    public static void printSomething(String str) {
        stream.print(str);
    }
}