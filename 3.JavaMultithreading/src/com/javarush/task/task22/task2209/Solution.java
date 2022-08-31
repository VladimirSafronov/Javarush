package com.javarush.task.task22.task2209;

/*
Составить цепочку слов
*/

////Свое решение (не доработал, нужно выполнять тестовое задание)
//public class Solution {
//    public static void main(String[] args) {
//        String fileName = "";
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//            fileName = reader.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        StringBuilder data = new StringBuilder();
//        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/vladimirsafronov/Desktop/file.txt"))) {
//            while (reader.ready()) {
//                data.append(reader.readLine()).append(" ");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String[] words = data.toString().split(" ");
//
//        //...
//        StringBuilder result = getLine(words);
//        System.out.println(result.toString().trim());
//    }
//
//    public static StringBuilder getLine(String... words) {
//        if (words.length == 0) {
//            return null;
//        }
//        Map<Character, List<String>> cities = new HashMap<>(); //создаю Map, которая будет содержать города по алфавиту
//
//        String city = "";
//        char firstSymbol;
//        //заполняю cities
//        for (int i = 0; i < words.length; i++) {
//            city = words[i];
//            firstSymbol = city.charAt(0);
//            if (cities.containsKey(firstSymbol)) {
//                cities.get(firstSymbol).add(city); //добавляю город к существующему списку
//            } else {
//                cities.put(firstSymbol, new ArrayList<>(List.of(city))); //добавляю новое значение в cities
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        String nextCity = words[0]; //захватываем первый город для начала вывода
//        char lastSymbol = Character.toUpperCase(nextCity.charAt(nextCity.length() - 1)); //сохраняем последний символ, переведя его к заглавной букве
//        // нужно удалить значение
//        if (cities.get(lastSymbol).size() == 0) {
//            cities.remove(lastSymbol);
//        }
//        sb.append(nextCity).append(" ");
//
//        //собираем оставшиеся города из Map, параллельно удаляя значения
//        while (cities.size() > 0) {
//            nextCity = cities.get(lastSymbol).remove(0);
//            lastSymbol = Character.toUpperCase(nextCity.charAt(nextCity.length() - 1));
//            sb.append(nextCity).append(" ");
//            if (cities.get(lastSymbol).size() == 0) {
//                cities.remove(lastSymbol);
//            }
//        }
//
//        return sb;
//    }
//}

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())))) {
            while (fileReader.ready()) {
                list.add(fileReader.readLine());
            }
        } catch (IOException ignored) {
        }

        List<String> resultList = new ArrayList<>();
        for (String line : list) {
            StringTokenizer tokenizer = new StringTokenizer(line);
            while (tokenizer.hasMoreTokens()) {
                resultList.add(tokenizer.nextToken());
            }
        }

        StringBuilder result = getLine(getWords(resultList));
        System.out.println(result.toString());
    }

    private static String[] getWords(List<String> list) {
        String[] array = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    private static boolean isTheSameChars(String firstWord, String secondWord) {
        if (firstWord.endsWith(" ")) {
            firstWord = firstWord.substring(0, firstWord.length() - 1);
        }
        return firstWord.isEmpty() || (secondWord != null &&
                Character.toUpperCase(firstWord.charAt(firstWord.length() - 1)) == Character.toUpperCase(secondWord.charAt(0)));
    }

    private static <T> T getLastElement(List<? extends T> list) {
        return list.get(list.size() - 1);
    }


    public static StringBuilder getLine(String... words) {
        StringBuilder builder = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            list.add(i);
            if (findSolutions(list, words)) {
                for (Integer integer : list) {
                    builder.append(words[integer]);
                    builder.append(" ");
                }
                return builder;
            }
            list.remove(Integer.valueOf(i));
        }

        return builder;
    }

    private static boolean findSolutions(List<Integer> list, String... words) {
        if (list.size() == words.length) {
            return true;
        }
        for (int i = 0; i < words.length; i++) {
            if (isValid(list, words[i], words)) {
                list.add(i);
                if (findSolutions(list, words)) {
                    return true;
                }
                list.remove(Integer.valueOf(i));
            }
        }
        return false;
    }

    private static boolean isValid(List<Integer> list, String word, String... words) {
        for (Integer integer : list) {
            if (words[integer].equals(word)) {
                return false;
            }
        }
        return isTheSameChars(words[getLastElement(list)], word);
    }

}
