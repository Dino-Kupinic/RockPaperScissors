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

public class Score {
    public static int score = 0;
    public static int scoreGain = 2;
    public static int scoreLoss = 1;

    public static void subtractFromScore() {
        score -= 1;
    }

    public static void addToScore() {
        score += 2;
    }

}
