package rockpaperscissors;

import java.util.Arrays;

public class RockPaperScissors {
    /* PROBLEM:
    Nezuko and Zenitsu are playing Rock Paper Scissors
    I will be provided with two strings which represents their moves
    R = Rock
    P = Paper
    S = Scissors
    There is a total of K games and the player will transverse the string provided
    You need to tell the number of games won by nezuko and zenitsu respectively
    if end of string is reached then start from beginning again
     */

    /* EXAMPLE:
    Input: k=3, NEZUKO='RP', ZENITSU='R'
    output: 1 0

     */


    public static int[] rockPaperScissor(int k, String nezuko, String zenitsu) {
        int nezukoTotalWins = 0;
        int zenitsuTotalWins = 0;
        for (int i = 0; i < k; i++) {
            int indexNezuko = i % (nezuko.length());
            int indexZenitsu = i % (zenitsu.length());
            // get nezukos hand:
            char nezukoHand = nezuko.charAt(indexNezuko);
            //System.out.println("i: "+i+ ", nezukoHand: "+nezukoHand);

            // get zenitsus hand
            char zenitsuHand = zenitsu.charAt(indexZenitsu);
            //System.out.println("i: "+i+ ", zenitsuHand: "+zenitsuHand);

            // compare
            // draw:
            if (nezukoHand == zenitsuHand) {
                //System.out.println("DRAW!!!");
            }
            else {
                // netsuko wins
                if ((nezukoHand == 'R' && zenitsuHand == 'S') ||
                        (nezukoHand == 'P' && zenitsuHand == 'R') ||
                        (nezukoHand == 'S' && zenitsuHand == 'P')
                ) { //System.out.println("NEZUKO WINS");
                    nezukoTotalWins++;
                } else {
                    //System.out.println("ZENITSU WINS");
                    zenitsuTotalWins++;
                }


            }


            // increment scores
        }
        return new int[]{nezukoTotalWins, zenitsuTotalWins};
    }

    public static void main(String[] args) {
        // rockPaperScissor(6, "RPS", "RRR");

        int[] result = rockPaperScissor(3, "RP","R"); // expect [1, 0]
        System.out.println(Arrays.toString(result));
    }

}
