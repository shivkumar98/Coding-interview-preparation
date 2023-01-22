package gameoflife.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GameOfLifeSolutionLeetCode {
    public void  gameOfLife(int[][] board) {

        Map<String, Integer> liveNeighbourCount = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                liveNeighbourCount.put(i + "," + j, encode(board, i, j));
            }
        }
        System.out.println(liveNeighbourCount);

        // apply logic for live or dead
        for (String key : liveNeighbourCount.keySet()) {
            if (liveNeighbourCount.get(key) / 10 == 1) {
                if (liveNeighbourCount.get(key) % 10 < 2) {
                    board[Integer.parseInt(key.split(",")[0])][Integer.parseInt(key.split(",")[1])] = 0;
                } else if (liveNeighbourCount.get(key) % 10 == 2 || liveNeighbourCount.get(key) % 10 % 10 == 3) {
                    board[Integer.parseInt(key.split(",")[0])][Integer.parseInt(key.split(",")[1])] = 1;
                } else if (liveNeighbourCount.get(key) % 10 > 3) {
                    board[Integer.parseInt(key.split(",")[0])][Integer.parseInt(key.split(",")[1])] = 0;
                }
            } else if (liveNeighbourCount.get(key) / 10 == 0) {
                if (liveNeighbourCount.get(key) % 10 == 3) {
                    board[Integer.parseInt(key.split(",")[0])][Integer.parseInt(key.split(",")[1])] = 1;
                }

            }
        }

    }

    // stores state and number of live neighbours
    public static int encode(int[][] board, int i, int j) {
        int aliveNeighbours = 0;
        for (int r = -1; r <= 1; r++) {
            for (int c = -1; c <= 1; c++) {
                int neighbourRow = i + r;
                int neighbourCol = j + c;

                // avoid indexOutOfBounds
                if (neighbourRow >= 0 && neighbourRow < board.length
                        && neighbourCol < board[0].length && neighbourCol >= 0) {
                    // avoid current cell:
                    if (!(r == 0 && c == 0)) {
                        // check for live neighbour
                        if (board[neighbourRow][neighbourCol] == 1) {
                            aliveNeighbours++;
                        }
                    }
                }
            }
        }
        return board[i][j] * 10 + aliveNeighbours;
    }



}
