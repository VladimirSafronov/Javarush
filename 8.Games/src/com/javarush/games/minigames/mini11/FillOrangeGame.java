package com.javarush.games.minigames.mini11;

import com.javarush.engine.cell.Color;

/* 
Закрашиваем поле
*/

public class FillOrangeGame extends FillGame {

    @Override
    public void fill() {
        for (int i = 0; i < getScreenHeight(); i++) {
            for (int j = 0; j < getScreenWidth(); j++){
                setCellColor(i, j, Color.ORANGE);
            }
        }
    }
}
