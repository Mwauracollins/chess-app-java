package com.engine.board;

import com.engine.piece.Piece;

/**
 * Created by user on 01 19 2024
 **/
public class OccupiedTile extends Tile{
    private Piece pieceOnTile;
    protected OccupiedTile(int row, int column, Piece pieceOnTile) {
        super(row, column);
        this.pieceOnTile = pieceOnTile;
    }

    @Override
    public Piece getPiece() {
        return this.pieceOnTile;
    }
    @Override
    public void setPiece(Piece pieceOnTile){
        this.pieceOnTile = pieceOnTile;
    }

    @Override
    public boolean isTileOccupied() {
        return true;
    }

    @Override
    public String toString(){
        return this.pieceOnTile.toString();
    }
}
