/*-----------------------------------------------------------------------------
 *              Hoehere Technische Bundeslehranstalt STEYR
 *----------------------------------------------------------------------------*/
/**
 * Kurzbeschreibung
 *
 * @author  : Dino Kupinic, Max Wöss
 * @date    : 13.12.2022
 *
 * @details
 *   Detailbeschreibung
 *
 */

package org.example.scheresteinpapier.Model;

public class Player {
    private Action action;

    public Player() {
        setAction(Action.NONE);
    }

    public Player(Action action) {
        setAction(action);
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
