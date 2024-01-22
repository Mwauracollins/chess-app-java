package com.engine.board;

import com.engine.piece.Piece;

/**
 * Created by user on 01 19 2024
 **/
public class EmptyTile extends Tile{
    protected EmptyTile(int row, int column) {
        super(row, column);
    }

    @Override
    public Piece getPiece() {
        return null;
    }

    @Override
    public boolean isTileOccupied() {
        return false;
    }

    @Override
    public void setPiece(Piece pieceOnTile) {
        return;
    }

    @Override
    public String toString(){
        return "-";
    }
}
