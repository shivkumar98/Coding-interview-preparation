package gameoflife;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GameOfLifeV2 {
    public static void gameOfLife(int[][] board) {
        int columns = board[0].length;
        int rows = board.length;
        // map to store location and sum of sorrounding elements:
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.println("i,j: "+i+ " "+j);
                map.put(i + "," + j, 0);
                int element = board[i][j];
                System.out.println("element: " + element);

                // get surrounding elements value
                // get value to the right:
                if ((j + 1) < columns) {
                    int rightElement = board[i][j + 1];
                    System.out.println("right element: " + rightElement);
                    map.compute(i + "," + j, (k, v) -> v + rightElement);
                }
                // get value of rightbottom:
                if ((j + 1) < columns && (i + 1) < rows) {
                    int bottomRightElement = board[i + 1][j + 1];
                    System.out.println("bottomRight element: " + bottomRightElement);
                    map.compute(i + "," + j, (k, v) -> v + bottomRightElement);
                }
                // get bottom value:
                if (i + 1 < rows) {
                    int bottomEllement = board[i + 1][j];
                    System.out.println("bottomEllement element: " + bottomEllement);
                    map.compute(i + "," + j, (k, v) -> v + bottomEllement);
                }
                // get bottomLeft value:
                if (i + 1 < rows && j - 1 >= 0) {
                    int bottomLeft = board[i + 1][j - 1];
                    System.out.println("bottomLeft element: " + bottomLeft);
                    map.compute(i + "," + j, (k, v) -> v + bottomLeft);
                }
                // get left value:
                if (j-1 >= 0){
                    int left = board[i][j-1];
                    System.out.println("left element: " + left);
                    map.compute(i + "," + j, (k, v) -> v + left);
                }
                // get top left:
                if (i-1>=0 && j-1 >= 0){
                    int topLeft = board[i-1][j-1];
                    System.out.println("topLeft element: " + topLeft);
                    map.compute(i + "," + j, (k, v) -> v + topLeft);
                }
                // top:
                if (i-1>=0){
                    int top = board[i-1][j];
                    System.out.println("top element: " + top);
                    map.compute(i + "," + j, (k, v) -> v + top);
                }
                // top right:
                if (i-1>=0 && j+1<columns){
                    int topRight = board[i-1][j+1];
                    System.out.println("topRight: " + topRight);
                    map.compute(i + "," + j, (k, v) -> v + topRight);
                }
            }
        }
        System.out.println("map: "+map);

        int[][] result = new int[rows][columns];

        // translate each element to 0 or 1
        for (String k : map.keySet()){
            //System.out.println("key: "+k);
            //System.out.println("sum of surrounding: "+map.get(k));

            // get row and column of element
            int elementRow = Integer.parseInt(k.split(",")[0]);
            int elementCol = Integer.parseInt(k.split(",")[1]);
            // less than 2 live neigbours => death
            if (board[elementRow][elementCol]==1){
                if (map.get(k)<2){
                    board[elementRow][elementCol] = 0;
                } else if (map.get(k)==2 || map.get(k)==3) {
                    board[elementRow][elementCol] = 1;
                } else if (map.get(k)>3) {
                    result[elementRow][elementCol] = 0;
                }
            } else if (board[elementRow][elementCol]==0) {
                if (map.get(k)==3){
                    board[elementRow][elementCol]=1;
                }
            }

        }

    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,1,1,1,0},{0,1,1,1,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}};

        System.out.println("BEFORE\n");
        System.out.println(Arrays.toString(input[0]));
        System.out.println(Arrays.toString(input[1]));
        System.out.println(Arrays.toString(input[2]));
        System.out.println(Arrays.toString(input[3]));
        System.out.println(Arrays.toString(input[4]));
        System.out.println(Arrays.toString(input[5]));
        gameOfLife(input);
        System.out.println(Arrays.toString(input[0]));
        System.out.println(Arrays.toString(input[1]));
        System.out.println(Arrays.toString(input[2]));
        System.out.println(Arrays.toString(input[3]));
        System.out.println(Arrays.toString(input[4]));
        System.out.println(Arrays.toString(input[5]));

    }
}
