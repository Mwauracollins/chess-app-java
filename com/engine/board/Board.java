package com.engine.board;

import com.engine.Utils.Coalition;
import com.engine.piece.*;
import com.engine.player.BlackPlayer;
import com.engine.player.Player;
import com.engine.player.WhitePlayer;

/**
 * Created by user on 01 19 2024
 **/
public class Board {
    private Tile[][] gameBoard;
    private Piece[][] pieces;
    private WhitePlayer whitePlayer;
    private BlackPlayer blackPlayer;
    private Player currentPlayer;

    public Board(){
        this.gameBoard = createGameBoard();
    }

    private Tile[][] createGameBoard() {
        gameBoard = new Tile[8][8];

        gameBoard[0][0] = new OccupiedTile(0, 0, new Rook(0, 0, Coalition.WHITE, true));
        gameBoard[0][1] = new OccupiedTile(0, 1, new Knight(0, 1, Coalition.WHITE, true));
        gameBoard[0][2] = new OccupiedTile(0, 2, new Bishop(0, 2, Coalition.WHITE, true));
        gameBoard[0][3] = new OccupiedTile(0, 3, new King(0, 3, Coalition.WHITE, true, false));
        gameBoard[0][4] = new OccupiedTile(0, 4, new Queen(0, 4, Coalition.WHITE, true));
        gameBoard[0][5] = new OccupiedTile(0, 5, new Bishop(0, 5, Coalition.WHITE, true));
        gameBoard[0][6] = new OccupiedTile(0, 6, new Knight(0, 6, Coalition.WHITE, true));
        gameBoard[0][7] = new OccupiedTile(0, 7, new Rook(0, 7, Coalition.WHITE, true));

        gameBoard[7][0] = new OccupiedTile(7, 0, new Rook(7, 0, Coalition.BLACK, true));
        gameBoard[7][1] = new OccupiedTile(7, 1, new Knight(7, 1, Coalition.BLACK, true));
        gameBoard[7][2] = new OccupiedTile(7, 2, new Bishop(7, 2, Coalition.BLACK, true));
        gameBoard[7][3] = new OccupiedTile(7, 3, new King(7, 3, Coalition.BLACK, true, false));
        gameBoard[7][4] = new OccupiedTile(7, 4, new Queen(7, 4, Coalition.BLACK, true));
        gameBoard[7][5] = new OccupiedTile(7, 5, new Bishop(7, 5, Coalition.BLACK, true));
        gameBoard[7][6] = new OccupiedTile(7, 6, new Knight(7, 6, Coalition.BLACK, true));
        gameBoard[7][7] = new OccupiedTile(7, 7, new Rook(7, 7, Coalition.BLACK, true));

        for (int column = 0; column < 8; column++){
            gameBoard[1][column] = new OccupiedTile(1, column, new Pawn(1, column, Coalition.WHITE, true));
            gameBoard[6][column] = new OccupiedTile(6, column, new Pawn(6, column, Coalition.BLACK, true));
        }
        for (int row = 2; row < 6; row++){
            for (int column = 0; column < 8; column++){
                gameBoard[row][column] = new EmptyTile(row, column);
            }
        }
        return gameBoard;
    }


    public boolean isValidCoordinate(int row, int column) {
        return 0 <= row && row < 8 && 0 <= column && column < 8 ;
    }

    public Tile getTile(int row, int column) {
        if (isValidCoordinate(row, column)){
            return gameBoard[row][column];
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder boardString = new StringBuilder();

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Tile tile = gameBoard[row][col];
                boardString.append(tile.toString()).append(" ");
            }
            boardString.append("\n");
        }

        return boardString.toString();
    }

    public static void main(String[] args) {
        Board chessBoard = new Board();
        System.out.println(chessBoard);
    }
}
