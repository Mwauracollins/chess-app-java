package com.engine.game;

import com.engine.board.Board;
import com.engine.piece.Knight;
import com.engine.piece.Piece;

/**
 * Created by user on 01 19 2024
 **/
public class AttackMove extends Move{
    private Piece attackedPiece;
    public AttackMove(Board board, Piece movedPiece, int destinationRow, int destinationColumn, Piece attackedPiece) {
        super(board, movedPiece, destinationRow, destinationColumn);
        this.attackedPiece = attackedPiece;
    }
}
