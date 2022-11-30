package org.example.scheresteinpapier.Model;

public class Logic {
    public static void checkRoundWin(Player player1, Player player2) {
        checkValidInput(player1, player2);
    }

    private static void checkValidInput(Player player1, Player player2) {
        if (player1.getAction() == Action.NONE && player2.getAction() == Action.NONE) {
            // Label: Nichts ausgewählt
        }
    }
}
