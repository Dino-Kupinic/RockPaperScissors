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

package org.example.scheresteinpapier.Model;

public class Player {
    private int score;
    private Action action;

    public Player() {
        setScore(0);
        setAction(Action.NONE);
    }

    public Player(int score, Action action) {
        setScore(score);
        setAction(action);
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
