package it.polimi.se2018.server.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.server.model.Cards.PatternCard;

import java.io.Serializable;

/**
 * Class DifferentShadeRow: Public Objective Card
 * @author Salvatrore Fadda
 */
public class DifferentShadeRow implements PublicEffects, Serializable {

    private static final int VPOINTS = 5;
    private static final String name = "Row Shade Variety";

    @Override
    public int RunPublic(PatternCard pattern) {
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

    @Override
    public String toString(){
        return this.name + "\n"
                + "Rows with no repeated colors" + "\n"
                + "VP : " + VPOINTS;
    }
}
