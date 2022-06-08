package com.javarush.task.task18.task1827;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Formatter;
import java.util.Scanner;

public class Solution {
//-c Носки 10.00 5

    public static void main(String[] args) throws Exception {
        String fileName = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = br.readLine();
        }

        try (FileReader reader = new FileReader(fileName);
        FileWriter writer = new FileWriter(fileName, true)) {
            if ((args.length == 4) && (args[0].equals("-c"))) {
                try (Scanner scan = new Scanner(reader);
                     Formatter frm = new Formatter()) {
                    int id = 0;
                    String number;
                    while (scan.hasNext()) { //поиск самого большого id в таблице
                        number = scan.nextLine().substring(0, 8).trim();
                        if (Integer.parseInt(number) > id) {
                            id = Integer.parseInt(number);
                        }
                    }
                    frm.format("%-8d%-30s%-8s%-4s", ++id, args[1], args[2], args[3]); //составление нового товара
                    writer.write("\n" + frm.toString());
                }
            }
        }

    }
}
