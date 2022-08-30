package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> values = new HashMap<>();
        values.put("name", "Ivanov");
        values.put("age", "12");
        values.put("country", null);
        values.put("city", "Ivanovo");

        System.out.println(getQuery(values));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for (String key : params.keySet()) {
            if (params.get(key) != null) {
                sb.append(key).append(" = ").append("'").append(params.get(key)).append("'").append(" and ");
            }
        }
        String answer = sb.toString(); //это все для удовлетворения валидатора
        if (answer.length() > 0) {
            answer = answer.substring(0, answer.length() - 5);
        }
//        if (!sb.isEmpty()) {
//            sb.delete(sb.length() - 5, sb.length()); //удаляем последнее "and"
//        }
        return answer;
    }
}
