package it.polimi.se2018.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.model.Cards.PatternCard;

/**
 * Class PublicObjectiveCard(DP Strategy)
 * @author Salvatrore Fadda
 */
public class PublicObjectiveCard {
    private PublicEffects effect;

    public PublicObjectiveCard(PublicEffects effect) {
        this.effect = effect;
    }

    public int executeEffect(PatternCard pattern){
            return effect.RunPublic(pattern);
        }
}
