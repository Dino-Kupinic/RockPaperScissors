/*-----------------------------------------------------------------------------
 *              Hoehere Technische Bundeslehranstalt STEYR
 *----------------------------------------------------------------------------*/
/**
 * Kurzbeschreibung
 *
 * @author  : Dino Kupinic, Max Wöss
 * @date    : 3.12.2022
 *
 * @details
 *  Class for handling the player score
 */

package org.example.scheresteinpapier.Model;

public class Score {
    /**
     * static variable for storing the user score
     */
    public static int score = 0;

    /**
     * global variables for defining how much score is gained for either a win or loss
     */
    public static int scoreGain = 2;
    public static int scoreLoss = 1;

    /**
     * Function to subtract from the player score based on the global scoreLoss variable
     */
    public static void subtractFromScore() {
        score -= scoreLoss;
    }

    /**
     * Function to add to the player score based on the global scoreGain variable
     */
    public static void addToScore() {
        score += scoreGain;
    }
}
