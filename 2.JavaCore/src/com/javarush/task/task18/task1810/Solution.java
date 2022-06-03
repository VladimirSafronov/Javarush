package com.javarush.task.task18.task1810;

/*
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream input;
        do {
            String fileName = reader.readLine();
            input = new FileInputStream(fileName);
        } while (input.available() >= 1000);
        input.close();
        throw new DownloadException();
    }

    public static class DownloadException extends Exception {

    }
}
