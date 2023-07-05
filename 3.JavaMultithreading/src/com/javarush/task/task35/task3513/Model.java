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
     */
    private void mergeTiles(Tile[] tiles) {
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value == 0) {
                break;
            }
            if (tiles[i].value == tiles[i + 1].value) {
                tiles[i].value *= 2;
                score += tiles[i].value;
                if (tiles[i].value > maxTile) {
                    maxTile = tiles[i].value;
                }
                tiles[i + 1].value = 0; //обнуляем следующее значение
                i++;
            }
        }
        compressTiles(tiles);
    }

    /**
     * Реализация перемещения пустых полей в конец строки при ходе (4, 2, 0, 4 -> 4, 2, 4, 0)
     *
     * @param tiles
     */
    private void compressTiles(Tile[] tiles) {
        int zeroCount = 0;
        for (int i = 0; i < tiles.length; i++) {
            if (tiles[i].value != 0) {
                tiles[i - zeroCount].value = tiles[i].value;
            } else {
                zeroCount++;
            }
        }
        for (int i = tiles.length - 1; i > tiles.length - 1 - zeroCount; i--) {
            tiles[i].value = 0;
        }
    }
}
