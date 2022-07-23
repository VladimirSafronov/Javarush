package com.javarush.task.task31.task3106;

/*
Разархивируем файл
*/

import java.io.*;
import java.util.TreeSet;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Solution {

    public static void main(String[] args) throws IOException {

        TreeSet<String> archives = new TreeSet<>();//создаю и записываю архивы в упорядоченную коллекцию
        for (int i = 1; i < args.length; i++) {
            archives.add(args[i]);
        }

        Vector<InputStream> streams = new Vector<>();//создаю коллекцию типа вектор для работы с потоками
        for (String archive : archives) {
            streams.add(new FileInputStream(archive));
        }

        //создаю входящий поток, работающий со всеми архивами
        //создаю исходящий поток для записи в файл
        try (ZipInputStream zipInput = new ZipInputStream(new SequenceInputStream(streams.elements()));
             FileOutputStream output = new FileOutputStream(args[0])) {
            ZipEntry entry;
            byte[] buffer = new byte[1024];//буффер для байт
            int bufferSize;//здесь хранится размер буффера
            while ((entry = zipInput.getNextEntry()) != null) { //пока поток содержит zip-файлы
                while ((bufferSize = zipInput.read(buffer)) > 0) { //и размер считанных байт больше нуля
                    output.write(buffer, 0, bufferSize); //записываем считанные данные из буффера в целевой файл
                }
            }
        }
    }
}
