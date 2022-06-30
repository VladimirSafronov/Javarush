package com.javarush.task.task19.task1917;

/*
Свой FileWriter
*/

import java.io.*;

public class FileConsoleWriter {
    private FileWriter fileWriter;
    private BufferedWriter consoleWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    public FileConsoleWriter(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        fileWriter = new FileWriter(fd);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        consoleWriter.write(cbuf, off, len);
        consoleWriter.flush();
        fileWriter.write(cbuf, off, len);
    }

    public void write(int c) throws IOException {
        consoleWriter.write(c);
        consoleWriter.flush();
        fileWriter.write(c);
    }

    public void write(String str) throws IOException {
        consoleWriter.write(str);
        consoleWriter.flush();
        fileWriter.write(str);
    }

    public void write(String str, int off, int len) throws IOException {
        consoleWriter.write(str, off, len);
        consoleWriter.flush();
        fileWriter.write(str, off, len);
    }

    public void write(char[] cbuf) throws IOException {
        consoleWriter.write(cbuf);
        consoleWriter.flush();
        fileWriter.write(cbuf);
    }

    public void close() throws IOException {
        consoleWriter.flush();
        consoleWriter.close();
        fileWriter.close();
    }

    public static void main(String[] args) throws IOException {
    }

}
