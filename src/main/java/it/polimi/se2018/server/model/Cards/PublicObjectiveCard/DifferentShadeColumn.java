package it.polimi.se2018.server.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.server.model.Cards.PatternCard;

import java.io.Serializable;

/**
 * Class DifferentShadeColumn: it represents the public card Column Shade Variety of the game and its effect
 * @author fadda-miceli-mundo
 */
public class DifferentShadeColumn implements PublicEffects, Serializable {

    public static final int VPOINTS = 4;
    public static final String NAME = "Column Shade Variety";


    /**
     * Override of the method of the interface for the DP Strategy with the algorithms of the Column Shade Variety card, that
     * count the number of columns with no repeated values
     * @param pattern where to run the effect
     * @return the points calculated by running this effect
     */
    @Override
    public int runPublic(PatternCard pattern) {
        int points = 0;
        for (int i = 0; i < 5; i++) {
            if(!(pattern.getPattern().get(i).isBoxEmpty() || pattern.getPattern().get(i+5).isBoxEmpty() || pattern.getPattern().get(i+10).isBoxEmpty() || pattern.getPattern().get(i+15).isBoxEmpty())){
             if (
                    pattern.getPattern().get(i).getDice().getValue() != pattern.getPattern().get(i + 5).getDice().getValue() &&
                            pattern.getPattern().get(i).getDice().getValue() != pattern.getPattern().get(i + 10).getDice().getValue() &&
                            pattern.getPattern().get(i).getDice().getValue() != pattern.getPattern().get(i + 15).getDice().getValue() &&
                            pattern.getPattern().get(i + 5).getDice().getValue() != pattern.getPattern().get(i + 10).getDice().getValue() &&
                            pattern.getPattern().get(i + 5).getDice().getValue() != pattern.getPattern().get(i + 15).getDice().getValue() &&
                            pattern.getPattern().get(i + 10).getDice().getValue() != pattern.getPattern().get(i + 15).getDice().getValue()

                    ) {
                points = points + VPOINTS;
             }
            }
        }

        return points;
    }

    /**
     * Override of the Object toString method to provide the caller of a String version of a Column Shade Variety card
     * @return string format of the card
     */
    @Override
    public String toString(){
        return NAME + "\n"
                + "Columns with no repeated values" + "\n"
                + "VP : " + VPOINTS;
    }


}
