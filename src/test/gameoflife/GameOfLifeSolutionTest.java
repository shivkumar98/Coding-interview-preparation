package gameoflife;

import gameoflife.solution.GameOfLifeSolution;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameOfLifeSolutionTest {

    @Test
    public void test_ecnode_function_on_single_live_cell_with_no_live_neighbours(){
        int[][] input = { {0,0,0},{0,1,0},{0,0,0}};
        int result = GameOfLifeSolution.encode(input,1,1);
        assertEquals(10,result);
    }

    @Test
    public void test_ecnode_function_on_single_live_cell_with_one_live_neighbour(){
        int[][] input = { {0,0,0},{1,1,0},{0,0,0}};
        int result = GameOfLifeSolution.encode(input,1,1);
        assertEquals(11,result);
    }
}
