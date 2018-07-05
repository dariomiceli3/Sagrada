package it.polimi.se2018.server.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Components.DiceColor;
import it.polimi.se2018.server.model.Components.GlassBox;

import java.io.Serializable;
import java.util.Iterator;

import static java.lang.Math.min;

/**
 * Class VarietyColor: it represents the public card Color Variety of the game and its effect
 * @author fadda-miceli-mundo
 */
public class VarietyColor implements PublicEffects, Serializable {

    private static final int VPOINTS = 4;
    private static final String NAME = "Color Variety";


    /**
     * Override of the method of the interface for the DP Strategy with the algorithms of the Color Variety card, that
     * count the set of one of each color anywhere
     * @param pattern where to run the effect
     * @return the points calculated by running this effect
     */
    @Override
    public int runPublic(PatternCard pattern){
        int points;
        int setOfY= 0;
        int setOfP = 0;
        int setOfG = 0;
        int setOfB = 0;
        int setOfR = 0;
        int temp1;
        int temp2;
        int temp3;

        GlassBox box;

        for (GlassBox glassBox : pattern.getPattern()) {
            box = glassBox;
            if (!box.isBoxEmpty()) {
                if (box.getDice().getColor() == DiceColor.YELLOW) {
                    setOfY++;
                }
                if (box.getDice().getColor() == DiceColor.PURPLE) {
                    setOfP++;
                }
                if (box.getDice().getColor() == DiceColor.GREEN) {
                    setOfG++;
                }
                if (box.getDice().getColor() == DiceColor.BLUE) {
                    setOfB++;
                }
                if (box.getDice().getColor() == DiceColor.RED) {
                    setOfR++;
                }
            }
        }

        temp1 = min(setOfY, setOfP);
        temp2 = min(setOfG, setOfB);
        temp3 = min(setOfR, temp1);
        points = min(temp3, temp2) * VPOINTS;

        return points;
    }

    /**
     * Override of the Object toString method to provide the caller of a String version of a Color Variety card
     * @return string format of the card
     */
    @Override
    public String toString(){
        return NAME + "\n"
                + "Sets of one of each color anywhere" + "\n"
                + "VP : " + VPOINTS;
    }
}
