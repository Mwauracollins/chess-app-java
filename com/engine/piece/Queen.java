package com.engine.piece;

import com.engine.Utils.Coalition;
import com.engine.board.Board;
import com.engine.board.Tile;
import com.engine.game.AttackMove;
import com.engine.game.Move;
import com.engine.game.NormalMove;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by user on 01 19 2024
 **/
public class Queen extends Piece{
    private static final int[][] QUEEN_CROSSES = {
            {0, 1}, {1, 0},
            {0, -1}, {-1, 0},
            {-1, -1}, {-1, 1}, {1, 1}, {1, -1}
    };
    public Queen(int row, int column, Coalition pieceCoalition, boolean isFirstMove) {
        super(row, column, pieceCoalition, isFirstMove);
    }

    @Override
    public Collection<Move> calculatePossibleMoves(Board board) {
        final List<Move> legalQueenMoves = new ArrayList<>();

        int currentRow = this.getRow();
        int currentColumn = this.getColumn();

        for (final int[] queenMove : QUEEN_CROSSES){
            int candidateDestinationRow = currentRow + queenMove[0];
            int candidateDestinationColumn = currentColumn + queenMove[1];

            while (board.isValidCoordinate(candidateDestinationRow, candidateDestinationColumn)){
                final Tile destinationTile = board.getTile(candidateDestinationRow, candidateDestinationColumn);

                if (!destinationTile.isTileOccupied()){
                    legalQueenMoves.add(new NormalMove(board, this, candidateDestinationRow, candidateDestinationColumn));
                }else {
                    final Piece pieceOnDestination = destinationTile.getPiece();
                    if (this.getPieceCoalition() != pieceOnDestination.getPieceCoalition()){
                        legalQueenMoves.add(new AttackMove(board, this, candidateDestinationRow, candidateDestinationColumn, pieceOnDestination));
                    }
                    break;
                }
                candidateDestinationRow += queenMove[0];
                candidateDestinationColumn += queenMove[1];;
            }
        }
        return Collections.unmodifiableList(legalQueenMoves);
    }

    @Override
    public boolean isFirstMove() {
        return false;
    }
    @Override
    public String toString(){
        if (this.getPieceCoalition() == Coalition.WHITE){
            return "Q";
        }return "q";
    }
}
