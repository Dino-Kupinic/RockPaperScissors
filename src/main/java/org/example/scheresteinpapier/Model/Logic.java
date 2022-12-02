package org.example.scheresteinpapier.Model;

import java.util.Objects;

/**
 * Class for deciding who won the game
 */
public class Logic {
    public static boolean isSelectionValid = false;
    public static String outcome = "";

    Player logicPlayer;
    Player logicComPlayer;

    public Logic(Player player1, Player player2) {
        logicPlayer = player1;
        logicComPlayer = player2;
    }

    public void checkRoundWin() {
        checkValidInput();
        checkGameDraw();
        continueLogic();
    }

    private void continueLogic() {
        if (!Objects.equals(outcome, "DRAW!")) {
            checkGameWinner();
        }
    }

    private void checkValidInput() {
        if (logicPlayer.getAction() != Action.NONE && logicComPlayer.getAction() != Action.NONE) {
            isSelectionValid = true;
        }
    }

    private void checkGameDraw() {
        if (isSelectionValid && logicPlayer.getAction() == logicComPlayer.getAction()) {
            outcome = "DRAW!";
        }
    }

    private void checkGameWinner(){
        switch (logicPlayer.getAction()) {
            case SCISSOR:
                outcome = checkScissorCases();
                break;
            case ROCK:
                outcome = checkRockCases();
                break;
            case PAPER:
                outcome = checkPaperCases();
                break;
        }
    }

    private String checkScissorCases() {
        if (logicComPlayer.getAction() == Action.ROCK) {
            return "WIN!";
        } else {
            return "LOSS!";
        }
    }

    private String checkRockCases() {
        if (logicComPlayer.getAction() == Action.SCISSOR) {
            return "WIN!";
        } else {
            return "LOSS!";
        }
    }

    private String checkPaperCases() {
        if (logicComPlayer.getAction() == Action.ROCK) {
            return "WIN!";
        } else {
            return "LOSS!";
        }
    }

}
