package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;//это поток, при помощи которого пишем данные в файл (к сериализации отношения не имеет)
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution("/Users/vladimirsafronov/Desktop/file2.txt");
        solution.writeObject("12345");
        solution.writeObject("98765");

        String filePath = "/Users/vladimirsafronov/Desktop/file.bin";
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath));
        out.writeObject(solution);
        solution.close();
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath));
        Solution solution2 = (Solution) in.readObject();
        solution2.writeObject("буквы");
        solution2.close();
        in.close();
    }
}
