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
public class Rook extends Piece{
    private static final int[][] ROOK_MOVES = {
            {0, 1}, {1, 0},
            {0, -1}, {-1, 0}
    };
    Rook(int row, int column, Coalition pieceCoalition) {
        super(row, column, pieceCoalition);
    }

    @Override
    public Collection<Move> calculatePossibleMoves(Board board) {
        final List<Move> legalRookMoves = new ArrayList<>();

        int currentRow = this.getRow();
        int currentColumn = this.getColumn();
        for (final int[] rookMoves : ROOK_MOVES){
            int candidateDestinationRow = currentRow + rookMoves[0];
            int candidateDestinationColumn = currentColumn + rookMoves[1];

            while (board.isValidCoordinate(candidateDestinationRow, candidateDestinationColumn)){
                final Tile destinationTile = board.getTile(candidateDestinationRow, candidateDestinationColumn);
                if (!destinationTile.isTileOccupied()){
                    legalRookMoves.add(new NormalMove(board, this, candidateDestinationRow, candidateDestinationColumn));
                }else {
                    final Piece pieceOnDestination = destinationTile.getPiece();
                    if (this.getPieceCoalition() != pieceOnDestination.getPieceCoalition()){
                        legalRookMoves.add(new AttackMove(board, this, candidateDestinationRow, candidateDestinationColumn, pieceOnDestination));
                    }
                    break;
                }
                candidateDestinationRow += rookMoves[0];
                candidateDestinationColumn += rookMoves[1];
            }
        }

        return Collections.unmodifiableList(legalRookMoves);
    }
}
