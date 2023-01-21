package rockpaperscissors;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RockPaperScissorsTest {
    @Test
    public void arbitraryTest() {
        assertEquals(1, 1);
    }

    @Test
    public void nezukoWinsOneRound(){
        int[] result = RockPaperScissors.rockPaperScissor(1, "R", "S");
        assertEquals(1,result[0]);
        assertEquals(0,result[1]);
    }

    @Test
    public void zenitsuWinsOneRound(){
        int[] result = RockPaperScissors.rockPaperScissor(1, "S", "R");
        assertEquals(0, result[0]);
        assertEquals(1, result[1]);
    }

    @Test
    public void testThatNezukosPlayCyclesBack(){
        int[] result = RockPaperScissors.rockPaperScissor(3, "SP", "RRR");
        assertEquals(1,result[0]);
        assertEquals(2,result[1]);
    }
}

