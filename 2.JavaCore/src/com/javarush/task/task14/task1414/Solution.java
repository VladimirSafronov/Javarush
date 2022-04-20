package com.javarush.task.task14.task1414;

/*
MovieFactory
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] genres = {"soapOpera", "cartoon", "thriller"};
        String key;
        ArrayList<String> movies = new ArrayList<>();

        do {
            key = reader.readLine();
            movies.add(key);
        } while (Arrays.asList(genres).contains(key));

        for (String m : movies) {
            try {
                Movie movie = MovieFactory.getMovie(m);
                System.out.println(movie.getClass().getSimpleName());
            } catch (NullPointerException nullPointerException) {
                nullPointerException.getMessage();
            }
        }

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }
            else if ("cartoon".equals(key)) {
                movie = new Cartoon();
            }
            else if ("thriller".equals(key)) {
                movie = new Thriller();
            }
            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    static class Cartoon extends Movie {
    }

    static class Thriller extends Movie {
    }
}
