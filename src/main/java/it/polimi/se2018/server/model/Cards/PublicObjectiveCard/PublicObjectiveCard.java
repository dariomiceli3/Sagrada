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

    public PublicObjectiveCard(PublicEffects effect, String name) {
        this.effect = effect;
        this.name = name;
    }

    // copy constructor
    public PublicObjectiveCard(PublicObjectiveCard publicCard) {
        this.effect = publicCard.getEffect();
        this.name = publicCard.getName();
    }

    public String getName() {
        return name;
    }

    public PublicEffects getEffect() {
        return effect;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int executeEffect(PatternCard pattern){
        return effect.runPublic(pattern);
    }

    @Override
    public String toString(){
        return "Public Card : " + effect.toString();
        }
}


