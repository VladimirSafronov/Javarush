package com.javarush.task.pro.task15.task1504;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
            var inputStream = Files.newInputStream(Paths.get(scanner.nextLine()));
            var outputStream = Files.newOutputStream(Paths.get(scanner.nextLine()))
        ) {
           int size = 1024;
           byte[] buffer = new byte[size];
           int length = inputStream.available();
           while (inputStream.available() > 0) {
               inputStream.read(buffer);
           }

           byte temporary = 0;
           for (int i = 0; i < length; i+=2) {
               if (i == length - 1) break;
               temporary = buffer[i];
               buffer[i] = buffer[i+1];
               buffer[i+1] = temporary;
           }
           outputStream.write(buffer, 0, length);

        } catch (Exception e) {
        System.out.println("Something went wrong : " + e);
    }
    }
}

