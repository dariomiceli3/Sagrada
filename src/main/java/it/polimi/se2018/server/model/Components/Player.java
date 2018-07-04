package it.polimi.se2018.server.model.Components;

import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import java.io.Serializable;
import java.util.List;

/**
 * Class Player: represents a player of the game, it's characterized by a name and an id, every player owns its
 * private and pattern cards, the tokens number and the points obtained at the end of a match.
 * Every player could be connected or disconnected, depending on the state during the match
 * @author fadda-miceli-mundo
 * @see java.io.Serializable
 */
public class Player implements Serializable {

    private String playerName;
    private int playerID;
    private boolean runningP;
    private PatternCard pattern;
    private PrivateObjectiveCard privateCard;
    private List<PrivateObjectiveCard> privateListCard;
    private List<PatternCard> patterChooseList;
    private int tokensNumber;
    private int finalPoints;
    private int privatePoints;
    private boolean disconnect;

    /**
     * Class default constructor re-definition
     */
    public Player() {
        this.playerName = null;
    }

    /**
     * Class constructor for a player with a unique id
     * @param playerID
     */
    public Player(int playerID) {
        this.playerID = playerID;
    }

    /**
     * method that provides the caller of the connection state of the player
     * @return boolean of the presence in the game of the player
     */
    public boolean isDisconnect() {
        return disconnect;
    }

    /**
     * method to verify the state of a player at the moment of the call
     * @return boolean of the state
     */
    public boolean isRunningP() {
        return runningP;
    }


    /**
     * method that provides the caller of the name of the player
     * @return String format of the name
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * method that provides the caller of the unique id of the player
     * @return int value of the id
     */
    public int getPlayerID() {
        return playerID;
    }

    /**
     * method that provides the caller of the list of the four pattern card for the choose
     * @return a list of the pattern choose player
     */
    public List<PatternCard> getPatterChooseList() {
        return patterChooseList;
    }

    /**
     * method that provides the caller of the pattern card associated with the player
     * @return a Pattern Card type of the card of the player
     */
    public PatternCard getPattern() {
        return pattern;
    }

    /**
     * method that provides the caller of the number of tokens available at the moment
     * @return int number of the tokens
     */
    public int getTokensNumber() {
        return tokensNumber;
    }

    /**
     * method that provides the caller of the Private Objective Card associated with the player
     * in the multi player modality
     * @return PrivateObjectiveCard type of the player
     */
    public PrivateObjectiveCard getPrivate() {
        return privateCard;
    }

    /**
     * method that provides the caller of the list Private Objective Card associated with the player
     * in the single player modality
     * @return a list of PrivateObjectiveCard type
     */
    public List<PrivateObjectiveCard> getPrivateSinglePlayerCard(){
        return privateListCard;
    }

    /**
     * method that provides the caller of the final points of the player
     * @return int of the points
     */
    public int getFinalPoints() {
        return finalPoints;
    }

    /**
     * method that provides the caller of the points obtained by the private card by the player
     * @return int of the points
     */
    public int getPrivatePoints() {
        return privatePoints;
    }


    /**
     * method that allow the caller to set the name of the player
     * @param playerName the name of the player to set
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * method that allow the caller to set the unique id of the player
     * @param id the id of the player to set
     */
    public void setPlayerID(int id) {
        this.playerID = id;
    }

    /**
     * method that allow the caller to set the pattern choose list of the player
     * @param patterChooseList list of the pattern card
     */
    public void setPatterChooseList(List<PatternCard> patterChooseList) {
        this.patterChooseList = patterChooseList;
    }

    /**
     * method that allow the caller to set the pattern of the player
     * @param pattern of the player
     */
    public void setPattern(PatternCard pattern) {
        this.pattern = pattern;
    }

    /**
     * method that allow the caller to set the token number of the player
     * @param tokensNumber of the player
     */
    public void setTokensNumber(int tokensNumber) {
        this.tokensNumber = tokensNumber;
    }

    /**
     * method that allow the caller to set the Private Card of the player
     * @param privateCard of the player to set
     */
    public void setPrivate(PrivateObjectiveCard privateCard) {
        this.privateCard = privateCard;
    }

    /**
     * method that allow the caller to set the Private Card list in the single player modality
     * @param privateCard list of the player private card to set
     */
    void setPrivateSinglePlayer(List<PrivateObjectiveCard> privateCard){
        this.privateListCard = privateCard;
    }

    /**
     * method that allow the caller to set the final points of the player
     * @param finalPoints to set
     */
    public void setFinalPoints(int finalPoints) {
        this.finalPoints = finalPoints;
    }

    /**
     * method that allow the caller to set the private card points of the player
     * @param privatePoints to set
     */
    public void setPrivatePoints(int privatePoints) {
        this.privatePoints = privatePoints;
    }

    /**
     * method that allow the caller to set the connection state of the player at that moment
     * @param disconnect state at the moment of the call
     */
    public void setDisconnect(boolean disconnect) {
        this.disconnect = disconnect;
    }

    /**
     * method that allow the caller to set the state of the player
     * @param runningP state at the moment of the call
     */
    public void setRunningP(boolean runningP) {
        this.runningP = runningP;
    }


    /**
     * Override of the Object toString method to provide the caller of a String version of a Player instance variables
     * @return string format of a player
     */
    @Override
    public String toString() {

        return "Player name: " + getPlayerName() + "\n" +
                "Player ID: " + getPlayerID() + "\n" +
                //  "Player pattern: " + getPattern().getName() + "\n" +
                "Player Tokens: " + getTokensNumber();
    }

    /**
     * method that provides the caller of a String version of the player points in a format useful
     * @return String format of the points
     */
    public String toStringPoints(){
        return "The player " + getPlayerName() + " totalized " + this.getFinalPoints() + " points" + "\n";
    }

}

