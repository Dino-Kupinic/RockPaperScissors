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
 *   Exception if the generated value doesn't match any of the cases
 */

package org.example.scheresteinpapier.Exceptions;

public class InvalidComputerAction extends Exception {
    public InvalidComputerAction() {
        super("This value is a not a valid argument for an action");
    }
}
