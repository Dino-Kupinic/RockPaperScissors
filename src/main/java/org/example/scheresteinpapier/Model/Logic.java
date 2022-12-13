/*-----------------------------------------------------------------------------
 *              Hoehere Technische Bundeslehranstalt STEYR
 *----------------------------------------------------------------------------*/
/**
 * Kurzbeschreibung
 *
 * @author  : Dino Kupinic, Max Wöss
 * @date    : 13.12.2022
 *
 * @details
 *   Class to handle the logic of rock paper scissors
 */

package org.example.scheresteinpapier.Model;

import org.example.scheresteinpapier.Exceptions.InvalidLogicCase;

import java.util.Objects;

public class Logic {
    public static boolean isSelectionValid = false;
    public static String outcome = "";

    /**
     * Player references which will be filled by the constructor
     */
    Player logicPlayer, logicComputer;

    /**
     * Constructor for assigining the player objects from onPickClick() in SSPController.java
     * @param player1 user
     * @param player2 computer
     */
    public Logic(Player player1, Player player2) {
        logicPlayer = player1;
        logicComputer = player2;
    }

    /**
     * call functions that check valid input and who won the round
     * @throws InvalidLogicCase thrown when win or loss is not triggered
     */
    public void checkRoundWin() throws InvalidLogicCase {
        checkValidInput();
        checkGameDraw();
        continueLogic();
    }

    /**
     * initializes the check functions if the game isn't a draw
     * @throws InvalidLogicCase thrown when win or loss is not triggered
     */
    private void continueLogic() throws InvalidLogicCase {
        if (!Objects.equals(outcome, "DRAW!")) {
            checkGameWinner();
        }
    }

    /**
     * checks if the userinput isn't NONE
     */
    private void checkValidInput() {
        if (logicPlayer.getAction() != Action.NONE && logicComputer.getAction() != Action.NONE) {
            isSelectionValid = true;
        }
    }

    /**
     * checks if the actions of both players are equal
     */
    private void checkGameDraw() {
        if (isSelectionValid && logicPlayer.getAction() == logicComputer.getAction()) {
            outcome = "DRAW!";
        }
    }

    /**
     * decides which check function to call based on the action of the player
     * @throws InvalidLogicCase thrown when win or loss is not triggered
     */
    private void checkGameWinner() throws InvalidLogicCase {
        switch (logicPlayer.getAction()) {
            case SCISSOR -> outcome = checkScissorCases();
            case ROCK -> outcome = checkRockCases();
            case PAPER -> outcome = checkPaperCases();
        }
    }

    /**
     * goes through all cases for scissor
     * @return returns either "WIN!" or "LOSS!"
     * @throws InvalidLogicCase thrown when win or loss is not triggered
     */
    private String checkScissorCases() throws InvalidLogicCase {
        if (logicComputer.getAction() == Action.PAPER) return "WIN!";
        if (logicComputer.getAction() == Action.ROCK) return "LOSS!";
        throw new InvalidLogicCase();
    }

    /**
     * goes through all cases for rock
     * @return returns either "WIN!" or "LOSS!"
     * @throws InvalidLogicCase thrown when win or loss is not triggered
     */
    private String checkRockCases() throws InvalidLogicCase {
        if (logicComputer.getAction() == Action.SCISSOR) return "WIN!";
        if (logicComputer.getAction() == Action.PAPER) return "LOSS!";
        throw new InvalidLogicCase();
    }

    /**
     * goes through all cases for paper
     * @return returns either "WIN!" or "LOSS!"
     * @throws InvalidLogicCase thrown when win or loss is not triggered
     */
    private String checkPaperCases() throws InvalidLogicCase {
        if (logicComputer.getAction() == Action.ROCK) return "WIN!";
        if (logicComputer.getAction() == Action.SCISSOR) return "LOSS!";
        throw new InvalidLogicCase();
    }
}
