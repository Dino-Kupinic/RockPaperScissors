/*-----------------------------------------------------------------------------
 *              Hoehere Technische Bundeslehranstalt STEYR
 *----------------------------------------------------------------------------*/
/**
 * Kurzbeschreibung
 *
 * @author  : Dino Kupinic, Max Wöss
 * @date    : 3.12.2022
 *
 * @details
 *   Class to handle input from the user through GUI interaction
 */

package org.example.scheresteinpapier.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import org.example.scheresteinpapier.Exceptions.InvalidComputerAction;
import org.example.scheresteinpapier.Model.*;

/**
 * Controller to handle user actions
 */
public class SSPController {

    /**
     * JavaFX FXML controls
     */
    @FXML
    private Label playerPick;
    @FXML
    private Label computerPick;
    @FXML
    private Label comLabel;
    @FXML
    private Label winLossLabel;
    @FXML
    private ImageView pickButton;
    @FXML
    private Label scoreLabel;
    @FXML
    private ProgressBar progressBar;

    /**
     * boolean to determine whether a new round can begin
     */
    private boolean showedResult = false;

    /**
     * Player object
     */
    Player player = new Player();

    /**
     * Function to change the player pick label
     */
    @FXML
    private void onScissorClick() {
        player.setAction(Action.SCISSOR);
        playerPick.setText(String.valueOf(Action.SCISSOR));
        enablePickButtonOnNewRound();
        roundLogic();
    }

    /**
     * Function to change the player pick label
     */
    @FXML
    private void onStoneClick() {
        player.setAction(Action.ROCK);
        playerPick.setText(String.valueOf(Action.ROCK));
        enablePickButtonOnNewRound();
        roundLogic();
    }

    /**
     * Function to change the player pick label
     */
    @FXML
    private void onPaperClick() {
        player.setAction(Action.PAPER);
        playerPick.setText(String.valueOf(Action.PAPER));
        enablePickButtonOnNewRound();
        roundLogic();
    }

    /**
     * Function to request a computer choice and pass it into the Logic class for evaluation
     * @throws InterruptedException
     */
    @FXML
    private void onPickClick() throws InterruptedException {
        try {
            Player computer = Computer.getComputerChoice();
            computerPick.setText(String.valueOf(computer.getAction()));
            Logic logic = new Logic(player, computer);
            checkWinnerAndDisplayResults(logic);
        } catch (InvalidComputerAction e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Function to change the score on screen
     */
    @FXML
    private void updateScore() {
        determineScoreChange();
        scoreLabel.setText(String.valueOf(Score.score));
    }

    /**
     * Function to determine whether the score should be decreased or increased
     */
    private void determineScoreChange() {
        if (Logic.outcome.equals("WIN!")) {
            Score.addToScore();
        }
        if (Logic.outcome.equals("LOSS!")) {
            Score.subtractFromScore();
        }
    }

    /**
     * Function to initialize functions which check the winner and update the screen
     * @param logic Parameter with the static outcome variable
     * @throws InterruptedException
     */
    private void checkWinnerAndDisplayResults(Logic logic) throws InterruptedException {
        logic.checkRoundWin();
        ProgressBarHandler.loadProgressBar(progressBar);
        showResult();
        updateScore();
        disablePickButtonOnRoundEnd();
    }

    /**
     * Function to disable the pickButton until the new round
     */
    private void disablePickButtonOnRoundEnd() {
        pickButton.setDisable(true);
    }

    /**
     * Function to enable the pickButton on a new round
     */
    private void enablePickButtonOnNewRound() {
        pickButton.setDisable(false);
    }

    /**
     * Function to determine whether the result has already been shown or not
     */
    private void roundLogic() {
        if (showedResult) resetSelections();
        showedResult = false;
    }

    /**
     * Function to reset variables and fields after a succesful round
     */
    private void resetSelections() {
        computerPick.setText(String.valueOf(Action.NONE));
        disableVisiblity();
        Logic.outcome = "";
    }

    /**
     * Function to change the text of the winner label based on the static outcome variable
     * It also lets roundLogic() know if it should reset
     */
    private void showResult() {
        winLossLabel.setText(Logic.outcome);
        enableVisiblity();
        showedResult = true;
    }

    /**
     * Function to enable the labels which display the computer pick and winner label
     */
    private void enableVisiblity() {
        computerPick.setVisible(true);
        comLabel.setVisible(true);
        winLossLabel.setVisible(true);
    }

    /**
     * Function to disable the labels which display the computer pick and winner label
     */
    private void disableVisiblity() {
        computerPick.setVisible(false);
        comLabel.setVisible(false);
        winLossLabel.setVisible(false);
    }
}
