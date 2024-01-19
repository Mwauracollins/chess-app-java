package com.engine.piece;

import com.engine.Utils.Coalition;
import com.engine.board.Board;
import com.engine.game.Move;

import java.util.Collection;

/**
 * Created by user on 01 19 2024
 **/
public abstract class Piece {
    private Coalition pieceCoalition;
    private int row;
    private int column;

    Piece(final int row, int column, final Coalition pieceCoalition){
        this.row = row;
        this.column = column;
        this.pieceCoalition = pieceCoalition;
    }
    public Coalition getPieceCoalition(){
        return this.pieceCoalition;
    }
    public int getRow(){
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }
    public int getPiecePosition(){
        return (this.row * 8) + this.column;
    }
    public abstract Collection<Move> calculatePossibleMoves(Board board);
}
