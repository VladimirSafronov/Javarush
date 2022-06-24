package com.javarush.task.task19.task1904;

/*
И еще один адаптер
*/

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        Person first = new PersonScannerAdapter(new Scanner(new File("/Users/vladimirsafronov/Desktop/file.txt"))).read();
        System.out.println(first);
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }

        @Override
        public Person read() throws IOException {
            String[] data = fileScanner.nextLine().split(" ");
            String firstName = data[1];
            String middleName = data[2];
            String lastName = data[0];
            Date birthDate = new Date(
                    (Integer.parseInt(data[5]) - 1900),
                    (Integer.parseInt(data[4]) - 1),
                    Integer.parseInt(data[3]));

            return new Person(firstName, middleName, lastName, birthDate);
        }
    }
}
