package com.javarush.task.task19.task1918;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName;
        try (BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = fileNameReader.readLine();
        }

        StringBuilder sb = new StringBuilder();
        String line;
        try (BufferedReader input = new BufferedReader(new FileReader(fileName))) {
            while ((line = input.readLine()) != null) {
                sb.append(line);
            }
        }

        Document document = Jsoup.parse(sb.toString(), "", Parser.xmlParser());
        Elements elements = document.select(args[0]);
        for (Element e : elements) {
            System.out.println(e);
        }
    }
}
