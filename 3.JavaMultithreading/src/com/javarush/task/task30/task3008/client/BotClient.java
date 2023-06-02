package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BotClient extends Client {

    public static void main(String[] args) {
        BotClient bot = new BotClient();
        bot.run();
    }

    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String[] nameAndText = message.split(": ");
            if (nameAndText.length != 2) {
                return;
            }
            String name = nameAndText[0];
            String text = nameAndText[1];
            switch (text) {
                case "дата":
                    createBotAnswer(name, "d.MM.YYYY");
                    break;
                case "день":
                    createBotAnswer(name, "d");
                    break;
                case "месяц":
                    createBotAnswer(name, "MMMM");
                    break;
                case "год":
                    createBotAnswer(name, "YYYY");
                    break;
                case "время":
                    createBotAnswer(name, "H:mm:ss");
                    break;
                case "час":
                    createBotAnswer(name, "H");
                    break;
                case "минуты":
                    createBotAnswer(name, "m");
                    break;
                case "секунды":
                    createBotAnswer(name, "s");
                    break;
            }
        }

        private void createBotAnswer(String userName, String format) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            Date calendar = Calendar.getInstance().getTime();
            BotClient.this.sendTextMessage("Информация для " + userName + ": " + simpleDateFormat.format(calendar));
        }
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
