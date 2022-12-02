package org.example.scheresteinpapier.Model;

public class Computer {
    public static Player getComputerChoice() {
        Action computerAction = getComputerAction();
        return new Player(0, computerAction);
    }

    /**
     * Function to generate value between 1 and 3 which gets evaluated into an action
     * @return a double value (1.0, 2.0 or 3.0)
     */
    private static double generateRandomNumber() {
        return Math.floor(Math.random() * 3 + 1);
    }

    /**
     * Function to evaluate number into a valid action
     * @return Action which will be evaluated in order to decide who won the game
     */
    private static Action getComputerAction() {
        switch ((int) generateRandomNumber()) {
            case 1:
                return Action.ROCK;
            case 2:
                return Action.PAPER;
            case 3:
                return Action.SCISSOR;
        }
        return Action.NONE; // TODO: Add Exception
    }
}
