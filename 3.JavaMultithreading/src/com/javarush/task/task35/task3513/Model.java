package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

//будет содержать игровую логику и хранить игровое поле
public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;

    public Model() {
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
}
