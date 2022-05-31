package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file1 = new File(br.readLine());
        File file2 = new File(br.readLine());

        br = new BufferedReader(new FileReader(file1));
        while (br.ready()) {
            allLines.add(br.readLine());
        }

        br = new BufferedReader(new FileReader(file2));
        while (br.ready()) {
            forRemoveLines.add(br.readLine());
        }
        br.close();

        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            System.out.println("allLines doesn't contain forRemoveLines");
        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            for (String str : forRemoveLines) {
                allLines.remove(str);
            }
        }
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
