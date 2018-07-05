package it.polimi.se2018.server.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.server.model.Cards.PatternCard;

import java.io.Serializable;

/**
 * Class RowColorVarietyw: it represents the public card Row Color Variety of the game and its effect
 * @author fadda-miceli-mundo
 */
public class RowColorVariety implements PublicEffects, Serializable {
    private static final int  VPOINTS = 6;
    private static final String NAME = "Row Color Variety";

    /**
     * Override of the method of the interface for the DP Strategy with the algorithms of the Row Color Variety card, that
     * count the number of rows with no repeated colors
     * @param pattern where to run the effect
     * @return the points calculated by running this effect
     */
    @Override
    public int runPublic(PatternCard pattern){
        int points = 0;
        for (int i = 0; i < pattern.getPattern().size(); i = i +5) {
            if(!(pattern.getPattern().get(i).isBoxEmpty() || pattern.getPattern().get(i+1).isBoxEmpty() || pattern.getPattern().get(i+2).isBoxEmpty() || pattern.getPattern().get(i+3).isBoxEmpty() || pattern.getPattern().get(i+4).isBoxEmpty())){
                if (
                    pattern.getPattern().get(i).getDice().getColor() != pattern.getPattern().get(i + 1).getDice().getColor() &&
                            pattern.getPattern().get(i).getDice().getColor() != pattern.getPattern().get(i + 2).getDice().getColor() &&
                            pattern.getPattern().get(i).getDice().getColor() != pattern.getPattern().get(i + 3).getDice().getColor() &&
                            pattern.getPattern().get(i).getDice().getColor() != pattern.getPattern().get(i + 4).getDice().getColor() &&
                            pattern.getPattern().get(i + 1).getDice().getColor() != pattern.getPattern().get(i + 2).getDice().getColor() &&
                            pattern.getPattern().get(i + 1).getDice().getColor() != pattern.getPattern().get(i + 3).getDice().getColor() &&
                            pattern.getPattern().get(i + 1).getDice().getColor() != pattern.getPattern().get(i + 4).getDice().getColor() &&
                            pattern.getPattern().get(i + 2).getDice().getColor() != pattern.getPattern().get(i + 3).getDice().getColor() &&
                            pattern.getPattern().get(i + 2).getDice().getColor() != pattern.getPattern().get(i + 4).getDice().getColor() &&
                            pattern.getPattern().get(i + 3).getDice().getColor() != pattern.getPattern().get(i + 4).getDice().getColor()


                    ) {

                    points = points + VPOINTS;
                }
            }
        }

        return points ;
    }


    /**
     * Override of the Object toString method to provide the caller of a String version of a Color Row Variety card
     * @return string format of the card
     */
    @Override
    public String toString(){
        return NAME + "\n"
                + "Rows with no repeated colors" + "\n"
                + "VP : " + VPOINTS;
    }
}
