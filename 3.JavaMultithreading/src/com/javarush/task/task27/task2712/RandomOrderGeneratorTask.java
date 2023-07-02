package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.TestOrder;

import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {
    private List<Tablet> tablets;
    private int interval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.tablets = tablets;
        this.interval = interval;
    }

    @Override
    public void run() {
        while (true) {
            Tablet tablet = tablets.get(TestOrder.rnd(0, tablets.size() - 1));
            try {
                tablet.createTestOrder();
                Thread.sleep(interval);
            } catch (InterruptedException e) {

            }
        }
    }
}
