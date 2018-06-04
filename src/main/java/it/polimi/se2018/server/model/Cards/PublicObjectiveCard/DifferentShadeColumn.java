package it.polimi.se2018.server.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.server.model.Cards.PatternCard;

import java.io.Serializable;

/**
 * Class DifferentShadeColoum: Public Objective Card
 * @author Salvatrore Fadda
 */
public class DifferentShadeColumn implements PublicEffects, Serializable {
    public static final int VPOINTS = 4;
    public static final String NAME = "Column Shade Variety ";

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

    @Override
    public String toString(){
        return NAME + "\n"
                + "Columns with no repeated values" + "\n"
                + "VP : " + VPOINTS;
    }
}
