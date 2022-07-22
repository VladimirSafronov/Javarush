package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumSet;

/* 
Что внутри папки?
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Path path = fileNameReader();
        if (!Files.isDirectory(path)) {
            System.out.println(path.toAbsolutePath() + " - не папка");
            return;
        }
        MyFileVisitor visitor = getInfo(path);
        System.out.println("Всего папок - " + (visitor.getCountDirectories() - 1));
        System.out.println("Всего файлов - " + (visitor.getCountFiles()));
        System.out.println("Общий размер - " + visitor.getSize());
    }

    public static Path fileNameReader() throws IOException {
        Path path;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            path = Paths.get(reader.readLine());
        }
        return path;
    }

    public static MyFileVisitor getInfo(Path root) throws IOException {
        MyFileVisitor mfv = new MyFileVisitor();
        EnumSet<FileVisitOption> option = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        Files.walkFileTree(root, option, Integer.MAX_VALUE, mfv);
        return mfv;
    }
}
