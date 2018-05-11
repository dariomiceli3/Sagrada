package it.polimi.se2018.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.model.Cards.PatternCard;

public class DifferentColorRow implements PublicEffects {
    private final int  VPOINTS = 6;

    @Override
    public int RunPublic(PatternCard pattern){
        int points = 0;
        for (int i = 0; i < pattern.getPattern().size(); i = i +5)
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

        return points ;
    }
}
