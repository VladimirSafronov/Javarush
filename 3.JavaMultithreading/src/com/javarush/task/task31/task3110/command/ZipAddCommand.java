package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipAddCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        Path fileName = null;
        try {
            ConsoleHelper.writeMessage("Добавление файла в архив.");
            ZipFileManager manager = getZipFileManager();
            fileName = Paths.get(ConsoleHelper.readString());
            manager.addFile(fileName);
        } catch (PathIsNotFoundException ex) {
            ConsoleHelper.writeMessage("Данного файла не существует " + fileName);
        }
    }
}
