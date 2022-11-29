package org.example.scheresteinpapier.Model;

public class Player {
    private int score;
    private Action action;

    public Player() {
        setScore(0);
        setAction(Action.NONE);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
