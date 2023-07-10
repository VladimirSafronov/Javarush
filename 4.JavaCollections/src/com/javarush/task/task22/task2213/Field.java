package com.javarush.task.task22.task2213;

public class Field {
    private int width;
    private int height;
    private int[][] matrix;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new int[height][width];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    /**
     * Отрисовывет на экране текущее состояние
     */
    void print() {
    }

    /**
     * Удаляет из матрицы полностью заполненные строки и сдвигать вышележащие строки вниз
     */
    void removeFullLines() {
    }

    /**
     * Возвращает значение которое находится в матрице с координатами x и y
     *
     * @param x
     * @param y
     * @return
     */
    Integer getValue(int x, int y) {
        return null;
    }

    /**
     * Устанавливает переданное значение в ячейку массива (матрицы) с координатами x, y
     *
     * @param x
     * @param y
     * @param value
     */
    void setValue(int x, int y, int value) {

    }
}
