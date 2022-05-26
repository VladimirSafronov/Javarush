package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        switch (args[0]) {
            case "-c":
                if (args[2].equals("м")) {
                    allPeople.add(Person.createMale(args[1], new SimpleDateFormat("dd/MM/yyyy").parse(args[3])));
                }
                else if (args[2].equals("ж")) {
                    allPeople.add(Person.createFemale(args[1], new SimpleDateFormat("dd/MM/yyyy").parse(args[3])));
                }
                System.out.println(allPeople.indexOf(allPeople.get(allPeople.size() - 1)));
                break;
            case "-r":
                int i = Integer.parseInt(args[1]);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                String birthday = dateFormat.format(allPeople.get(i).getBirthDate());

                StringBuilder sb = new StringBuilder();
                sb.append(allPeople.get(i).getName()).append(" ");
                if (allPeople.get(i).getSex().equals(Sex.MALE)) {
                    sb.append("м ");
                }
                else if (allPeople.get(i).getSex().equals(Sex.FEMALE)) {
                    sb.append("ж ");
                }
                sb.append(birthday);
                System.out.println(sb);
                break;
            case "-u":
                int j = Integer.parseInt(args[1]);
                allPeople.get(j).setName(args[2]);
                if (args[3].equals("м")) {
                    allPeople.get(j).setSex(Sex.MALE);
                }
                else if (args[3].equals("ж")) {
                    allPeople.get(j).setSex(Sex.FEMALE);
                }
                allPeople.get(j).setBirthDate(new SimpleDateFormat("dd/MM/yyyy").parse(args[4]));
                break;
            case "-d":
                allPeople.get(Integer.parseInt(args[1])).setName(null);
                allPeople.get(Integer.parseInt(args[1])).setSex(null);
                allPeople.get(Integer.parseInt(args[1])).setBirthDate(null);
                break;
        }
    }
}
