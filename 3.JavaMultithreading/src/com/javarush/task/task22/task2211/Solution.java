package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Charset inputEncoding = Charset.forName("Windows-1251");
        Charset outputEncoding = StandardCharsets.UTF_8;

        try (InputStream reader = new FileInputStream(args[0]);
             OutputStream writer = new FileOutputStream(args[1])) {
            byte[] buffer = new byte[1000];
            reader.read(buffer);
            String data = new String(buffer, inputEncoding);
            buffer = data.getBytes(outputEncoding);
            writer.write(buffer);
        }
    }
}
