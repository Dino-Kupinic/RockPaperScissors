package org.example.scheresteinpapier.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.scheresteinpapier.Model.Action;
import org.example.scheresteinpapier.Model.Computer;
import org.example.scheresteinpapier.Model.Logic;
import org.example.scheresteinpapier.Model.Player;

public class SSPController {
    Player player = new Player();

    @FXML
    private void onScissorClick() {
        player.setAction(Action.SCISSOR);
        Logic.checkRoundWin(player, Computer.generateComputerChoice());
        System.out.println(player.getAction());
    }

    @FXML
    private void onStoneClick() {
        player.setAction(Action.STONE);
        System.out.println(player.getAction());

    }

    @FXML
    private void onPaperClick() {
        player.setAction(Action.PAPER);
        System.out.println(player.getAction());

    }
    @FXML
    private void onPickClick() {
        System.out.println("pick");
    }

}