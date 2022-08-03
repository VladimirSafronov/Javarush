package com.javarush.task.task31.task3109;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/* 
Читаем конфиги
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties properties = new Properties();
        String separator = File.separator; //находим разделитель (для каждой ОС он свой)
        String[] path = fileName.split(separator); //разделяем путь по директориям
        String[] nameAndType = path[path.length - 1].split("\\."); //находим имя файла и его расширение
        String typeFile = nameAndType[nameAndType.length - 1]; //получаем тип файла

        try (FileInputStream fis = new FileInputStream(fileName)) {
            if(typeFile.equals("xml")) {
                properties.loadFromXML(fis);
            } else {
                properties.load(fis);
            }
        } catch (IOException ex) {
            return new Properties();
        }
        return properties;
    }
}
