package it.polimi.se2018.server.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.server.model.Cards.PatternCard;

import java.io.Serializable;

/**
 * Class PublicObjectiveCard(DP Strategy)
 * @author Salvatrore Fadda
 */
public class PublicObjectiveCard implements Serializable {
    private PublicEffects effect;
    private String name;

    public PublicObjectiveCard(PublicEffects effect) {
        this.effect = effect;
    }

    public int executeEffect(PatternCard pattern){
            return effect.runPublic(pattern);
        }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return "Public Card : " + effect.toString();
        }
}


