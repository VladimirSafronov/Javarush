package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        Thread.State state = thread.getState();
        System.out.println(state);
        while (!state.equals(State.TERMINATED)) {
            if (!state.equals(thread.getState())) {
                state = thread.getState();
                System.out.println(state);
            }
        }
    }
}
