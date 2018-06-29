package it.polimi.se2018.server.model.Components;


import it.polimi.se2018.exceptions.InvalidMoveException;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.PublicObjectiveCard;
import it.polimi.se2018.server.model.Events.InvalidMoveEvent;
import it.polimi.se2018.server.model.Events.ServerClient.ControllerView.StartMoveEvent;
import it.polimi.se2018.server.model.Events.ServerClient.ModelView.*;
import it.polimi.se2018.server.model.Events.SinglePlayer.SinglePrivateEvent;

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
    private Player player;
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

    public Player getPlayer() {
        return player;
    }

    public List<PublicObjectiveCard> getPublicList() {
        return publicList;
    }

    public void setPublicList(List<PublicObjectiveCard> publicList){
        this.publicList = publicList;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList){
        this.playerList = playerList;
    }

    // todo gestione da file del timer
    public int getTimeToPlay() {
        return timeToPlay;
    }

    public DiceBag getDiceBag() {
        return diceBag;
    }


    public Player getPlayerFromID(int ID) {

        for (Player player1 : playerList)
        {
            if (player1.getPlayerID() == ID) {
                return player1;
            }
        }
        return null;
    }


    public void setPlayerAndNotify(int ID, String name) {

        numberPlayer++;
        getPlayerFromID(ID).setPlayerName(name);
        System.out.println(getPlayerFromID(ID).getPlayerName());
        setChanged();
        notifyObservers(new PlayerNameUpdateEvent(getPlayerFromID(ID).getPlayerName(), ID));

    }

    public void setPrivateAndNotify(int ID, PrivateObjectiveCard privateCard){

        getPlayerFromID(ID).setPrivate(privateCard);
        setChanged();
        notifyObservers(new PlayerPrivateUpdateEvent(getPlayerFromID(ID).getPlayerID(), privateCard));
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

    public void setCustomPatternAndNotify(int ID, PatternCard patternCard) {
        numberPlayer++;
        getPlayerFromID(ID).setPattern(patternCard);
        getPlayerFromID(ID).getPattern().setCustom(true);
        setChanged();
        notifyObservers(new PlayerPatternUpdateEvent(ID, getPlayerFromID(ID).getPattern()));
    }

    public void setTokenAndNotify(int ID) {

        Player player1 = getPlayerFromID(ID);
        player1.setTokensNumber(player1.getPattern().getDifficulty());
        setChanged();
        notifyObservers(new PlayerTokensUpdateEvent(ID, getPlayerFromID(ID).getTokensNumber()));
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

    public void setMoveAndNotify(int ID, int indexPool, int indexPattern) throws InvalidMoveException {

        dice = draftPool.removeDice(indexPool);
        getPlayerFromID(ID).getPattern().putDiceOnPattern(dice, indexPattern, getPlayerFromID(ID).getPattern());
        setChanged();
        notifyObservers(new PatternUpdateEvent(getPlayerFromID(ID).getPlayerID(), getPlayerFromID(ID).getPattern(), getPlayerFromID(ID).getPlayerName()));
        setChanged();
        notifyObservers(new PlayerDraftPoolUpdateEvent(draftPool));
        setChanged();
        notifyObservers(new PlayerTokensUpdateEvent(getPlayerFromID(ID).getPlayerID(), getPlayerFromID(ID).getTokensNumber()));

    }

    public void setEndRoundAndNotify(){

        roundTracker.setTracker(draftPool.cleanListDice());
        setChanged();
        notifyObservers(new RoundTrackerUpdateEvent(this.getRoundTracker()));
        setChanged();
        notifyObservers(new PlayerDraftPoolUpdateEvent(draftPool));

    }

    public void setFinalPointsAndNotify(List<Player> playerList){

        setPlayerList(playerList);
        setChanged();
        notifyObservers(new PlayerPointsUpdateEvent(this.getPlayerList()));
    }

    public void updatePoolAndNotify() {
        setChanged();
        notifyObservers(new UpdatePoolEvent(this.getDraftPool()));
    }

    public void updateBoardAndNotify(){

        setChanged();
        notifyObservers(new UpdateBoardEvent(this.getRoundTracker(), this.getDraftPool()));
    }

    public void updatePatternAndNotify(int ID){
        setChanged();
        notifyObservers(new PatternUpdateEvent(getPlayerFromID(ID).getPlayerID(), getPlayerFromID(ID).getPattern(), getPlayerFromID(ID).getPlayerName()));
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
