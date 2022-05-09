package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();

        String parameters = findParameters(url);
        String[] params = parameters.split("&");

//        HashMap<String, String> par = new HashMap<>();
//        for (String word : params) {
//            String[] pair = word.split("=");
//            if (pair.length > 1) {
//                par.put(pair[0], pair[1]);
//            }
//            else
//                par.put(pair[0], "");
//        }
//
//        Set<String> p = par.keySet();
//        for (String word : p) {
//            System.out.print(word + " ");
//        }
//
//        if (par.containsKey("obj")) {
//            System.out.println();
//            String objValue = par.get("obj");
//            try {
//                alert(Double.parseDouble(objValue));
//            } catch (Exception e) {
//                alert(objValue);
//            }
//        }

        String strObj = null;
        StringBuilder result = new StringBuilder();
        for (String param : params) {
            String[] par = param.split("=");
            result.append(par[0]);
            result.append(" ");

            if (par[0].equals("obj")) {
                strObj = par[1];
            }
        }

        System.out.println(result.toString().trim());

        if (strObj != null) {
            try {
                alert(Double.parseDouble(strObj));
            } catch (Exception e) {
                alert(strObj);
            }
        }

    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }

    public static String findParameters(String url) {
        String[] params = url.split("[?]");
        String str = "";
        if (params.length > 1) {
            str = params[1];
        }
        return str;
    }

}
