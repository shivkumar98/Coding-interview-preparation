package tictactoe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TicTacToeTest {

    @Test
    public void test_tic_tac_toe_returns_pending_when_move_is_pending(){
        int[][] moves = new int[][] {};
        String result = TicTacToe.tictactoe(moves);
        assertEquals("Pending", result);
    }

    @Test
    public void test_player_1_wins_returnsA(){
        int[][] moves = new int[][] {{0,0}, {2,0}, {1,1}, {2,1}, {2,2}};

        String result = TicTacToe.tictactoe(moves);
        assertEquals("A", result);
    }

    @Test
    public void testGridIsFullAndNoWinnersReturnsDraw(){
        int[][] moves = new int[][] {{0,0},{1,1},{2,0},{1,0},{1,2},{2,1},{0,1},{0,2},{2,2}};
        String result = TicTacToe.tictactoe(moves);
        assertEquals("Draw", result);
    }

    @Test
    public void threeInRowReturnsTrueForPlayerA(){

        int[][] moves = new int[][] {{0,0},{9,9},{1,0},{9,9},{2,0},{9,9}};

        boolean threeInRow = TicTacToe.threeInRowForA(moves);
        assertEquals(true, threeInRow);
    }

    @Test
    public void noThreeXsInRowReturnsFalse(){
        int[][] moves = new int[][] {{0,1},{0,0},{1,0},{0,0},{1,2},{0,0},{2,0},{0,0},{2,2}};
        /*
        | O X O |
        | X O X |
        | X O X |
        */
        boolean result = TicTacToe.threeInRowForA(moves);
        assertEquals(false,result);
    }

    @Test
    public void threeXsOnMainDiagnolReturnsTrue(){
        int[][] moves = new int[][] {{0,0},{103,104},{1,1},{105,106},{2,2},{107,107}};
        boolean result = TicTacToe.threeInRowForA(moves);
        assertEquals(true,result);
    }

    @Test
    public void threeXsOnAlternateDiagnolReturnsTrue(){
        int[][] moves = new int[][] {{0,3},{103,104},{1,1},{105,106},{2,0},{107,107}};
        boolean result = TicTacToe.threeInRowForA(moves);
        assertTrue(result);
    }

    @Test
    public void threeXsOnSameRowReturnsTrue(){
        int[][] moves = new int[][] {{0,0},{103,104},{0,1},{105,106},{0,2},{107,107}};
        boolean result = TicTacToe.threeInRowForA(moves);
        assertEquals(true,result);
    }

    @Test
    public void threeXsOnSecondRowReturnsTrue(){
        int[][] moves = new int[][] {{1,0},{103,104},{1,1},{105,106},{1,2},{107,107}};
        boolean result = TicTacToe.threeInRowForA(moves);
        assertEquals(true,result);
    }

    @Test
    public void threeXsOnSecondColumnReturnsTrue(){
        int[][] moves = new int[][] {{0,1},{103,104},{1,1},{105,106},{2,1},{107,107}};
        boolean result = TicTacToe.threeInRowForA(moves);
        assertEquals(true,result);
    }

    @Test
    public void threeOsInFirstRowReturnsTrue(){
        int[][] moves = new int[][] {{99,100},{0,0},{101,102},{0,1},{103,104},{0,2}};
        boolean result = TicTacToe.threeInRowForB(moves);
        assertEquals(true,result);
    }

    @Test
    public void playerBWins(){
        int[][] moves = {{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}};
        String result = TicTacToe.tictactoe(moves);
        assertEquals("B", result);
    }

}
