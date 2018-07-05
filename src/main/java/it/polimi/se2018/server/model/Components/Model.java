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
 * Class Model: the model represents the model of the MVC pattern applied to the project, the class extends Observable
 * because it's observable by the virtual view in case of modification.
 * The model store the references to the model components and use getter and setter methods to access them.
 * The model is responsible of modification of the components and after that send a notification to the virtual view.
 * The model methods are accessible and callable only by the controller GameController to modify the components
 * @author fadda-miceli-mundo
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

    /**
     * Class default constructor re-definition
     */
    public Model() {
        this.toolCardList = new ArrayList<>();
        this.roundTracker = new RoundTracker();
        this.diceBag = new DiceBag();
        this.draftPool = new DraftPool(diceBag);
        this.playerList = new ArrayList<>();
        this.numberPlayer = 0;

    }

    /**
     * method that provides the caller the Tool Card List stored in the model at the moment of the call
     * @return a list of the Tool Card
     */
    public List<ToolCard> getToolCardList() {
        return toolCardList;
    }

    /**
     * method that provides the caller the number of players of the current match stored in the model at
     * the moment of the call
     * @return an int value of the number of players
     */
    public int getNumberPlayer(){
        return numberPlayer;
    }

    /**
     * method that provides the caller the Round Tracker stored in the model at the moment of the call
     * @return Round Tracker type
     */
    public RoundTracker getRoundTracker() {
        return roundTracker;
    }

    /**
     * method that provides the caller the Dice Bag stored in the model at the moment of the call
     * @return Dice bag type
     */
    public DiceBag getDiceBag() {
        return diceBag;
    }

    /**
     * method that provides the caller the Draft Pool stored in the model at the moment of the call
     * @return Draft Pool type
     */
    public DraftPool getDraftPool() {
        return draftPool;
    }

    /**
     * method that provides the caller the list of the Public Card stored in the model at the moment of the call
     * @return a list of Public Card type
     */
    public List<PublicObjectiveCard> getPublicList() {
        return publicList;
    }

    /**
     * method that provides the caller the list of Players stored in the model at the moment of the call
     * @return a list of Players type
     */
    public List<Player> getPlayerList() {
        return playerList;
    }

    /**
     * method that provides the caller the Player associated with the unique id stored in the model at the moment
     * of the call
     * @param id of the player needed
     * @return the Player with id passed as param
     */
    public Player getPlayerFromID(int id) {

        for (Player player1 : playerList) {
            if (player1.getPlayerID() == id) {
                return player1;
            }
        }
        return null;
    }

    /**
     * method that allow the caller to set the Tool Card list stored in the model
     * @param toolCardList to set in the model
     */
    public void setToolCardList(List<ToolCard> toolCardList) {
        this.toolCardList = toolCardList;
    }

    /**
     * method that allow the caller to set the number of players stored in the model
     * @param numberPlayer to set in the model
     */
    public void setNumberPlayer(int numberPlayer){
        this.numberPlayer = numberPlayer;
    }

    /**
     * method that allow the caller to set the Public Card list stored in the model
     * @param publicList to set in the model
     */
    private void setPublicList(List<PublicObjectiveCard> publicList){
        this.publicList = publicList;
    }

    /**
     * method that allow the caller to set the Player list stored in the model
     * @param playerList to set in the model
     */
    public void setPlayerList(List<Player> playerList){
        this.playerList = playerList;
    }


    /**
     * method that allow the controller to set the name of the player of the specified id as parameter, after that
     * send a notification to the virtual view of the changes of the model
     * @param id of the player
     * @param name to set to the player
     */
    public void setPlayerAndNotify(int id, String name) {
        numberPlayer++;
        getPlayerFromID(id).setPlayerName(name);
        log.info(getPlayerFromID(id).getPlayerName());
        setChanged();
        notifyObservers(new PlayerNameUpdateEvent(getPlayerFromID(id).getPlayerName(), id));
    }

    /**
     * method that allow the controller to set the Private Card of the player of the specified id as parameter, after
     * that send a notification to the virtual view of the changes of the model
     * @param id of the player
     * @param privateCard to set to the player
     */
    public void setPrivateAndNotify(int id, PrivateObjectiveCard privateCard){
        getPlayerFromID(id).setPrivate(privateCard);
        setChanged();
        notifyObservers(new PlayerPrivateUpdateEvent(getPlayerFromID(id).getPlayerID(), privateCard));
    }

    /**
     * method that allow the controller to set the Public Card List of the match, after that send a notification to the
     * virtual view of the changes of the model
     * @param publicList to set to the model
     */
    public void setPublicAndNotify(List<PublicObjectiveCard> publicList){
        this.setPublicList(publicList);
        setChanged();
        notifyObservers(new PublicDrawEvent(this.publicList));
    }

    /**
     * method that allow the controller to set the Pattern Card of the player of the specified id as parameter, after
     * that send a notification to the virtual view of the changes of the model
     * @param id of the player
     * @param indexPatternChoose of the pattern to set in the model
     */
    public void setPatternAndNotify(int id, int indexPatternChoose){
        numberPlayer++;
        getPlayerFromID(id).setPattern(getPlayerFromID(id).getPatterChooseList().get(indexPatternChoose));
        setChanged();
        notifyObservers(new PlayerPatternUpdateEvent(id, getPlayerFromID(id).getPattern()));
    }

    /**
     * method that allow the controller to set the Custom Pattern of the player of the specified id as parameter, after
     * that send a notification to the virtual view of the changes of the model
     * @param id of the player
     * @param patternCard to set in the model
     */
    public void setCustomPatternAndNotify(int id, PatternCard patternCard) {
        numberPlayer++;
        getPlayerFromID(id).setPattern(patternCard);
        getPlayerFromID(id).getPattern().setCustom(true);
        setChanged();
        notifyObservers(new PlayerPatternUpdateEvent(id, getPlayerFromID(id).getPattern()));
    }

    /**
     * method that allow the controller to set the tokens number of the player of the specified id as parameter, after
     * that send a notification to the virtual view of the changes of the model
     * @param id of the player
     */
    public void setTokenAndNotify(int id) {
        Player player1 = getPlayerFromID(id);
        player1.setTokensNumber(player1.getPattern().getDifficulty());
        setChanged();
        notifyObservers(new PlayerTokensUpdateEvent(id, getPlayerFromID(id).getTokensNumber()));
    }

    /**
     * method that allow the controller to set Draft Pool, after that send a notification to the virtual view of the
     * changes of the model
     * @param singlePlayer boolean of the different game modality
     */
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

    /**
     * method that allow the controller to set in the model the move done by the player of the specified is as parameter,
     * after that send a notification the the virtual view of the changes of the model
     * @param id of the player
     * @param indexPool index of the dice in the pool
     * @param indexPattern index of the box of the pattern card
     * @throws InvalidMoveException
     */
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

    /**
     * method that allow the controller to set the end round and the associated event to the model, after that send a
     * notification to the virtual view of the changes of the model
     */
    public void setEndRoundAndNotify(){
        roundTracker.setTracker(draftPool.cleanListDice());
        setChanged();
        notifyObservers(new RoundTrackerUpdateEvent(this.getRoundTracker()));
        setChanged();
        notifyObservers(new PlayerDraftPoolUpdateEvent(draftPool));
    }

    /**
     * method that allow the controller to set the final points to the the list of player in the model, and after that
     * send a notification to the virtual view of the changes of the model
     * @param playerList list of player to set
     * @param finish to alert if the game is ended before the match start
     */
    public void setFinalPointsAndNotify(List<Player> playerList, boolean finish){
        setPlayerList(playerList);
        setChanged();
        notifyObservers(new PlayerPointsUpdateEvent(this.getPlayerList(), finish));
    }

    /**
     * method that send a notification to the virtual view after the changes of the Draft Pool in the model
     */
    public void updatePoolAndNotify() {
        setChanged();
        notifyObservers(new UpdatePoolEvent(this.getDraftPool()));
    }

    // todo javadoc
    /**
     *
     */
    public void updateBoardAndNotify(){
        setChanged();
        notifyObservers(new UpdateBoardEvent(this.getRoundTracker(), this.getDraftPool()));
    }

    /**
     *
     * @param id
     */
    public void updatePatternAndNotify(int id){
        setChanged();
        notifyObservers(new PatternUpdateEvent(getPlayerFromID(id).getPlayerID(), getPlayerFromID(id).getPattern(), getPlayerFromID(id).getPlayerName()));
    }

    /**
     *
     * @param id
     */
    public void updateTokenAndNotify(int id){
        setChanged();
        notifyObservers(new PlayerTokensUpdateEvent(getPlayerFromID(id).getPlayerID(), getPlayerFromID(id).getTokensNumber()));
    }

    /**
     * method that allow the controller to set the Private Card list of the player in the model
     * @param listPrivate
     */
    public void setPrivateSinglePlayerAndNotify(List<PrivateObjectiveCard> listPrivate){
        playerList.get(0).setPrivateSinglePlayer(listPrivate);
        setChanged();
        notifyObservers(new SinglePrivateEvent(playerList.get(0).getPrivateSinglePlayerCard()));
    }

}
