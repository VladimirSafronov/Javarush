package com.javarush.task.pro.task09.task0914;

/* 
Обновление пути
*/

public class Solution {
    public static void main(String[] args) {
        String path = "/usr/java/jdk1.8/bin/";

        String jdk13 = "jdk-13";
        System.out.println(changePath(path, jdk13));
    }

    public static String changePath(String path, String jdk) {
        int jdkIndex = path.indexOf("jdk"); //не стал создавать переменную, оставив магическое слово "jdk"
        String firstPart = path.substring(0, jdkIndex);
        int jdkEndIndex = path.indexOf('/', jdkIndex);
        String lastPart = path.substring(jdkEndIndex);
        return firstPart + jdk + lastPart;
    }
}
