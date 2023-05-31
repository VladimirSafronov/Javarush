package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        int portNumber = ConsoleHelper.readInt();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(portNumber);
            System.out.println("Сервер запущен.");
            while (true) {
                Handler handler = new Handler(serverSocket.accept());
                handler.start();
            }
        } catch (IOException e) {
            try {
                assert serverSocket != null;
                serverSocket.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            super.run();
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message response = null;
            do {
                connection.send(new Message(MessageType.NAME_REQUEST));
                response = connection.receive();
            } while (response.getType() != MessageType.USER_NAME
                    || response.getData() == null
                    || Objects.equals(response.getData(), "")
                    || connectionMap.containsKey(response.getData()));
            connectionMap.put(response.getData(), connection);
            connection.send(new Message(MessageType.NAME_ACCEPTED));
            ConsoleHelper.writeMessage(response.getData() + " отправлено");

            return response.getData();
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (String name : connectionMap.keySet()) {
                Message message = new Message(MessageType.USER_ADDED, name);
                if (!name.equals(userName)) {
                    connection.send(message);
                }
            }
        }
    }

    public static void sendBroadcastMessage(Message message) {
        for (Connection con : connectionMap.values()) {
            try {
                con.send(message);
            } catch (IOException e) {
                System.out.println("Сообщение не было отправлено.");
            }
        }
    }
}
