package com.tests;

import com.engine.game.Game;
import com.engine.player.BlackPlayer;
import com.engine.player.WhitePlayer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GameTest {
    private Game chessGame;
    private BlackPlayer blackPlayer;
    private WhitePlayer whitePlayer;
    @Before
    public void setUp() {
        chessGame = new Game();
        chessGame.startGame();
    }
    @Test
    public void testInitializeGame() {
        Game game = new Game();
        game.initializeGame(whitePlayer, blackPlayer);
    }
    @Test
    public void testUndoLastMove() {
        chessGame.makeMove(6,4,4,4);
        chessGame.undoLastMove();
        assertEquals(chessGame.getCurrentTurn(), whitePlayer);
    }
}
