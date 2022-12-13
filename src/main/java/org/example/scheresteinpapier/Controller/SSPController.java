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
import org.example.scheresteinpapier.Exceptions.InvalidLogicCase;
import org.example.scheresteinpapier.Model.*;

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

    private boolean showedResult = false;
    Player player;

    /**
     * Disable button on program start
     */
    @FXML
    public void initialize() {
        player = new Player();
        disablePickButtonOnRoundEnd();
    }

    /**
     * change the player pick label
     */
    @FXML
    private void onScissorClick() {
        player.setAction(Action.SCISSOR);
        playerPick.setText(String.valueOf(Action.SCISSOR));
        enablePickButtonOnNewRound();
        roundLogic();
    }

    /**
     * change the player pick label
     */
    @FXML
    private void onStoneClick() {
        player.setAction(Action.ROCK);
        playerPick.setText(String.valueOf(Action.ROCK));
        enablePickButtonOnNewRound();
        roundLogic();
    }

    /**
     * change the player pick label
     */
    @FXML
    private void onPaperClick() {
        player.setAction(Action.PAPER);
        playerPick.setText(String.valueOf(Action.PAPER));
        enablePickButtonOnNewRound();
        roundLogic();
    }

    /**
     * request a computer choice and pass it into the Logic class for evaluation
     */
    @FXML
    private void onPickClick() {
        try {
            Player computer = Computer.getComputerChoice();
            computerPick.setText(String.valueOf(computer.getAction()));
            Logic logic = new Logic(player, computer);
            checkWinner(logic);
        } catch (InvalidComputerAction e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * change the score on screen
     */
    @FXML
    public void updateScore() {
        determineScoreChange();
        scoreLabel.setText(String.valueOf(Score.score));
    }

    /**
     * determine whether the score should be decreased or increased
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
     * initialize functions which check the winner and update the screen
     * @param logic Parameter with the static outcome variable
     */
    private void checkWinner(Logic logic) {
        try {
            logic.checkRoundWin();
            initProgressBar();
        } catch (InvalidLogicCase e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * start the progress bar
     */
    private void initProgressBar() {
        ProgressBarHandler progressBarHandler = new ProgressBarHandler();
        progressBarHandler.loadProgressBar(progressBar, this);
    }

    /**
     * disable the pickButton until the new round
     */
    public void disablePickButtonOnRoundEnd() {
        pickButton.setDisable(true);
    }

    /**
     * enable the pickButton on a new round
     */
    public void enablePickButtonOnNewRound() {
        pickButton.setDisable(false);
    }

    /**
     * determine whether the result has already been shown or not
     */
    private void roundLogic() {
        if (showedResult) resetSelections();
        showedResult = false;
    }

    /**
     * reset variables and fields after a succesful round
     */
    private void resetSelections() {
        computerPick.setText(String.valueOf(Action.NONE));
        disableLabelVisiblity();
        Logic.outcome = "";
    }

    /**
     * change the text of the winner label based on the static outcome variable
     * It also lets roundLogic() know if it should reset
     */
    public void showResult() {
        winLossLabel.setText(Logic.outcome);
        enableLabelVisiblity();
        showedResult = true;
    }

    /**
     * enable the labels which display the computer pick and winner label
     */
    private void enableLabelVisiblity() {
        computerPick.setVisible(true);
        comLabel.setVisible(true);
        winLossLabel.setVisible(true);
    }

    /**
     * disable the labels which display the computer pick and winner label
     */
    private void disableLabelVisiblity() {
        computerPick.setVisible(false);
        comLabel.setVisible(false);
        winLossLabel.setVisible(false);
    }
}
