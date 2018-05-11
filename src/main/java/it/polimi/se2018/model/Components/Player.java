package it.polimi.se2018.model.Components;

import it.polimi.se2018.model.Cards.PatternCard;
import it.polimi.se2018.model.Cards.PrivateObjectiveCard;

/**
 * Class Player: descive the player settings and own his privete objctive and pattern cards
 * @author Salvatrore Fadda
 */
public class Player {
    private String playerID;
    private PlayerColour colour;
    private PatternCard pattern;
    private PrivateObjectiveCard privateCard;

    /**
     * Default class constructor
     */
    public Player(){
        this.colour = null;
        this.playerID = null;
    }

    /**
     * Class constructor, create a die with face number and colour specified
     * @param playerID the player identifier
     * @param colour player colour
     */
    public Player(String playerID, PlayerColour colour){
        this.playerID = playerID;
        this.colour = colour;
    }

    /**
     * Class setPattern, set at the player his pattern card
     * @param pattern
     */
    public void setPattern(PatternCard pattern){
        this.pattern = pattern;
    }

    public PatternCard getPattern(){
        return pattern;
    }

    /**
     * Class setPrivate, set at the player his private objective card
     * @param privateCard
     */
    public void setPrivate(PrivateObjectiveCard privateCard){
        this.privateCard = privateCard;
    }

    public PrivateObjectiveCard getPrivate(){
        return privateCard;
    }
}
