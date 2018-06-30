package it.polimi.se2018.server.model.Components;

import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;


import java.io.Serializable;
import java.util.List;

/**
 * Class Player: descive the player settings and own his privete objctive and pattern cards
 * @author Salvatrore Fadda
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
     * Default class constructor
     */
    public Player() {
        this.playerName = null;
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

    public boolean isDisconnect() {
        return disconnect;
    }

    List<PatternCard> getPatterChooseList() {
        return patterChooseList;
    }

    public void setPatterChooseList(List<PatternCard> patterChooseList) {
        this.patterChooseList = patterChooseList;
    }

    public void setDisconnect(boolean disconnect) {
        this.disconnect = disconnect;
    }

    public String getPlayerName() {
        return playerName;
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

    public void setPlayerID(int iD) {
        this.playerID = iD;
    }

    public void setRunningP(boolean runningP) {
        this.runningP = runningP;
    }

    public boolean isRunningP() {
        return runningP;
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

    void setPrivateSinglePlayer(List<PrivateObjectiveCard> privateCard){
        this.privateListCard = privateCard;
    }

    public List<PrivateObjectiveCard> getPrivateSinglePlayerCard(){
        return privateListCard;
    }

    public void setTokensNumber(int tokensNumber) {
        this.tokensNumber = tokensNumber;
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

