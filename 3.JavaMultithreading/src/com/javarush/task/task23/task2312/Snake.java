package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public List<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public Snake(int x, int y) {
        sections = new ArrayList<>();
        sections.add(new SnakeSection(x, y));
        this.isAlive = true;
    }

    public int getX() {
        return sections.get(0).getX();
    }

    public int getY() {
        return sections.get(0).getY();
    }

    public void move() {
        if (!isAlive()) {
            return;
        }
        switch (direction) {
            case UP:
                move(0, -1);
                break;
            case RIGHT:
                move(1, 0);
                break;
            case LEFT:
                move(-1, 0);
                break;
            case DOWN:
                move(0, 1);
                break;
        }
    }

    public void move(int dx, int dy) {
        SnakeSection snakeSection = new SnakeSection(sections.get(0).getX() + dx, sections.get(0).getY() + dy);
        checkBorders(snakeSection);
        checkBody(snakeSection);
        if (isAlive) {
            if (Room.game.getMouse().getX() == snakeSection.getX() &&
                    Room.game.getMouse().getY() == snakeSection.getY()) {
                Room.game.eatMouse();
                sections.add(0, snakeSection);
            } else {
                sections.add(0, snakeSection);
                sections.remove(sections.size() - 1);
            }
        }
    }

    public void checkBorders(SnakeSection head) {
        if (head.getY() < 0 || head.getY() >= Room.game.getHeight() ||
                head.getX() < 0 || head.getX() >= Room.game.getWidth()) {
            isAlive = false;
        }
    }

    public void checkBody(SnakeSection head) {
        if (sections.contains(head)) {
            isAlive = false;
        }
    }
}
