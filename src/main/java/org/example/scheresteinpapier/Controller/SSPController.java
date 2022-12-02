package org.example.scheresteinpapier.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.scheresteinpapier.Model.Action;
import org.example.scheresteinpapier.Model.Computer;
import org.example.scheresteinpapier.Model.Logic;
import org.example.scheresteinpapier.Model.Player;

/**
 * Controller to handle user actions
 */
public class SSPController {
    @FXML
    private Label playerPick;
    @FXML
    private Label computerPick;
    @FXML
    private Label comLabel;
    @FXML
    private Label winLossLabel;

    private boolean showedResult = false;

    Player player = new Player();

    @FXML
    private void onScissorClick() {
        player.setAction(Action.SCISSOR);
        playerPick.setText(String.valueOf(Action.SCISSOR));
        if (showedResult) resetSelections();
        showedResult = false;

    }

    @FXML
    private void onStoneClick() {
        player.setAction(Action.ROCK);
        playerPick.setText(String.valueOf(Action.ROCK));
        if (showedResult) resetSelections();
        showedResult = false;

    }

    @FXML
    private void onPaperClick() {
        player.setAction(Action.PAPER);
        playerPick.setText(String.valueOf(Action.PAPER));
        if (showedResult) resetSelections();
        showedResult = false;

    }

    @FXML
    private void onPickClick() {
        Player computer = Computer.getComputerChoice();
        computerPick.setText(String.valueOf(computer.getAction()));
        Logic logic = new Logic(player, computer);
        logic.checkRoundWin();
        showResult();

    }

    private void resetSelections() {
        computerPick.setText(String.valueOf(Action.NONE));
        playerPick.setText(String.valueOf(Action.NONE));
        computerPick.setVisible(false);
        comLabel.setVisible(false);
        winLossLabel.setVisible(false);
    }

    private void showResult() {
        computerPick.setVisible(true);
        comLabel.setVisible(true);

        winLossLabel.setText(Logic.outcome);
        winLossLabel.setVisible(true);

        showedResult = true;

    }


}