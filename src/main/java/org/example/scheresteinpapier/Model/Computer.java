package org.example.scheresteinpapier.Model;

public class Computer {
    public static Player getComputerChoice() {
        double choice = Math.floor(Math.random() * 3 + 1);
        Action computerAction = Action.NONE;
        switch ((int) choice) {
            case 1:
                computerAction = Action.ROCK;
                break;
            case 2:
                computerAction = Action.PAPER;
                break;
            case 3:
                computerAction = Action.SCISSOR;
                break;
        }
        System.out.println(computerAction);
        return new Player(0, computerAction);
    }
}
