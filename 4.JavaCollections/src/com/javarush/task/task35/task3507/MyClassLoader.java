package com.javarush.task.task35.task3507;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MyClassLoader extends ClassLoader {

    public Class<?> loadClass(Path path) throws IOException {
        byte[] buffer = Files.readAllBytes(path);
        return defineClass(null, buffer, 0, buffer.length);
    }
}
