package it.polimi.se2018.server.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.server.model.Cards.PatternCard;

/**
 * Class DifferentColourColoum: Public Objective Card
 * @author Salvatrore Fadda
 */
public class DifferentColorColumn implements PublicEffects {
    private static final int VPOINTS = 5;
    private static final String name = "Column Color Variety";

    /**
     * class used to count the number of points
      * @param pattern scheme card of a player
     * @return number of columns with no repeated color multiplied by value of victory points
     */
    @Override
    public int RunPublic(PatternCard pattern) {
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

    @Override
    public String toString(){
        return this.name + "\n"
                + "Columns with no repeated colors" + "\n"
                + "VP : " + VPOINTS;
    }

}
