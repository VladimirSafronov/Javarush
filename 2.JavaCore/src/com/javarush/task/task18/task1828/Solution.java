package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static class Product {
        int id;
        String productName;
        String price;
        String quantity;

        public Product(int id, String productName, String price, String quantity) {
            this.id = id;
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
        }

        public int getId() {
            return this.id;
        }

        @Override
        public String toString() {
            return String.format("%-8d%-30s%-8s%-4s", id, productName, price, quantity);
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            return;
        }

        String fileName = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = "/Users/vladimirsafronov/Desktop/file.txt"; //br.readLine();
        }

        List<Product> products = new ArrayList<>();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName)); //перезаписывает файл, выставляя true, будет дозаписывать
        BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            while (reader.ready()) {
                Product product = getProduct(reader.readLine());
                products.add(product);
            }

            switch (args[0]) {
                case "-u": {
                    int id = Integer.parseInt(args[1]);
                    String name = "";
                    for (int i = 2; i < args.length - 2; i++) {
                        name += args[i] + " ";
                    }
                    if (name.length() > 30) {
                        name = name.substring(0, 30);
                    }
                    String price = args[args.length - 2];
                    if (price.length() > 8) {
                        price = price.substring(0, 8);
                    }
                    String quantity = args[args.length - 1];
                    if (quantity.length() > 4) {
                        quantity = quantity.substring(0, 4);
                    }
                    Product productToUpdate = null;
                    for (Product product : products) {
                        if (product.id == id) productToUpdate = product;
                    }
                    if (productToUpdate != null) {
                        productToUpdate.productName = name;
                        productToUpdate.price = price;
                        productToUpdate.quantity = quantity;
                    }
                    products.add(new Product(id, name, price, quantity));
                    break;
                }
                case "-d": {
                    int id = Integer.parseInt(args[1]);
                    Product productToDelete = null;
                    for (Product product : products) {
                        if (product.id == id) productToDelete = product;
                    }
                    if (productToDelete != null) {
                        products.remove(productToDelete);
                    }
                    break;
                }
            }
            for(Product p : products) {
                writer.write(p.toString());
                writer.write("\n");
            }
            //можно производить запись (с аргументом true) в новый файл, и переименовывать его в исходный
        }
    }

    public static Product getProduct(String line) {
        String id = line.substring(0, 8).trim();
        String productName = line.substring(8, 38).trim();
        String price = line.substring(38, 46).trim();
        String quantity = line.substring(46, 50).trim();
        return new Product(Integer.parseInt(id), productName, price, quantity);
    }
}
