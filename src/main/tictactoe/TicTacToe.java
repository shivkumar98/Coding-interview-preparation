package tictactoe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TicTacToe {
    /*
    Tic-tac-toe
    Each player places characters into empty squares ' '
    Player 1 always places 'X', Player 2 always places 'O'
    Game end when there are 3 of the same character in any row/col/diagonol
    Game end if all squares are non-empty

    Given 2D array moves where moves[i]=[row_i, col_i] indicates ith move
    will be played on grid[row_i][col_i]
    Return winner of game - "A" or "B", otherwise "Draw"
    If moves still pending return "Pending"

    Assume moves is valid, the grid is empty and A plays first
     */

    public static String tictactoe(int[][] moves) {
        if (threeInRowForA(moves))
            return "A";
        else if (threeInRowForB(moves)) {
            return "B";
        }
        if (!threeInRowForA(moves) && moves.length == 9)
            return "Draw";

        return "Pending";
    }

    //logic to find if there is a win
    public static boolean threeInRowForA(int[][] moves) {
        Map<Integer, Integer> numberOfMatchesForRow = new HashMap<>();
        Map<Integer, Integer> numberOfMatchesForColumn = new HashMap<>();

        int numOfDiagonols = 0;
        int numAltDiagnols = 0;
        // check player A moves
        // get even-indexed moves:
        for (int i = 0; i < moves.length; i += 2) {
            int[] move = moves[i];

            // check for diagonals
            if (move[0] == move[1])
                numOfDiagonols++;
            // check for alt-diagonols
            if (Arrays.equals(move, new int[]{0, 2}) || Arrays.equals(move, new int[]{1, 1}) || Arrays.equals(move, new int[]{2, 0})) {
                numAltDiagnols++;
            }
            // check if there are 3 moves where row is fixed
            for (int row = 0; row < 3; row++) {
                if (move[0] == row) {
                    numberOfMatchesForRow.compute(move[0], (k, v) -> (v == null) ? 1 : ++v);
                }
            }
            for (int col = 0; col < 3; col++) {
                if (move[1] == col)
                    numberOfMatchesForColumn.compute(move[1], (k, v) -> (v == null) ? 1 : ++v);
            }

        }
        for (int value : numberOfMatchesForRow.values()) {
            if (value == 3)
                return true;
        }
        for (int value : numberOfMatchesForColumn.values()) {
            if (value == 3)
                return true;
        }
        if (numOfDiagonols == 3 || numAltDiagnols == 3)
            return true;

        return false;
    }

    public static boolean threeInRowForB(int[][] moves) {
        Map<Integer, Integer> numberOfMatchesForRow = new HashMap<>();
        Map<Integer, Integer> numberOfMatchesForColumn = new HashMap<>();

        int numOfDiagonols = 0;
        int numAltDiagnols = 0;
        // check player A moves
        // get even-indexed moves:
        for (int i = 1; i < moves.length; i += 2) {
            int[] move = moves[i];
            System.out.println("i, move: " + i + " " + Arrays.toString(move));

            // check for diagonals
            if (move[0] == move[1])
                numOfDiagonols++;

            // check if there are 3 moves where row is fixed
            for (int row = 0; row < 3; row++) {
                if (move[0] == row) {
                    numberOfMatchesForRow.compute(move[0], (k, v) -> (v == null) ? 1 : ++v);
                }
            }
            for (int col = 0; col < 3; col++) {
                if (move[1] == col)
                    numberOfMatchesForColumn.compute(move[1], (k, v) -> (v == null) ? 1 : ++v);
            }

            if (Arrays.equals(move, new int[]{0, 2}) || Arrays.equals(move, new int[]{1, 1}) || Arrays.equals(move, new int[]{2, 0})) {
                numAltDiagnols++;

            }

        }
        for (int value : numberOfMatchesForRow.values()) {
            if (value == 3)
                return true;
        }
        for (int value : numberOfMatchesForColumn.values()) {
            if (value == 3)
                return true;
        }
        if (numOfDiagonols == 3 || numAltDiagnols == 3)
            return true;

        return false;
    }

}
