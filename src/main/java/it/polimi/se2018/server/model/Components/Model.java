package it.polimi.se2018.server.model.Components;


import it.polimi.se2018.exceptions.InvalidMoveException;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.PublicObjectiveCard;
import it.polimi.se2018.events.serverclient.modelview.*;
import it.polimi.se2018.events.singleplayer.SinglePrivateEvent;
import it.polimi.se2018.server.model.Cards.ToolCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.logging.Logger;

/**
 * class that store reference to the model components and getter/setter methods for them
 * @author adrianomundo
 */

public class Model extends Observable {

    private final Logger log = Logger.getLogger(Model.class.getName());
    private static final int DRAFTSINGLE = 3;
    private RoundTracker roundTracker;
    private List<ToolCard> toolCardList;
    private DraftPool draftPool;
    private DiceBag diceBag;
    private List<PublicObjectiveCard> publicList;
    private List<Player> playerList;
    private int numberPlayer;

    public Model() {
        this.toolCardList = new ArrayList<>();
        this.roundTracker = new RoundTracker();
        this.diceBag = new DiceBag();
        this.draftPool = new DraftPool(diceBag);
        this.playerList = new ArrayList<>();
        this.numberPlayer = 0;

    }

    public List<ToolCard> getToolCardList() {
        return toolCardList;
    }

    public int getNumberPlayer(){
        return numberPlayer;
    }

    public RoundTracker getRoundTracker() {
        return roundTracker;
    }

    public DiceBag getDiceBag() {
        return diceBag;
    }

    public DraftPool getDraftPool() {
        return draftPool;
    }

    public List<PublicObjectiveCard> getPublicList() {
        return publicList;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public Player getPlayerFromID(int id) {

        for (Player player1 : playerList)
        {
            if (player1.getPlayerID() == id) {
                return player1;
            }
        }
        return null;
    }
    public void setToolCardList(List<ToolCard> toolCardList) {
        this.toolCardList = toolCardList;
    }
    public void setNumberPlayer(int numberPlayer){
        this.numberPlayer = numberPlayer;
    }
    private void setPublicList(List<PublicObjectiveCard> publicList){
        this.publicList = publicList;
    }
    public void setPlayerList(List<Player> playerList){
        this.playerList = playerList;
    }

    //---------------metodi con notify

    public void setPlayerAndNotify(int id, String name) {
        numberPlayer++;
        getPlayerFromID(id).setPlayerName(name);
        log.info(getPlayerFromID(id).getPlayerName());
        setChanged();
        notifyObservers(new PlayerNameUpdateEvent(getPlayerFromID(id).getPlayerName(), id));
    }

    public void setPrivateAndNotify(int id, PrivateObjectiveCard privateCard){
        getPlayerFromID(id).setPrivate(privateCard);
        setChanged();
        notifyObservers(new PlayerPrivateUpdateEvent(getPlayerFromID(id).getPlayerID(), privateCard));
    }

    public void setPublicAndNotify(List<PublicObjectiveCard> publicList){
        this.setPublicList(publicList);
        setChanged();
        notifyObservers(new PublicDrawEvent(this.publicList));
    }

    public void setPatternAndNotify(int id, int indexPatternChoose){
        numberPlayer++;
        getPlayerFromID(id).setPattern(getPlayerFromID(id).getPatterChooseList().get(indexPatternChoose));
        setChanged();
        notifyObservers(new PlayerPatternUpdateEvent(id, getPlayerFromID(id).getPattern()));
    }

    public void setCustomPatternAndNotify(int id, PatternCard patternCard) {
        numberPlayer++;
        getPlayerFromID(id).setPattern(patternCard);
        getPlayerFromID(id).getPattern().setCustom(true);
        setChanged();
        notifyObservers(new PlayerPatternUpdateEvent(id, getPlayerFromID(id).getPattern()));
    }

    public void setTokenAndNotify(int id) {
        Player player1 = getPlayerFromID(id);
        player1.setTokensNumber(player1.getPattern().getDifficulty());
        setChanged();
        notifyObservers(new PlayerTokensUpdateEvent(id, getPlayerFromID(id).getTokensNumber()));
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

    public void setMoveAndNotify(int id, int indexPool, int indexPattern) throws InvalidMoveException {
        Dice dice = draftPool.removeDice(indexPool);
        getPlayerFromID(id).getPattern().putDiceOnPattern(dice, indexPattern, getPlayerFromID(id).getPattern());
        setChanged();
        notifyObservers(new PatternUpdateEvent(getPlayerFromID(id).getPlayerID(), getPlayerFromID(id).getPattern(), getPlayerFromID(id).getPlayerName()));
        setChanged();
        notifyObservers(new PlayerDraftPoolUpdateEvent(draftPool));
        setChanged();
        notifyObservers(new PlayerTokensUpdateEvent(getPlayerFromID(id).getPlayerID(), getPlayerFromID(id).getTokensNumber()));
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

    public void updatePatternAndNotify(int id){
        setChanged();
        notifyObservers(new PatternUpdateEvent(getPlayerFromID(id).getPlayerID(), getPlayerFromID(id).getPattern(), getPlayerFromID(id).getPlayerName()));
    }

    public void updateTokenAndNotify(int id){
        setChanged();
        notifyObservers(new PlayerTokensUpdateEvent(getPlayerFromID(id).getPlayerID(), getPlayerFromID(id).getTokensNumber()));
    }

    public void setPrivateSinglePlayerAndNotify(List<PrivateObjectiveCard> listPrivate){
        playerList.get(0).setPrivateSinglePlayer(listPrivate);
        setChanged();
        notifyObservers(new SinglePrivateEvent(playerList.get(0).getPrivateSinglePlayerCard()));
    }

}
