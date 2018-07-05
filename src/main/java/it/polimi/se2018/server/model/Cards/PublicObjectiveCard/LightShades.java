package it.polimi.se2018.server.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Components.GlassBox;
import static java.lang.Math.min;

import java.io.Serializable;
import java.util.Iterator;
/**
 * Class LightShades: it represents the public card Light Shades of the game and its effect
 * @author fadda-miceli-mundo
 */
public class LightShades implements PublicEffects, Serializable {

    private static final int VPOINTS = 2;
    private static final String NAME = "Light Shades";

    /**
     * Override of the method of the interface for the DP Strategy with the algorithms of the Light Shades card, that
     * sums the values of the dice with 2 and 1 as values
     * @param pattern where to run the effect
     * @return the points calculated by running this effect
     */
    @Override
    public int runPublic(PatternCard pattern){
        int points;
        int setOf1= 0;
        int setOf2 = 0;
        GlassBox box;

        Iterator<GlassBox> it = pattern.getPattern().iterator();
        while (it.hasNext()) {
            box = it.next();
            if(!box.isBoxEmpty()){
            if (box.getDice().getValue() == 1 ) {
                setOf1++;
            }
            if (box.getDice().getValue() == 2){
                setOf2++;
            }
            }
        }
        points = min(setOf1, setOf2);
        points = points * VPOINTS;

        return points;
    }

    /**
     * Override of the Object toString method to provide the caller of a String version of a Light Shades card
     * @return string format of the card
     */
    @Override
    public String toString(){
        return NAME + "\n"
                + "Sets of 1 & 2 values anywhere" + "\n"
                + "VP : " + VPOINTS;
    }


}


