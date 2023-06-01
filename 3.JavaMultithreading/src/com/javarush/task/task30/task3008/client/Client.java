package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    public class SocketThread extends Thread {
        @Override
        public void run() {
            super.run();
        }
    }

    protected String getServerAddress() {
        System.out.println("Введите адрес сервера: ");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        System.out.println("Введите номер порта: ");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        System.out.println("Введите имя пользователя: ");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Сообщение не было отправлено.");
            clientConnected = false;
        }
    }

    public void run() {
        Thread thread = getSocketThread();
        thread.setDaemon(true);
        thread.start();

        try {
            synchronized (this) {
                wait();
            }
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("Возникло исключение при попытке нити ожидать.");
            return;
        }

        if (clientConnected) {
            System.out.println("Соединение установлено. Для выхода наберите команду 'exit'.");
        } else {
            System.out.println("Произошла ошибка во время работы клиента.");
        }
        String messageStr = "";
        while (clientConnected && !messageStr.equals("exit")) {
            messageStr = ConsoleHelper.readString();
            if (shouldSendTextFromConsole()) {
                sendTextMessage(messageStr);
            }
        }
    }
}