package com.javarush.task.task35.task3513;

import java.util.*;

//будет содержать игровую логику и хранить игровое поле
public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int score;
    int maxTile;
    private Stack<Tile[][]> previousStates;
    private Stack<Integer> previousScores;
    private boolean isSaveNeeded = true;

    public Model() {
        this.score = 0;
        this.maxTile = 0;
        this.previousStates = new Stack<>();
        this.previousScores = new Stack<>();
        resetGameTiles();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
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
        if (isSaveNeeded) {
            saveState(gameTiles);
        }
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
        isSaveNeeded = true;
    }

    public void down() {
        saveState(gameTiles);
        rotation();
        left();
        for (int i = 0; i < 3; i++) {
            rotation();
        }
    }

    public void right() {
        saveState(gameTiles);
        rotation();
        rotation();
        left();
        rotation();
        rotation();
    }

    public void up() {
        saveState(gameTiles);
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

    /**
     * проверяет возможность сделать ход в текущей позиции
     *
     * @return
     */
    public boolean canMove() {
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[0].length; j++) {
                if (gameTiles[i][j].value == 0) {
                    return true;
                }
                if (i != gameTiles.length - 1 && gameTiles[i][j].value == gameTiles[i + 1][j].value) {
                    return true;
                }
                if (j != gameTiles[0].length - 1 && gameTiles[i][j].value == gameTiles[i][j + 1].value) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * сохраняет значения игрового поля и очков
     *
     * @param gameTiles
     */
    private void saveState(Tile[][] gameTiles) {
        Tile[][] dest = new Tile[gameTiles.length][gameTiles[0].length];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[0].length; j++) {
                dest[i][j] = new Tile(gameTiles[i][j].value);
            }
        }
        previousStates.push(dest);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    /**
     * восстанавливает сохраненные значения
     */
    public void rollback() {
        if (!previousStates.isEmpty() && !previousScores.isEmpty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    /**
     * Совершает рандомный ход
     */
    public void randomMove() {
        switch (((int) (Math.random() * 100)) % 4) {
            case 0:
                left();
                break;
            case 1:
                up();
                break;
            case 2:
                right();
                break;
            case 3:
                down();
                break;
        }
    }

    /**
     * Проверяет отличается ли вес всех плиток в gameTiles с весом сохраненного массива
     *
     * @return
     */
    public boolean hasBoardChanged() {
        Tile[][] savedTiles = previousStates.peek();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[0].length; j++) {
                if (gameTiles[i][j].value != savedTiles[i][j].value) {
                    return true;
                }
            }
        }
        return false;
    }

    private MoveEfficiency getMoveEfficiency(Move move) {
        move.move();
        MoveEfficiency moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        if (!hasBoardChanged()) {
            return new MoveEfficiency(-1, 0, move);
        }
        rollback();
        return moveEfficiency;
    }

    /**
     * Выбирает, и выполняет лучший из ходов
     */
    public void autoMove() {
        PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue<>(4, Collections.reverseOrder());
        priorityQueue.offer(getMoveEfficiency(this::left));
        priorityQueue.offer(getMoveEfficiency(this::up));
        priorityQueue.offer(getMoveEfficiency(this::right));
        priorityQueue.offer(getMoveEfficiency(this::down));

        Move move = Objects.requireNonNull(priorityQueue.poll()).getMove();
        move.move();
    }
}
