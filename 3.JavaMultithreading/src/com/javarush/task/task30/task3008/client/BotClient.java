package com.javarush.task.task30.task3008.client;

public class BotClient extends Client {

    public static void main(String[] args) {
        BotClient bot = new BotClient();
        bot.run();
    }

    public class BotSocketThread extends SocketThread {

    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int) (Math.random() * 100);
    }
}
