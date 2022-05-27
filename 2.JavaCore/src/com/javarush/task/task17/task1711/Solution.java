package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
                        if (args[1 + i].equals("м")) {
                            allPeople.add(Person.createMale(args[i], new SimpleDateFormat("dd/MM/yyyy").parse(args[2 + i])));
                        } else if (args[1 + i].equals("ж")) {
                            allPeople.add(Person.createFemale(args[i], new SimpleDateFormat("dd/MM/yyyy").parse(args[2 + i])));
                        }
                        System.out.println(allPeople.size() - 1);
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 4) {
                        int id = Integer.parseInt(args[i]);
                        allPeople.get(id).setName(args[1 + i]);
                        if (args[2 + i].equals("м")) {
                            allPeople.get(id).setSex(Sex.MALE);
                        }
                        else if (args[2 + i].equals("ж")) {
                            allPeople.get(id).setSex(Sex.FEMALE);
                        }
                        allPeople.get(id).setBirthDate(new SimpleDateFormat("dd/MM/yyyy").parse(args[3 + i]));
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int id = Integer.parseInt(args[i]);
                        allPeople.get(id).setName(null);
                        allPeople.get(id).setSex(null);
                        allPeople.get(id).setBirthDate(null);
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int id = Integer.parseInt(args[i]);
                        StringBuilder sb = new StringBuilder();
                        SimpleDateFormat simpleDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                        String birthday = simpleDate.format(allPeople.get(id).getBirthDate());

                        sb.append(allPeople.get(id).getName()).append(" ");
                        if (allPeople.get(id).getSex().equals(Sex.MALE)) {
                            sb.append("м ");
                        }
                        else if (allPeople.get(id).getSex().equals(Sex.FEMALE)) {
                            sb.append("ж ");
                        }
                        sb.append(birthday);
                        System.out.println(sb);
                    }
                }
                break;
        }
    }
}
