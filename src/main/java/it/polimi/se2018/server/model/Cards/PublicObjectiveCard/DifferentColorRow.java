package it.polimi.se2018.server.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.server.model.Cards.PatternCard;

import java.io.Serializable;

/**
 * Class DifferentColorRow: PubblicCard
 * @author Salvatrore Fadda
 */
public class DifferentColorRow implements PublicEffects, Serializable {
    private static final int  VPOINTS = 6;
    private static final String NAME = "Row Color Variety";
    /**
     * class used to count the number of points
     * @param pattern scheme card of a player
     * @return number of rows with no repeated color multiplied by value of victory points
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

    public static String getNAME() {
        return NAME;
    }

    @Override
    public String toString(){
        return NAME + "\n"
                + "Rows with no repeated colors" + "\n"
                + "VP : " + VPOINTS;
    }
}
