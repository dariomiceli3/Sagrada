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

    public Player() {
        this.playerName = null;
    }

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public Player(int playerID) {
        this.playerID = playerID;
    }

    public boolean isDisconnect() {
        return disconnect;
    }

    public boolean isRunningP() {
        return runningP;
    }

    //-----------------getter methods--------------------------------------

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerID() {
        return playerID;
    }

    public List<PatternCard> getPatterChooseList() {
        return patterChooseList;
    }

    public PatternCard getPattern() {
        return pattern;
    }

    public int getTokensNumber() {
        return tokensNumber;
    }

    public PrivateObjectiveCard getPrivate() {
        return privateCard;
    }

    public List<PrivateObjectiveCard> getPrivateSinglePlayerCard(){
        return privateListCard;
    }

    public int getFinalPoints() {
        return finalPoints;
    }

    public int getPrivatePoints() {
        return privatePoints;
    }

    //------------------setter methods-----------------------------------------

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPlayerID(int iD) {
        this.playerID = iD;
    }

    public void setPatterChooseList(List<PatternCard> patterChooseList) {
        this.patterChooseList = patterChooseList;
    }

    public void setPattern(PatternCard pattern) {
        this.pattern = pattern;
    }

    public void setTokensNumber(int tokensNumber) {
        this.tokensNumber = tokensNumber;
    }

    public void setPrivate(PrivateObjectiveCard privateCard) {
        this.privateCard = privateCard;
    }

    void setPrivateSinglePlayer(List<PrivateObjectiveCard> privateCard){
        this.privateListCard = privateCard;
    }

    public void setFinalPoints(int finalPoints) {
        this.finalPoints = finalPoints;
    }

    public void setPrivatePoints(int privatePoints) {
        this.privatePoints = privatePoints;
    }

    public void setDisconnect(boolean disconnect) {
        this.disconnect = disconnect;
    }

    public void setRunningP(boolean runningP) {
        this.runningP = runningP;
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

