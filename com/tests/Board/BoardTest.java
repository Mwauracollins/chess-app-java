package com.tests.Board;
import com.engine.board.Board;

import com.engine.board.Tile;
import com.engine.piece.Knight;
import com.engine.player.WhitePlayer;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    @Test
    public void testGetTile() {
        Board board = new Board();
        assertNotNull(board.getTile(0, 0));
        assertNotNull(board.getTile(7, 7));
        assertNotNull(board.getTile(8, 4));
    }
    @Test
    public void testIsValidCoordinate() {
        Board board = new Board();
        assertTrue(board.isValidCoordinate(0, 0));
        assertTrue(board.isValidCoordinate(7, 7));
        assertTrue(!board.isValidCoordinate(-2, 4));
    }
    @Test
    public void testCreateGameBoard() {
        Board board = new Board();
        Tile[][] gameBoard = board.createGameBoard();
        assertNotNull(gameBoard);
    }
    @Test
    public void testPlayerTransition(){
        Board board = new Board();
        assertEquals(board.getCurrentPlayer(), new WhitePlayer());
        board.playerTransition();
        assertEquals(board.getCurrentPlayer(), board.blackPlayer);
    }
    @Test
    public void testKnightMovement(){
        Board board = new Board();
        assertTrue(board.isValidCoordinate(0, 1));
        assertTrue(board.getTile(0, 1).getPiece() instanceof Knight);
    }
}
