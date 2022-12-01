package org.example.scheresteinpapier.Model;

public class Game {
    private boolean playerWon;
    private int rounds;

    private int roundsWon;


    public boolean isPlayerWon() {
        return playerWon;
    }
    public void setPlayerWon(boolean playerWon) {
        this.playerWon = playerWon;
    }


    public int getRounds() {
        return rounds;
    }
    public void setRounds(int rounds) {
        this.rounds = rounds;
    }


    public int getRoundsWon() {
        return roundsWon;
    }
    public void setRoundsWon(int roundsWon) {
        this.roundsWon = roundsWon;
    }
}
