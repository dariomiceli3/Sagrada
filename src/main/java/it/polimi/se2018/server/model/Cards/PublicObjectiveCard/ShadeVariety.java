package it.polimi.se2018.server.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Components.GlassBox;

import java.io.Serializable;
import java.util.Iterator;
import static java.lang.Math.min;

/**
 * Class ShadeVariety: it represents the public card Shade Variety of the game and its effect
 * @author fadda-miceli-mundo
 */

public class ShadeVariety implements PublicEffects, Serializable {

    private static final int VPOINTS = 5;
    private static final String NAME = "Shade Variety";

    /**
     * Override of the method of the interface for the DP Strategy with the algorithms of the Shade Variety card, that
     * count the set of each values anywhere in the card
     * @param pattern where to run the effect
     * @return the points calculated by running this effect
     */
    @Override
    public int runPublic(PatternCard pattern){
        int points;
        int setOf1= 0;
        int setOf2 = 0;
        int setOf3 = 0;
        int setOf4 = 0;
        int setOf5 = 0;
        int setOf6 = 0;
        int temp1;
        int temp2;
        int temp3;
        int temp4;

        GlassBox box;

        for (GlassBox glassBox : pattern.getPattern()) {
            box = glassBox;
            if (!box.isBoxEmpty()) {
                if (box.getDice().getValue() == 1) {
                    setOf1++;
                }
                if (box.getDice().getValue() == 2) {
                    setOf2++;
                }
                if (box.getDice().getValue() == 3) {
                    setOf3++;
                }
                if (box.getDice().getValue() == 4) {
                    setOf4++;
                }
                if (box.getDice().getValue() == 5) {
                    setOf5++;
                }
                if (box.getDice().getValue() == 6) {
                    setOf6++;
                }
            }
        }

        temp1 = min(setOf1, setOf2);
        temp2 = min(setOf3, setOf4);
        temp3 = min(setOf5, setOf6);
        temp4 = min(temp1, temp2 );
        points = min(temp3, temp4) * VPOINTS;

        return points;
    }

    /**
     * Override of the Object toString method to provide the caller of a String version of a Shade Variety card
     * @return string format of the card
     */
    @Override
    public String toString(){
        return NAME + "\n"
                + "Sets of one of each value anywhere" + "\n"
                + "VP : " + VPOINTS;
    }



}
