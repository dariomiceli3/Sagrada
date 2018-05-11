package it.polimi.se2018.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.model.Cards.PatternCard;

/**
 * Class DifferentColourColoum: Public Objective Card
 * @author Salvatrore Fadda
 */
public class DifferentColorColumn implements PublicEffects {
    public final int VPOINTS = 5;

    @Override
    public int RunPublic(PatternCard pattern) {
        int points = 0;
        for (int i = 0; i < pattern.getPattern().size(); i++) {
            if (
                    pattern.getPattern().get(i).getDice().getColor() != pattern.getPattern().get(i + 5).getDice().getColor() &&
                            pattern.getPattern().get(i).getDice().getColor() != pattern.getPattern().get(i + 10).getDice().getColor() &&
                            pattern.getPattern().get(i).getDice().getColor() != pattern.getPattern().get(i + 15).getDice().getColor() &&
                            pattern.getPattern().get(i + 5).getDice().getColor() != pattern.getPattern().get(i + 10).getDice().getColor() &&
                            pattern.getPattern().get(i + 5).getDice().getColor() != pattern.getPattern().get(i + 15).getDice().getColor() &&
                            pattern.getPattern().get(i + 10).getDice().getColor() != pattern.getPattern().get(i + 15).getDice().getColor()

                    ) {
                points = points + VPOINTS;
            }
        }


        return points;
    }

}
