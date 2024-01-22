package com.engine.game;

import com.engine.board.Board;
import com.engine.board.Tile;
import com.engine.piece.Piece;

/**
 * Created by user on 01 19 2024
 **/
public class Move {
    private final Board board;
    private final Piece movedPiece;
    private final int destinationRow;
    private final int destinationColumn;
    private final boolean isFirstMove;

    public Move(Board board, Piece movedPiece, int destinationRow, int destinationColumn){
        this.board = board;
        this.movedPiece = movedPiece;
        this.destinationRow = destinationRow;
        this.destinationColumn = destinationColumn;
        this.isFirstMove = movedPiece.isFirstMove();
    }

    public Board getBoard() {
        return this.board;
    }
    public int getCurrentRow(){
        return this.movedPiece.getRow();
    }
    public int getCurrentColumn(){
        return this.movedPiece.getColumn();
    }
    public int getCurrentCoordinate(){
        return this.movedPiece.getPiecePosition();
    }

    public int getDestinationRow() {
        return this.destinationRow;
    }

    public int getDestinationColumn() {
        return this.destinationColumn;
    }

    public Piece getMovedPiece() {
        return this.movedPiece;
    }
    public boolean isAttackMove(){
        return false;
    }
    public Piece getAttackedPiece(){
        return null;
    }

    public static Move createMove(Board board, Tile sourceTile, Tile destinationTile){
        Piece movedPiece = sourceTile.getPiece();
        int destinationRow = destinationTile.getRow();
        int destinationColumn = destinationTile.getColumn();

        return new Move(board, movedPiece, destinationRow, destinationColumn);
    }
    public static Board executeMove(){

        //TODO: Logic for doing a  move
        return null;
    }
    public Board undoMove(){
        //TODO: Logic for implementing undo move
        return null;
    }
    public boolean isCastlingMove(){
        return false;
    }
}
