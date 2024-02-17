package com.tests;

import com.engine.Utils.Coalition;
import com.engine.board.Board;
import com.engine.game.KingCastleMove;
import com.engine.game.Move;
import com.engine.game.NormalMove;
import com.engine.piece.King;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class KingTest {
    private Board testBoard;
    @Before
    public void setup(){
        testBoard = new Board();
    }
    @Test
    public void testCalculatePossibleMoves() {
        King testKing = new King(3, 4, Coalition.BLACK, true, false);
        testBoard.getTile(0, 4).setPiece(testKing);

        Collection<Move> possibleMoves = testKing.calculatePossibleMoves(testBoard);
        System.out.println(possibleMoves);
        assertFalse(containsMove(possibleMoves, NormalMove.class, 0, 3));
        assertFalse(containsMove(possibleMoves, NormalMove.class, 1, 3));
        assertFalse(containsMove(possibleMoves, KingCastleMove.class, 0, 6));
    }
    @Test
    public void testIsFirstMove(){
        King testKing = new King(0, 4, Coalition.BLACK, true, false);
        assertTrue(testKing.isFirstMove());
    }
    @Test
    public void testIsCastled(){
        King testKing = new King(0, 4, Coalition.BLACK, true, false);
        assertTrue(!testKing.isCastled());
    }

    private boolean containsMove(Collection<Move> moves, Class<? extends Move> moveType, int destinationRow, int destinationColumn){
        for(Move move : moves){
            if(move.getClass().equals(moveType)
            && move.getDestinationRow() == destinationRow
            && move.getDestinationColumn() == destinationColumn){
                return true;
            }
        }
        return false;
    }
}
