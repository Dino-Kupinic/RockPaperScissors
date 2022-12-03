/*-----------------------------------------------------------------------------
 *              Hoehere Technische Bundeslehranstalt STEYR
 *----------------------------------------------------------------------------*/
/**
 * Kurzbeschreibung
 *
 * @author  : Dino Kupinic, Max Wöss
 * @date    : 1.1.2022
 *
 * @details
 *   Detailbeschreibung
 *
 */

package org.example.scheresteinpapier.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
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
    @FXML
    private ImageView pickButton;

    private boolean showedResult = false;

    Player player = new Player();

    @FXML
    private void onScissorClick() {
        player.setAction(Action.SCISSOR);
        playerPick.setText(String.valueOf(Action.SCISSOR));
        enablePickButtonOnNewRound();
        roundLogic();
    }

    @FXML
    private void onStoneClick() {
        player.setAction(Action.ROCK);
        playerPick.setText(String.valueOf(Action.ROCK));
        enablePickButtonOnNewRound();
        roundLogic();
    }

    @FXML
    private void onPaperClick() {
        player.setAction(Action.PAPER);
        playerPick.setText(String.valueOf(Action.PAPER));
        enablePickButtonOnNewRound();
        roundLogic();
    }

    @FXML
    private void onPickClick() {
        Player computer = Computer.getComputerChoice();
        computerPick.setText(String.valueOf(computer.getAction()));
        Logic logic = new Logic(player, computer);
        logic.checkRoundWin();
        showResult();
        disablePickButtonOnRoundEnd();
    }

    private void disablePickButtonOnRoundEnd() {
        pickButton.setDisable(true);
    }

    private void enablePickButtonOnNewRound() {
        pickButton.setDisable(false);
    }

    private void roundLogic() {
        if (showedResult) resetSelections();
        showedResult = false;
    }

    private void resetSelections() {
        computerPick.setText(String.valueOf(Action.NONE));
        disableVisiblity();
        Logic.outcome = "";
    }

    private void showResult() {
        winLossLabel.setText(Logic.outcome);
        enableVisiblity();
        showedResult = true;
    }

    private void enableVisiblity() {
        computerPick.setVisible(true);
        comLabel.setVisible(true);
        winLossLabel.setVisible(true);
    }

    private void disableVisiblity() {
        computerPick.setVisible(false);
        comLabel.setVisible(false);
        winLossLabel.setVisible(false);
    }
}
