package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static List<Integer> readAndSplit(String fileName) throws IOException {
        List<Integer> stringNumbers = new ArrayList<>();
        String[] line;
        int numberOfLine;

        try (BufferedReader input = new BufferedReader(new FileReader(fileName))) {
            while (input.ready()) {
                line = input.readLine().split("строка");
                numberOfLine = Integer.parseInt(line[1]);
                stringNumbers.add(numberOfLine);
            }
        }
        return stringNumbers;
    }

    public static void compare(List<Integer> file1, List<Integer> file2) {
        for (int i = 0, j = 0; i < file1.size() && j < file2.size();) {
            if(file1.get(i) == file2.get(j)) {
                lines.add(new LineItem(Type.SAME, "строка" + file1.get(i)));
                i++;
                j++;
            } else if(file1.get(i) > file2.get(j)) {
                lines.add(new LineItem(Type.ADDED, "строка" + file2.get(j)));
                j++;
            } else {
                lines.add(new LineItem(Type.REMOVED, "строка" + file1.get(i)));
                i++;
            }
        }
        if(file1.size() > file2.size()) {
            lines.add(new LineItem(Type.REMOVED, "строка" + file1.get(file1.size() - 1)));
        } else if (file1.size() < file2.size()) {
            lines.add(new LineItem(Type.ADDED, "строка" + file2.get(file2.size() - 1)));
        }
    }

    public static void main(String[] args) throws IOException {
        String file1;
        String file2;
        try (BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = fileNameReader.readLine();
            file2 = fileNameReader.readLine();
        }

        List<Integer> file1Data = Solution.readAndSplit(file1);
        List<Integer> file2Data = Solution.readAndSplit(file2);

        Solution.compare(file1Data, file2Data);


        //Решение JavaRush
        /*
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String oldFileName = console.readLine();
        String newFileName = console.readLine();
        console.close();

        List<String> oldFileLines = readFileLines(oldFileName);
        List<String> newFileLines = readFileLines(newFileName);

        int oldFileLine = 0;
        int newFileLine = 0;

        while ((oldFileLine < oldFileLines.size()) && (newFileLine < newFileLines.size())) {

            if (oldFileLines.get(oldFileLine).equals(newFileLines.get(newFileLine))) {
                lines.add(new LineItem(Type.SAME, oldFileLines.get(oldFileLine)));
                oldFileLine++;
                newFileLine++;
            } else if ((newFileLine + 1 < newFileLines.size()) && oldFileLines.get(oldFileLine).equals(newFileLines.get(newFileLine + 1))) {
                lines.add(new LineItem(Type.ADDED, newFileLines.get(newFileLine)));
                newFileLine++;
            } else if ((oldFileLine + 1 < oldFileLines.size()) && oldFileLines.get(oldFileLine + 1).equals(newFileLines.get(newFileLine))) {
                lines.add(new LineItem(Type.REMOVED, oldFileLines.get(oldFileLine)));
                oldFileLine++;
            }
        }

        while (oldFileLine < (oldFileLines.size())) {
            lines.add(new LineItem(Type.REMOVED, oldFileLines.get(oldFileLine)));
            oldFileLine++;
        }
        while (newFileLine < (newFileLines.size())) {
            lines.add(new LineItem(Type.ADDED, newFileLines.get(newFileLine)));
            newFileLine++;
        }
    }

    static List<String> readFileLines(String fileName) throws IOException {
        BufferedReader fReader = new BufferedReader(new FileReader(fileName));
        List<String> fileLines = new ArrayList<String>();
        String line;
        while ((line = fReader.readLine()) != null) {
            fileLines.add(line);
        }
        fReader.close();
        return fileLines;

         */
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
