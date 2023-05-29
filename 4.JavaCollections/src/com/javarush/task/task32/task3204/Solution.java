package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* 
Генератор паролей
*/

//цифры 48-57; Б.буквы 65-90; м.буквы 97-122

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        int passwordLength = 8;
        byte[] password = new byte[passwordLength];
        fillPassword(password);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            outputStream.write(password);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream;
    }

    private static byte getRandom(int min, int max) {
        max -= min;
        return (byte) ((byte) (Math.random() * ++max) + min);
    }

    private static void fillPassword(byte[] password) {
        password[0] = getRandom(48, 57);
        password[1] = getRandom(65, 90);
        password[2] = getRandom(97, 122);
        for (int i = 3; i < password.length; i++) {
            int numberOrLetter = (int) (Math.random() * 3);
            switch (numberOrLetter) {
                case 0:
                    password[i] = getRandom(48, 57);
                    break;
                case 1:
                    password[i] = getRandom(65, 90);
                    break;
                case 2:
                    password[i] = getRandom(97, 122);
                    break;
            }
        }
    }
}
