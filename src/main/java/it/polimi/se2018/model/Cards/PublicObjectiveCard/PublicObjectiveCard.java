package it.polimi.se2018.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.model.Cards.PatternCard;

public class PublicObjectiveCard {
    private int vicoryPoint;
    private PublicEffects effect;

    public PublicObjectiveCard(PublicEffects strategy) {
        this.effect = strategy;
    }

    public int executeEffect(PatternCard pattern){
            return effect.RunPoint(pattern);
        }
}
