/*-----------------------------------------------------------------------------
 *              Hoehere Technische Bundeslehranstalt STEYR
 *----------------------------------------------------------------------------*/
/**
 * Kurzbeschreibung
 *
 * @author  : Dino Kupinic, Max Wöss
 * @date    : 4.12.2022
 *
 * @details
 *   Detailbeschreibung
 *
 */

package org.example.scheresteinpapier.Model;

public class Player {
    /**
     * Action variable with 4 possible values (scissor, rock, paper, none)
     * @see Action
     */
    private Action action;

    /**
     * standard constructor
     */
    public Player() {
        setAction(Action.NONE);
    }

    /**
     * constructor to initialise a player with a predefined action
     * @param action Action with the possible enum values
     */
    public Player(Action action) {
        setAction(action);
    }

    /**
     * Getter for player action
     * @return action of the player object
     */
    public Action getAction() {
        return action;
    }

    /**
     * Setter for player action
     * @param action sets the passed action to the action of the object
     */
    public void setAction(Action action) {
        this.action = action;
    }
}
