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
public class Bishop extends Piece{
    private static final int[][] BISHOP_DIAGS = {
            {-1, -1}, {-1, 1}, {1, 1}, {1, -1}
    };

    Bishop(int row, int column, Coalition pieceCoalition) {
        super(row, column, pieceCoalition);
    }

    @Override
    public Collection<Move> calculatePossibleMoves(Board board) {
        final List<Move> legalBishopMoves = new ArrayList<>();

        int currentRow = this.getRow();
        int currentColumn = this.getColumn();

        for (int[] bishopDiag : BISHOP_DIAGS){
            int candidateDestinationRow = currentRow + bishopDiag[0];
            int candidateDestinationColumn = currentColumn + bishopDiag[1];

            while (board.isValidCoordinate(candidateDestinationRow, candidateDestinationColumn)){
                final Tile destinationTile = board.getTile(candidateDestinationRow, candidateDestinationColumn);

                if (!destinationTile.isTileOccupied()){
                    legalBishopMoves.add(new NormalMove(board, this, candidateDestinationRow,candidateDestinationColumn));
                }else {
                    final Piece pieceOnDestination = destinationTile.getPiece();
                    if (this.getPieceCoalition() != pieceOnDestination.getPieceCoalition()){
                        legalBishopMoves.add(new AttackMove(board, this, candidateDestinationRow, candidateDestinationColumn, pieceOnDestination));
                    }
                    break; //TODO: check if this is correct if a bishop meets an opponent
                }
                candidateDestinationRow += bishopDiag[0];
                candidateDestinationColumn += bishopDiag[1];
            }
        }
        return Collections.unmodifiableList(legalBishopMoves);
    }
}
