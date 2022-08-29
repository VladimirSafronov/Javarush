package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        //чтение имени файла
        String fileName = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter file name:");
            fileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //чтение данных из файла, с сохранением слов в массив
        StringBuilder data = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                data.append(reader.readLine()).append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] words = data.toString().split(" ");

        //нахождение пар
        for (int i = 0; i < words.length - 2; i++) { //-2 потому что не с чем будет проверять последнее слово
            StringBuilder sb = new StringBuilder();
            if (words[i] != null) {
                sb.append(words[i]).reverse(); //переворачиваем слово, для поиска зеркального слова
                for (int j = i + 1; j < words.length; j++) {
                    if (sb.toString().equals(words[j])) {
                        result.add(new Pair(sb.reverse().toString(), words[j]));
                        words[j] = null; //"удаляем" использованное слово
                        break;
                    }
                }
            }
        }
    }

    public static class Pair {
        String first;
        String second;

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        public Pair() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
