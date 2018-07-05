package it.polimi.se2018.server.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.server.model.Cards.PatternCard;

import java.io.Serializable;

/**
 * Class DifferentShadeRow: it represents the public card Row Shade Variety of the game and its effect
 * @author fadda-miceli-mundo
 */
public class DifferentShadeRow implements PublicEffects, Serializable {

    private static final int VPOINTS = 5;
    private static final String NAME = "Row Shade Variety";

    /**
     * Override of the method of the interface for the DP Strategy with the algorithms of the Row Shade Variety card, that
     * count the number of rows with no repeated values
     * @param pattern where to run the effect
     * @return the points calculated by running this effect
     */
    @Override
    public int runPublic(PatternCard pattern) {
        int points = 0;
        for (int i = 0; i < pattern.getPattern().size(); i = i + 5){
            if(!(pattern.getPattern().get(i).isBoxEmpty() || pattern.getPattern().get(i+1).isBoxEmpty() || pattern.getPattern().get(i+2).isBoxEmpty() || pattern.getPattern().get(i+3).isBoxEmpty() || pattern.getPattern().get(i+4).isBoxEmpty())) {
                if (
                        pattern.getPattern().get(i).getDice().getValue() != pattern.getPattern().get(i + 1).getDice().getValue() &&
                                pattern.getPattern().get(i).getDice().getValue() != pattern.getPattern().get(i + 2).getDice().getValue() &&
                                pattern.getPattern().get(i).getDice().getValue() != pattern.getPattern().get(i + 3).getDice().getValue() &&
                                pattern.getPattern().get(i).getDice().getValue() != pattern.getPattern().get(i + 4).getDice().getValue() &&
                                pattern.getPattern().get(i + 1).getDice().getValue() != pattern.getPattern().get(i + 2).getDice().getValue() &&
                                pattern.getPattern().get(i + 1).getDice().getValue() != pattern.getPattern().get(i + 3).getDice().getValue() &&
                                pattern.getPattern().get(i + 1).getDice().getValue() != pattern.getPattern().get(i + 4).getDice().getValue() &&
                                pattern.getPattern().get(i + 2).getDice().getValue() != pattern.getPattern().get(i + 3).getDice().getValue() &&
                                pattern.getPattern().get(i + 2).getDice().getValue() != pattern.getPattern().get(i + 4).getDice().getValue() &&
                                pattern.getPattern().get(i + 3).getDice().getValue() != pattern.getPattern().get(i + 4).getDice().getValue()

                        ) {
                    points = points + VPOINTS;
                }
            }
        }

        return points ;
    }

    /**
     * Override of the Object toString method to provide the caller of a String version of a Row Shade Variety card
     * @return string format of the card
     */
    @Override
    public String toString(){
        return NAME + "\n"
                + "Rows with no repeated colors" + "\n"
                + "VP : " + VPOINTS;
    }


}
