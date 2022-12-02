package org.example.scheresteinpapier.Model;

/**
 * Class for deciding who won the game
 */
public class Logic {
    public static boolean isSelectionValid = false;

    /**
     * Function which is called when the pick button is pressed
     * @param player1
     * @param player2
     */
    public static void checkRoundWin(Player player1, Player player2) {
        checkValidInput(player1, player2);
        checkGameDraw(player1, player2);
        checkGameWinner(player1, player2);
    }

    private static void checkValidInput(Player player1, Player player2) {
        if (player1.getAction() == Action.NONE && player2.getAction() == Action.NONE) {
            isSelectionValid = true;
        }
    }

    private static void checkGameDraw (Player player1, Player player2){
        if (player1.getAction() == player2.getAction()){
            // Label: game draw
        }
    }

    private static void checkGameWinner (Player player1, Player player2){
        if ( player1.getAction() == Action.SCISSOR && player2.getAction() == Action.PAPER){
            // Label: game won
        } else if ( player1.getAction() == Action.ROCK && player2.getAction() == Action.SCISSOR){
            // Label: game won
        } else if ( player1.getAction() == Action.PAPER && player2.getAction() == Action.ROCK){
            // Label: game won
        } else{
            // Label: game loss
        }


    }


}
