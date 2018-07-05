package it.polimi.se2018.server.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Components.GlassBox;
import static java.lang.Math.min;

import java.io.Serializable;


/**
 * Class DarkShade: it represents the public card Deep Shades of the game and its effect
 * @author fadda-miceli-mundo
 */
public class DarkShade implements PublicEffects, Serializable {
    private static final int VPOINTS = 2;
    private static final String NAME = "Deep Shades";

    /**
     * Override of the method of the interface for the DP Strategy with the algorithms of the Deep Shades card, that
     * sums the values of the dice with 6 and 5 as values
     * @param pattern where to run the effect
     * @return the points calculated by running this effect
     */
    @Override
    public int runPublic(PatternCard pattern){
        int points;
        int setOf5= 0;
        int setOf6 = 0;
        GlassBox box;

        for (GlassBox glassBox : pattern.getPattern()) {
            box = glassBox;
            if (!box.isBoxEmpty()) {
                if (box.getDice().getValue() == 5) {
                    setOf5++;
                }
                if (box.getDice().getValue() == 6) {
                    setOf6++;
                }
            }
        }
        points = min(setOf5, setOf6);
        points = points * VPOINTS;


        return points;
    }

    /**
     * Override of the Object toString method to provide the caller of a String version of a Deep Shades card
     * @return string format of the card
     */
    @Override
    public String toString() {
        return NAME + "\n"
                + "Set of 5 & 6 values anywhere" + "\n"
                + "VP : " + VPOINTS;
    }


}
