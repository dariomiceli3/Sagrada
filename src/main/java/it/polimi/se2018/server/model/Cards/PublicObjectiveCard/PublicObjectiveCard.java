package it.polimi.se2018.server.model.Cards.PublicObjectiveCard;

import it.polimi.se2018.server.model.Cards.PatternCard;

import java.io.Serializable;

/**
 * Class PublicObjectiveCard: it represents a Public Objective Card of the game, it's implemented by using the DP Strategy to
 * let the other classes decide which algorithms to set to the specified Public Card
 * @author fadda-miceli-mundo
 */
public class PublicObjectiveCard implements Serializable {
    private PublicEffects effect;
    private String name;

    /**
     * Class constructor
     * @param effect to set to the card
     * @param name to set to the card
     */
    public PublicObjectiveCard(PublicEffects effect, String name) {
        this.effect = effect;
        this.name = name;
    }

    /**
     * Class copy constructor, create a new Public Objective Card from an old one,useful to create a safe copy
     * @param publicCard to copy
     */
    public PublicObjectiveCard(PublicObjectiveCard publicCard) {
        this.effect = publicCard.getEffect();
        this.name = publicCard.getName();
    }

    /**
     * method that provide the caller the name of the public card selected
     * @return String of the name
     */
    public String getName() {
        return name;
    }

    /**
     * method that provide the caller the effect of the public card selected
     * @return the effect of the card
     */
    public PublicEffects getEffect() {
        return effect;
    }

    /**
     * method that execute the effect of the public card on a pattern card obtained as parameter and call the run public
     * effect of one of the card the implements our strategy pattern
     * @param pattern on which execute the effect of the card
     * @return an int of the points obtained by the effect
     */
    public int executeEffect(PatternCard pattern){
        return effect.runPublic(pattern);
    }

    /**
     * Override of the Object toString method to provide the caller of a String version of a PublicObjectiveCard
     * @return String format of a Public Card
     */
    @Override
    public String toString(){
        return "Public Card : " + effect.toString();
    }
}


