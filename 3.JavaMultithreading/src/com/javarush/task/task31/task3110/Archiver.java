package com.javarush.task.task31.task3110;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Archiver {

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter full archive path, please: ");
        Path archivePath = Paths.get(input.readLine());
        ZipFileManager zipFileManager = new ZipFileManager(archivePath);

        System.out.println("Enter fail path for zipping: ");
        Path filePath = Paths.get(input.readLine());
        zipFileManager.createZip(filePath);
    }
}
