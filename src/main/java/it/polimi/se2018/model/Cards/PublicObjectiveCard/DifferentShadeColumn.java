package it.polimi.se2018.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.model.Cards.PatternCard;

/**
 * Class DifferentShadeColoum: Public Objective Card
 * @author Salvatrore Fadda
 */
public class DifferentShadeColumn implements PublicEffects {
    public final int VPOINTS = 4;

    @Override
    public int RunPublic(PatternCard pattern) {
        int points = 0;
        for (int i = 0; i < pattern.getPattern().size(); i++) {
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

        return points;
    }
}
