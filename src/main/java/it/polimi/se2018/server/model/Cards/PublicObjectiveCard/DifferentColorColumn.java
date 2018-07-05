package it.polimi.se2018.server.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.server.model.Cards.PatternCard;

import java.io.Serializable;

/**
 * Class DifferentColourColumn: it represents the public card Column Color Variety of the game and its effect
 * @author fadda-miceli-mundo
 */
public class DifferentColorColumn implements PublicEffects, Serializable {
    private static final int VPOINTS = 5;
    private static final String NAME = "Column Color Variety";


    /**
     * Override of the method of the interface for the DP Strategy with the algorithms of the Column Color Variety card, that
     * count the number of columns with no repeated colors
     * @param pattern where to run the effect
     * @return the points calculated by running this effect
     */
    @Override
    public int runPublic(PatternCard pattern) {
        int points = 0;
        for (int i = 0; i < 5; i++) {
            if(!(pattern.getPattern().get(i).isBoxEmpty() || pattern.getPattern().get(i+5).isBoxEmpty() || pattern.getPattern().get(i+10).isBoxEmpty() || pattern.getPattern().get(i+15).isBoxEmpty())){
               if (
                    pattern.getPattern().get(i).getDice().getColor() != pattern.getPattern().get(i + 5).getDice().getColor() &&
                            pattern.getPattern().get(i).getDice().getColor() != pattern.getPattern().get(i + 10).getDice().getColor() &&
                            pattern.getPattern().get(i).getDice().getColor() != pattern.getPattern().get(i + 15).getDice().getColor() &&
                            pattern.getPattern().get(i + 5).getDice().getColor() != pattern.getPattern().get(i + 10).getDice().getColor() &&
                            pattern.getPattern().get(i + 5).getDice().getColor() != pattern.getPattern().get(i + 15).getDice().getColor() &&
                            pattern.getPattern().get(i + 10).getDice().getColor() != pattern.getPattern().get(i + 15).getDice().getColor()

                    ){

                   points = points + VPOINTS;
               }
            }
        }
        return points;
    }

    /**
     * Override of the Object toString method to provide the caller of a String version of a Column Color Variety card
     * @return string format of the card
     */
    @Override
    public String toString(){
        return NAME + "\n"
                + "Columns with no repeated colors" + "\n"
                + "VP : " + VPOINTS;
    }

}
