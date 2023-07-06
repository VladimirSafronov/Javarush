package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

//будет содержать игровую логику и хранить игровое поле
public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int maxTile;
    int score;

    public Model() {
        this.score = 0;
        this.maxTile = 0;
        resetGameTiles();
    }

    void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[0].length; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    /**
     * Возвращает список пустых ячеек
     *
     * @return
     */
    private List<Tile> getEmptyTiles() {
        List<Tile> tileList = new ArrayList<>();
        for (Tile[] gameTile : gameTiles) {
            for (int j = 0; j < gameTiles[0].length; j++) {
                if (gameTile[j].isEmpty()) {
                    tileList.add(gameTile[j]);
                }
            }
        }
        return tileList;
    }

    /**
     * Рандомно присваеваем рандомной ячейке из списка значение 2 или 4 (с вероятностью 9:1)
     */
    private void addTile() {
        List<Tile> tileList = getEmptyTiles();
        if (tileList.size() > 0) {
            int randomIndex = (int) (Math.random() * tileList.size());
            if (Math.random() < 0.9) {
                tileList.get(randomIndex).value = 2;
            } else {
                tileList.get(randomIndex).value = 4;
            }
        }
    }

    /**
     * Релизация слияния полей одного номинала (4, 4, 4, 0 -> 8, 4, 0, 0)
     *
     * @param tiles
     * @return были ли внесены изменения в массив
     */
    private boolean mergeTiles(Tile[] tiles) {
        boolean isChanged = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value == 0) {
                break;
            }
            if (tiles[i].value == tiles[i + 1].value) {
                tiles[i].value *= 2;
                score += tiles[i].value;
                isChanged = true;
                if (tiles[i].value > maxTile) {
                    maxTile = tiles[i].value;
                }
                tiles[i + 1].value = 0; //обнуляем следующее значение
                i++;
            }
        }
        if (isChanged) {
            compressTiles(tiles);
        }
        return isChanged;
    }

    /**
     * Реализация перемещения пустых полей в конец строки при ходе (4, 2, 0, 4 -> 4, 2, 4, 0)
     *
     * @param tiles
     * @return были ли внесены изменения в массив
     */
    private boolean compressTiles(Tile[] tiles) {
        //подсчитаем нули с конца
        int zeroCountFromTail = 0;
        for (int i = tiles.length - 1; i >= 0; i--) {
            if (tiles[i].value != 0) {
                break;
            } else {
                zeroCountFromTail++;
            }
            if (zeroCountFromTail == tiles.length) { //если одни нули, то никаких манипуляций делать не нужно
                return false;
            }
        }

        int zeroCount = 0;
        for (int i = 0; i < tiles.length; i++) {
            if (tiles[i].value != 0) {
                tiles[i - zeroCount].value = tiles[i].value;
            } else {
                zeroCount++;
            }
        }

        if (zeroCount == zeroCountFromTail) { //означает, что все нули были вконце
            return false;
        }

        for (int i = tiles.length - 1; i > tiles.length - 1 - zeroCount; i--) { //заполняем конец массива нулями
            tiles[i].value = 0;
        }

        return true;
    }

    /**
     * сдвигает поля влево
     */
    public void left() {
        boolean flag = false;
        for (int i = 0; i < gameTiles.length; i++) {
            compressTiles(gameTiles[i]);
            if (mergeTiles(gameTiles[i])) {
                flag = true;
            }
        }
        if (flag) { //по правилам нужно добавить плитку только единажды
            addTile();
        }
    }

    public void down() {
        rotation();
        left();
        for (int i = 0; i < 3; i++) {
            rotation();
        }
    }

    public void right() {
        rotation();
        rotation();
        left();
        rotation();
        rotation();
    }

    public void up() {
        for (int i = 0; i < 3; i++) {
            rotation();
        }
        left();
        rotation();
    }

    /**
     * поворачивает матрицу по часовой стрелке
     */
    private void rotation() {
        //заполняем временный массив
        Tile[][] dest = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[0].length; j++) {
                dest[j][FIELD_WIDTH - 1 - i] = gameTiles[i][j]; //по формуле устанавливаем значения как будто повернули исходный по часовой стрелке
            }
        }

        for (int i = 0; i < dest.length; i++) {
            for (int j = 0; j < dest[0].length; j++) {
                gameTiles[i][j] = dest[i][j];
            }
        }
    }
}
