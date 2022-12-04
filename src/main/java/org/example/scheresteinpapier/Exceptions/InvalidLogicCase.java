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
 *   Exception if win or loss isn't triggered
 */

package org.example.scheresteinpapier.Exceptions;

public class InvalidLogicCase extends Exception{

    /**
     * exception constructor with an exception message
     */
    public InvalidLogicCase() {
        super("The comPlayer is invalid");
    }
}
