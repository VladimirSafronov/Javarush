package com.javarush.task.task27.task2712.ad;

public class Advertisement {
    private Object content; //видео
    private String name;
    private long initialAmount; //стоимость рекламы в копейках
    private int hits; //количество оплаченных показов
    private int duration; //продолжительность в секундах
    private long amountPerOneDisplaying; //стоимость одного показа рекламного объявления в копейках

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        this.amountPerOneDisplaying = hits > 0 ? initialAmount / hits : 0;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public int getHits() {
        return hits;
    }

    public void revalidate() {
        if (hits == 0) {
            throw new UnsupportedOperationException();
        }
        hits--;
    }

    public boolean isActive() {
        return hits > 0;
    }

    @Override
    public String toString() {
        return name + " is displaying... " + amountPerOneDisplaying + ", " + amountPerOneDisplaying * 1000 / duration;
    }
}
