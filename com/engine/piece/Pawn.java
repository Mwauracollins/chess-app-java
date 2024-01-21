package com.engine.piece;

import com.engine.Utils.Coalition;
import com.engine.board.Board;
import com.engine.board.Tile;
import com.engine.game.AttackMove;
import com.engine.game.Move;
import com.engine.game.NormalMove;
import com.engine.game.PawnJump;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by user on 01 19 2024
 **/
public class Pawn extends Piece{

    private static final int[][] PAWN_MOVES = {
            {1, 0}, {2, 0}, {1, 1}, {1, -1}
    };
    public Pawn(int row, int column, Coalition pieceCoalition, boolean isFirstMove) {
        super(row, column, pieceCoalition, isFirstMove);
    }

    @Override
    public Collection<Move> calculatePossibleMoves(Board board) {
        final List<Move> legalPawnMoves = new ArrayList<>();

        int currentRow = this.getRow();
        int currentColumn = this.getColumn();
        int direction = (this.getPieceCoalition() == Coalition.WHITE) ? 1 : -1;

        int candidateDestinationRow = currentRow + direction;
        int candidateDestinationColumn = currentColumn;

        if (board.isValidCoordinate(candidateDestinationRow, candidateDestinationColumn)){
            final Tile destinationTile = board.getTile(candidateDestinationRow, candidateDestinationColumn);

            if (!destinationTile.isTileOccupied()){
                legalPawnMoves.add(new NormalMove(board, this, candidateDestinationRow, candidateDestinationColumn));

                //For the pawn Jump. Track if the pawn has moved
                candidateDestinationRow = currentRow + (direction * 2);
                if (this.isFirstMove() && board.isValidCoordinate(candidateDestinationRow, candidateDestinationColumn)){
                    legalPawnMoves.add(new PawnJump(board, this, candidateDestinationRow, candidateDestinationColumn));
                }
            }
        }
        for (int[] pawnMove : PAWN_MOVES){
            candidateDestinationRow = currentRow + direction * pawnMove[0];
            candidateDestinationColumn = currentColumn + pawnMove[1];

            if (board.isValidCoordinate(candidateDestinationRow, candidateDestinationColumn)){
                final Tile destinationTile = board.getTile(candidateDestinationRow, candidateDestinationColumn);

                if (pawnMove[1] != 0){
                    if (destinationTile.isTileOccupied()){
                        final Piece pieceOnDestination = destinationTile.getPiece();

                        if (this.getPieceCoalition() != pieceOnDestination.getPieceCoalition()){
                            legalPawnMoves.add(new AttackMove(board, this, candidateDestinationRow, candidateDestinationColumn, pieceOnDestination));
                        }
                    }
                }
            }
        }
        return Collections.unmodifiableList(legalPawnMoves);
    }

    @Override
    public boolean isFirstMove() {
        return this.isFirstMove;
    }
    @Override
    public String toString(){
        if (this.getPieceCoalition() == Coalition.WHITE){
            return "P";
        }return "p";
    }
}
