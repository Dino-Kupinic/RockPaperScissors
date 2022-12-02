package org.example.scheresteinpapier.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.scheresteinpapier.Model.Action;
import org.example.scheresteinpapier.Model.Computer;
import org.example.scheresteinpapier.Model.Logic;
import org.example.scheresteinpapier.Model.Player;

public class SSPController {
    @FXML
    private Label playerPick;

    Player player = new Player();

    @FXML
    private void onScissorClick() {
        player.setAction(Action.SCISSOR);
        Logic.checkRoundWin(player, Computer.getComputerChoice());

        playerPick.setText("SCISSORS");
    }

    @FXML
    private void onStoneClick() {
        player.setAction(Action.ROCK);
        playerPick.setText("ROCK");
    }

    @FXML
    private void onPaperClick() {
        player.setAction(Action.PAPER);
        playerPick.setText("PAPER");
    }
    @FXML
    private void onPickClick() {
        System.out.println("pick");
    }


}