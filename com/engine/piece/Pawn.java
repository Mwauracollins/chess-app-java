package com.engine.piece;

import com.engine.Utils.Coalition;
import com.engine.board.Board;
import com.engine.board.Tile;
import com.engine.game.Move;
import com.engine.game.NormalMove;

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
    }
    Pawn(int row, int column, Coalition pieceCoalition) {
        super(row, column, pieceCoalition);
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
                candidateDestinationRow = currentRow + 2 * direction;
                if (this.isFirstMove)
            }
        }
        return Collections.unmodifiableList(legalPawnMoves);
    }
}
