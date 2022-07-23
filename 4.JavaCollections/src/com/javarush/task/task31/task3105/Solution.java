package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/

public class Solution {

    public static void main(String[] args) throws IOException {

        List<Content> entries = getContents(args[1]);

        FileOutputStream zipFile = new FileOutputStream(args[1]);
        ZipOutputStream zip = new ZipOutputStream(zipFile);

        //кладем в исходящий поток ZipEntry –«архивный объект»
        File file = new File(args[0]);
        zip.putNextEntry(new ZipEntry("new/" + file.getName()));

        //копируем файл в архив
        Files.copy(file.toPath(), zip);

        //копируем все остальные файлы
        for (Content content : entries) {
            if (!content.getFileName().equals("new/" + file.getName())) content.saveToZip(zip);
        }

        // закрываем архив
        zip.close();
    }

    private static List<Content> getContents(String arg) throws IOException {
        List<Content> entries = new ArrayList<>();//создаем список объектов Content
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(arg))) { //открываем входящий поток
            ZipEntry currentEntry;
            byte[] buffer = new byte[1024];
            while ((currentEntry = zipInputStream.getNextEntry()) != null) { //пока в потоке есть данные
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                int length = 0;
                while ((length = zipInputStream.read(buffer)) > 0) { //пишем данные в буфер, запоминая размер
                    outputStream.write(buffer, 0, length);
                }
                entries.add(new Content(currentEntry.getName(), outputStream.toByteArray())); //сохраняем новый объект в списке
            }
        }
        return entries;
    }

    static class Content {
        String fileName;
        byte[] body;

        Content(String fileName, byte[] body) {
            this.fileName = fileName;
            this.body = body;
        }

        public String getFileName() {
            return fileName;
        }

        void saveToZip(ZipOutputStream zip) throws IOException { //метод записи архива в файл
            ZipEntry zipEntry = new ZipEntry(fileName);
            zip.putNextEntry(zipEntry);
            zip.write(body);
            zip.closeEntry();
        }




//        Map<String, ByteArrayOutputStream> zipFiles = new HashMap<>();
//        try (ZipInputStream zipInput = new ZipInputStream(new FileInputStream(args[1]));
//             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
//            ZipEntry entry;
//            int length;
//            byte[] buffer = new byte[1024];
//            while ((entry = zipInput.getNextEntry()) != null) {
//                while ((length = zipInput.read(buffer)) != -1) {
//                    baos.write(buffer, 0, length);
//                }
//                zipFiles.put(entry.getName(), baos);
//                zipInput.closeEntry();
//                baos.reset();
//            }
//        }
//
//        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(args[1]))) {
//            boolean hasSameName = false;
//            String fileName = Paths.get(args[0]).getFileName().toString();
//            String zipFileName;
//            ZipEntry entry;
//            for (String key : zipFiles.keySet()) {
//                zipFileName = Paths.get(key).getFileName().toString();
//                if (!zipFileName.equals(fileName)) {
//                    entry = new ZipEntry(key);
//                    zos.putNextEntry(entry);
//                    zos.write(zipFiles.get(key).toByteArray());
//                    zos.closeEntry();
//                } else {
//                    zos.putNextEntry(new ZipEntry(fileName));
//                    Files.copy(Paths.get(fileName), zos);
//                    zos.closeEntry();
//                    hasSameName = true;
//                }
//            }
//            if (!hasSameName) {
//                entry = new ZipEntry("new/" + fileName);
//                Files.copy(Paths.get(fileName), zos);
//                zos.closeEntry();
//            }
//        }
    }
}
