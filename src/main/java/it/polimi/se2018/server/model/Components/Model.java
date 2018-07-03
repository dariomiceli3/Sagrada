package it.polimi.se2018.server.model.Components;


import it.polimi.se2018.exceptions.InvalidMoveException;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.PublicObjectiveCard;
import it.polimi.se2018.events.ServerClient.ModelView.*;
import it.polimi.se2018.events.SinglePlayer.SinglePrivateEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * class that store reference to the model components and getter/setter methods for them
 * @author adrianomundo
 */

public class Model extends Observable {

    private static final int DRAFTSINGLE = 3;
    private RoundTracker roundTracker;
    private DraftPool draftPool;
    private DiceBag diceBag;
    private List<PublicObjectiveCard> publicList;
    private List<Player> playerList;
    private int numberPlayer;
    private int timeToPlay;
    private Dice dice;


    public Model() {
        this.roundTracker = new RoundTracker();
        this.diceBag = new DiceBag();
        this.draftPool = new DraftPool(diceBag);
        this.playerList = new ArrayList<>();
        this.numberPlayer = 0;
        this.timeToPlay = 20;

    }

    public int getNumberPlayer(){
        return numberPlayer;
    }

    public void setNumberPlayer(int n){
        this.numberPlayer = n;
    }

    public RoundTracker getRoundTracker() {
        return roundTracker;
    }

    public DraftPool getDraftPool() {
        return draftPool;
    }

    public List<PublicObjectiveCard> getPublicList() {
        return publicList;
    }

    private void setPublicList(List<PublicObjectiveCard> publicList){
        this.publicList = publicList;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList){
        this.playerList = playerList;
    }

    public int getTimeToPlay() {
        return timeToPlay;
    }

    public DiceBag getDiceBag() {
        return diceBag;
    }


    public Player getPlayerFromID(int iD) {

        for (Player player1 : playerList)
        {
            if (player1.getPlayerID() == iD) {
                return player1;
            }
        }
        return null;
    }


    public void setPlayerAndNotify(int iD, String name) {

        numberPlayer++;
        getPlayerFromID(iD).setPlayerName(name);
        System.out.println(getPlayerFromID(iD).getPlayerName());
        setChanged();
        notifyObservers(new PlayerNameUpdateEvent(getPlayerFromID(iD).getPlayerName(), iD));

    }

    public void setPrivateAndNotify(int iD, PrivateObjectiveCard privateCard){

        getPlayerFromID(iD).setPrivate(privateCard);
        setChanged();
        notifyObservers(new PlayerPrivateUpdateEvent(getPlayerFromID(iD).getPlayerID(), privateCard));
    }


    public void setPublicAndNotify(List<PublicObjectiveCard> publicList){

        this.setPublicList(publicList);
        setChanged();
        notifyObservers(new PublicDrawEvent(this.publicList));
    }

    public void setPatternAndNotify(int iD, int indexPatternChoose){
        numberPlayer++;
        getPlayerFromID(iD).setPattern(getPlayerFromID(iD).getPatterChooseList().get(indexPatternChoose));
        setChanged();
        notifyObservers(new PlayerPatternUpdateEvent(iD, getPlayerFromID(iD).getPattern()));
    }

    public void setCustomPatternAndNotify(int iD, PatternCard patternCard) {
        numberPlayer++;
        getPlayerFromID(iD).setPattern(patternCard);
        getPlayerFromID(iD).getPattern().setCustom(true);
        setChanged();
        notifyObservers(new PlayerPatternUpdateEvent(iD, getPlayerFromID(iD).getPattern()));
    }

    public void setTokenAndNotify(int iD) {

        Player player1 = getPlayerFromID(iD);
        player1.setTokensNumber(player1.getPattern().getDifficulty());
        setChanged();
        notifyObservers(new PlayerTokensUpdateEvent(iD, getPlayerFromID(iD).getTokensNumber()));
    }

    public void setDraftPoolAndNotify(boolean singlePlayer){

        if(singlePlayer){
            this.draftPool.setNumber(DRAFTSINGLE);
        }else {
           this.draftPool.setNumber(playerList.size()*2);
        }
        this.draftPool.createListDice();
        setChanged();
        notifyObservers(new PlayerDraftPoolUpdateEvent(draftPool));
    }

    public void setMoveAndNotify(int iD, int indexPool, int indexPattern) throws InvalidMoveException {

        dice = draftPool.removeDice(indexPool);
        getPlayerFromID(iD).getPattern().putDiceOnPattern(dice, indexPattern, getPlayerFromID(iD).getPattern());
        setChanged();
        notifyObservers(new PatternUpdateEvent(getPlayerFromID(iD).getPlayerID(), getPlayerFromID(iD).getPattern(), getPlayerFromID(iD).getPlayerName()));
        setChanged();
        notifyObservers(new PlayerDraftPoolUpdateEvent(draftPool));
        setChanged();
        notifyObservers(new PlayerTokensUpdateEvent(getPlayerFromID(iD).getPlayerID(), getPlayerFromID(iD).getTokensNumber()));

    }

    public void setEndRoundAndNotify(){

        roundTracker.setTracker(draftPool.cleanListDice());
        setChanged();
        notifyObservers(new RoundTrackerUpdateEvent(this.getRoundTracker()));
        setChanged();
        notifyObservers(new PlayerDraftPoolUpdateEvent(draftPool));

    }

    public void setFinalPointsAndNotify(List<Player> playerList, boolean finish){

        setPlayerList(playerList);
        setChanged();
        notifyObservers(new PlayerPointsUpdateEvent(this.getPlayerList(), finish));
    }

    public void updatePoolAndNotify() {
        setChanged();
        notifyObservers(new UpdatePoolEvent(this.getDraftPool()));
    }

    public void updateBoardAndNotify(){

        setChanged();
        notifyObservers(new UpdateBoardEvent(this.getRoundTracker(), this.getDraftPool()));
    }

    public void updatePatternAndNotify(int iD){
        setChanged();
        notifyObservers(new PatternUpdateEvent(getPlayerFromID(iD).getPlayerID(), getPlayerFromID(iD).getPattern(), getPlayerFromID(iD).getPlayerName()));
    }

    public void updateTokenAndNotify(int iD){
        setChanged();
        notifyObservers(new PlayerTokensUpdateEvent(getPlayerFromID(iD).getPlayerID(), getPlayerFromID(iD).getTokensNumber()));
    }

    public void setPrivateSinglePlayerAndNotify(List<PrivateObjectiveCard> listPrivate){
        playerList.get(0).setPrivateSinglePlayer(listPrivate);
        setChanged();
        notifyObservers(new SinglePrivateEvent(playerList.get(0).getPrivateSinglePlayerCard()));
    }

}
