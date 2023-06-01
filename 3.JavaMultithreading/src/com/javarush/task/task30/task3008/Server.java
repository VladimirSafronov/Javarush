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
            ConsoleHelper.writeMessage("Установлено соединение с " + socket.getRemoteSocketAddress().toString());
            String userName = null;
            try {
                Connection connection = new Connection(socket);
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection, userName);
                serverMainLoop(connection, userName);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом.");
            } finally {
                if (userName != null) {
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                    ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто.");
                }
            }
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

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    String textMsg = userName + ": " + message.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, textMsg));
                } else {
                    ConsoleHelper.writeMessage("Сообщение не является текстом.");
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
