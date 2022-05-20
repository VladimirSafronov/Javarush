package com.javarush.task.task16.task1630;

import java.io.*;

/* 
Последовательный вывод файлов
*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String name;
        private String fileContent = "";

        @Override
        public void run() {
            try {
                BufferedReader bf = new BufferedReader(new FileReader(name));
                while (bf.ready()) {
                    fileContent += bf.readLine() + " ";
                }
            } catch (IOException e) {
            }
        }

        @Override
        public void setFileName(String fullFileName) {
            this.name = fullFileName;
        }

        @Override
        public String getFileContent() {
            return fileContent;
        }

        //        @Override
//        public String getFileContent() {
//            StringBuilder fileContent = new StringBuilder();
////            Path path = Path.of(name);
//            try {
////                List<String> stringsFile = Files.readAllLines(path);
////                for (String string : stringsFile) {
////                    fileContent.append(string).append(" ");
////                }
//                BufferedReader bf = new BufferedReader(new FileReader(name));
//                while (bf.ready()) {
//                    fileContent.append(bf.readLine()).append(" ");
//                }
//            } catch (IOException e) {
//            }
//            return fileContent.toString().trim();
//        }
    }
}
