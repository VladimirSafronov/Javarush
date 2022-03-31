package com.javarush.games.minigames.mini05;

import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Color;

/* 
Цвета радуги
*/

public class RainbowGame extends Game {

    @Override
    public void initialize() {
        Color[] rainbow = {
                Color.RED,
                Color.ORANGE,
                Color.YELLOW,
                Color.GREEN,
                Color.BLUE,
                Color.INDIGO,
                Color.VIOLET};
        setScreenSize(10, 7);
        for (int i = 0; i < getScreenWidth(); i ++) {
            for (int j = 0; j < getScreenHeight(); j ++) {
                setCellColor(i, j, rainbow[j]);
            }
        }
    }
}
