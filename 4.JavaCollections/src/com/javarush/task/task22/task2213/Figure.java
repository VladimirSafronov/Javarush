package com.javarush.task.task22.task2213;

//класс будет описывать падающую фигурку
public class Figure {
    private int x;
    private int y;
    private int[][] matrix; //отвечает за отрисовку фигуры

    public Figure(int x, int y, int[][] matrix) {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    void left() {
    }

    void right() {
    }

    void down() {
    }

    void up() {
    }

    void rotate() {
    }

    void downMaximum() {
    }

    /**
     * Может ли фигура помещена в данную позицию
     *
     * @return
     */
    boolean isCurrentPositionAvailable() {
        return true;
    }

    /**
     * вызывается, когда фигурка достигла дна или уперлась в другую фигурку
     * Все ее занятые клетки теперь должны добавиться в Field
     */
    void landed() {
    }
}
