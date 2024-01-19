package com.engine.board;

/**
 * Created by user on 01 19 2024
 **/
public class Board {
    private final Tile[][] boardTiles;

    public Board(Tile[][] boardTiles) {
        this.boardTiles = boardTiles;
    }

    public boolean isValidCoordinate(int row, int column) {
        return 0 <= row && row < 8 && 0 <= column && column < 8 ;
    }

    public Tile getTile(int row, int column) {
        if (isValidCoordinate(row, column)){
            return boardTiles[row][column];
        }
        return null;
    }
}
