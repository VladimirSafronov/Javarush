package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private GameObject [][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;

    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        int randomNumber = 5;
        for (int i = 0; i < gameField[0].length; i++) {
            for (int j = 0; j < gameField[1].length; j++) {
                GameObject gameObject = new GameObject(j, i, randomNumber == getRandomNumber(10));
                gameField[i][j] = gameObject;
                if (gameObject.isMine) {
                    countMinesOnField++;
                }
                setCellColor(i, j, Color.AQUA);
            }
        }
    }
}
