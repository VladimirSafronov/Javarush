package com.javarush.task.task31.task3102;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/* 
Находим все файлы
*/

public class Solution {

    public static List<String> getFileTree(String root) throws IOException {
        List<String> result = new ArrayList<>();

        EnumSet<FileVisitOption> option = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        Files.walkFileTree(Paths.get(root), option, Integer.MAX_VALUE, new MyFileVisitor(result));
        return result;
    }

    public static void main(String[] args) throws IOException {
        String root = "/Users/vladimirsafronov/Desktop";
        List<String> pathes = Solution.getFileTree(root);
    }
}
