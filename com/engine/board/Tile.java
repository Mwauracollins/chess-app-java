package com.engine.board;

import com.engine.piece.Piece;

/**
 * Created by user on 01 19 2024
 **/
public abstract class Tile {
    private int row;
    private int column;

    protected Tile(final int row, final int column){
        this.row = row;
        this.column = column;
    }
    public abstract Piece getPiece();

    public abstract boolean isTileOccupied();
    public int getTileId(){
        return (row * 8) + column;
    }
    public abstract void setPiece(Piece pieceOnTile);

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }
}
