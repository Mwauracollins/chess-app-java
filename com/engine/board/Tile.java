package com.engine.board;

import com.engine.piece.Piece;

/**
 * Created by user on 01 19 2024
 **/
public  class Tile {
    private int row;
    private int column;
    private Piece pieceOnTile;

    protected Tile(final int row, final int column, Piece pieceOnTile){
        this.row = row;
        this.column = column;
        this.pieceOnTile = pieceOnTile;
    }

    public Piece getPiece() {
        return this.pieceOnTile;
    }

    public boolean isTileOccupied() {
        return this.pieceOnTile != null;
    }

    public int getTileId(){
        return (row * 8) + column;
    }

    public void setPiece(Piece pieceOnTile) {
        this.pieceOnTile = pieceOnTile;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }
    @Override
    public String toString(){
        if(isTileOccupied()) {
            return this.pieceOnTile.toString();
        }
        else {
            return "-";
        }
    }
}
