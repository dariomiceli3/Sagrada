package it.polimi.se2018.server.model.Components;

import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;

import java.io.FileNotFoundException;
import java.io.Serializable;

/**
 * Class Player: descive the player settings and own his privete objctive and pattern cards
 * @author Salvatrore Fadda
 */
public class Player implements Serializable {
    private String playerName;
    private int playerID;
    private PlayerColour colour;
    private PatternCard pattern;
    private PrivateObjectiveCard privateCard;
    private int tokensNumber;
    private int finalPoints;
    private int privatePoints;

    /**
     * Default class constructor
     */
    public Player() {
        this.colour = null;
        this.playerName = null;
    }

    public Player(Player player) {
        this.playerName = player.playerName;
        this.colour = player.colour;
        this.pattern = player.pattern;
        this.privateCard = player.privateCard;
        this.tokensNumber = player.tokensNumber;
        this.finalPoints = player.finalPoints;
        this.privatePoints = player.privatePoints;
        this.playerID = player.playerID;
    }


    /**
     * Class constructor, create a die with face number and colour specified
     *
     * @param playerName the player identifier
     * @param colour     player colour
     */
    public Player(String playerName, PlayerColour colour) {
        this.playerName = playerName;
        this.colour = colour;
    }

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public Player(int playerID) {
        this.playerID = playerID;
    }

    /**
     * Class setPattern, set at the player his pattern card
     *
     * @param pattern pattern card
     */
    public void setPattern(PatternCard pattern) {
        this.pattern = pattern;
    }

    public String getPlayerName() {
        return playerName;
    }

    public PlayerColour getColour() {
        return colour;
    }

    public PatternCard getPattern() {
        return pattern;
    }

    public int getTokensNumber() {
        return tokensNumber;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int ID) {
        this.playerID = ID;
    }


    /**
     * Class setPrivate, set at the player his private objective card
     *
     * @param privateCard pattern card
     */
    public void setPrivate(PrivateObjectiveCard privateCard) {
        this.privateCard = privateCard;
    }

    public PrivateObjectiveCard getPrivate() {
        return privateCard;
    }

    public void setTokensNumber(int tokensNumber) {
        this.tokensNumber = tokensNumber;
    }

    public void setPlayerColor(PlayerColour colour) {
        this.colour = colour;
    }

    public void setFinalPoints(int finalPoints) {
        this.finalPoints = finalPoints;
    }

    public void setPrivatePoints(int privatePoints) {
        this.privatePoints = privatePoints;
    }

    public int getFinalPoints() {
        return finalPoints;
    }

    public int getPrivatePoints() {
        return privatePoints;
    }






    @Override
    public String toString() {

        return "Player name: " + getPlayerName() + "\n" +
                "Player ID: " + getPlayerID() + "\n" +
                "Player Color: " + getColour().toString() + "\n" +
              //  "Player pattern: " + getPattern().getName() + "\n" +
                "Player Tokens: " + getTokensNumber();


    }

    public String toStringTokens() {

        return "Player Tokens" + this.getTokensNumber();
    }

    public String toStringPoints(){

        return "The player " + getPlayerName() + " totalized " + this.getFinalPoints() + " points" + "\n";
    }

}

