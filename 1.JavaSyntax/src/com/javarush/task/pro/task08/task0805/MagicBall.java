package com.javarush.task.pro.task08.task0805;

import java.util.Random;

public class MagicBall {
    private static final String CERTAIN = "Бесспорно";
    private static final String DEFINITELY = "Определённо да";
    private static final String MOST_LIKELY = "Вероятнее всего";
    private static final String OUTLOOK_GOOD = "Хорошие перспективы";
    private static final String ASK_AGAIN_LATER = "Спроси позже";
    private static final String TRY_AGAIN = "Попробуй снова";
    private static final String NO = "Мой ответ — нет";
    private static final String VERY_DOUBTFUL = "Весьма сомнительно";
    public static String[] answer = {CERTAIN, DEFINITELY, MOST_LIKELY, OUTLOOK_GOOD, ASK_AGAIN_LATER, TRY_AGAIN, NO, VERY_DOUBTFUL};

    public static String getPrediction() {
        int number = randomNumber();
        if (number >= 0 && number < 8)
        {
            return answer[number];
        }
        else return null;

    }

    public static int randomNumber() {
        Random r = new Random();
        return r.nextInt(8);
    }
}
