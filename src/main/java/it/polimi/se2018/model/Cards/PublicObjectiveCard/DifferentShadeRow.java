package it.polimi.se2018.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.model.Cards.PatternCard;

/**
 * Class DifferentShadeRow: Public Objective Card
 * @author Salvatrore Fadda
 */
public class DifferentShadeRow implements PublicEffects {
    private final int VPOINTS = 5;
    @Override
    public int RunPublic(PatternCard pattern) {
        int points = 0;
        for (int i = 0; i < pattern.getPattern().size(); i = i + 5){
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

        return points ;
    }
}
