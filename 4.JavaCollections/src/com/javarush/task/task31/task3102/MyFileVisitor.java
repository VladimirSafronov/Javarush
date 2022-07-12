package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class MyFileVisitor extends SimpleFileVisitor<Path> {
    private List<String> files;

    public MyFileVisitor(List<String> files) {
        this.files = files;
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
        File file = path.toFile();
        if(file.isFile()) {
            files.add(file.getAbsolutePath());
        }
        return super.visitFile(path, attrs);
    }
}
