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
public class Knight extends Piece{
    private static final int[][] KNIGHT_JUMPS = {
            {-2, 1}, {-1, 2}, {1, 2}, {2, 1},
            {-2, -1}, {-1, -2}, {1, -2}, {2, -1}
    };
    Knight(int row, int column, Coalition pieceCoalition) {
        super(row, column, pieceCoalition);
    }

    @Override
    public Collection<Move> calculatePossibleMoves(Board board) {
        final List<Move> legalKnightMoves = new ArrayList<>();

        int currentRow = this.getRow();
        int currentColumn = this.getColumn();

        for (int[] knightMoves : KNIGHT_JUMPS){
            int candidateDestinationRow = currentRow + knightMoves[0];
            int candidateDestinationColumn = currentColumn + knightMoves[1];

            if (board.isValidCoordinate(candidateDestinationRow, candidateDestinationColumn)){
                //TODO: might change the parameters of get tile from rows $ columns to coordinates
                final Tile destinationTile = board.getTile(candidateDestinationRow, candidateDestinationColumn);
                if (!destinationTile.isTileOccupied()){
                    legalKnightMoves.add(new NormalMove(board, this, candidateDestinationRow, candidateDestinationColumn));
                }else {
                    final Piece pieceOnDestination = destinationTile.getPiece();
                    if (this.getPieceCoalition() != pieceOnDestination.getPieceCoalition()){
                        legalKnightMoves.add(new AttackMove(board, this, candidateDestinationRow, candidateDestinationColumn, pieceOnDestination));
                    }
                }

            }
        }

        return Collections.unmodifiableList(legalKnightMoves);
    }
}
