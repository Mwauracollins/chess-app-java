package com.engine.game;

import com.engine.board.Board;
import com.engine.piece.King;
import com.engine.piece.Piece;
import com.engine.piece.Rook;

public class KingCastleMove extends CastleMove{
    public KingCastleMove(Board board, Piece movedPiece, int destinationRow, int destinationColumn) {
        super(board, movedPiece, destinationRow, destinationColumn);
    }

    public boolean isCastlingMove(){
        return true;
    }

    public Board execute(){
        Board transitionBoard = new Board();

        //Check if castling is valid
        if (((King) this.getMovedPiece()).isCastlingPossible(transitionBoard, this.getDestinationColumn())){

            //Update King Position
            transitionBoard.getTile(this.getDestinationRow(), this.getDestinationColumn()).setPiece(this.getMovedPiece());
            ((King) this.getMovedPiece()).setRow(this.getDestinationRow());
            ((King) this.getMovedPiece()).setColumn(this.getDestinationColumn());

            //Update Rook Position
            int rookColumn = this.getCurrentColumn() == 6 ? 7 : 0;//For both king and queen side
            Rook rook = (Rook) transitionBoard.getTile(this.getDestinationRow(), rookColumn).getPiece();
            transitionBoard.getTile(this.getDestinationRow(), rookColumn).setPiece(null);
            transitionBoard.getTile(this.getDestinationRow(), this.getDestinationColumn() - 1).setPiece(rook);
            rook.setRow(this.getDestinationRow());
            rook.setColumn(this.getDestinationColumn() - 1);

            return transitionBoard;

        }
        return this.getBoard();
    }

}
