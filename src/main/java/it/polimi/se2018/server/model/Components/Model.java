package it.polimi.se2018.server.model.Components;


import it.polimi.se2018.events.serverclient.controllerview.ToolCardUpdateEvent;
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
import java.util.Random;
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
    private Dice diceToolSinglePlayer;
    private ToolCard toolRemoveSinglePlayer;

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
     * method that provides the toolcard corresponding to the specified index in the toolCardList
     * @param indexTool the index of the tool card in the toolCardList
     */
    public ToolCard getTool(int indexTool) {
        for (ToolCard toolCard : getToolCardList()) {
            if (toolCard.getNumber() == indexTool) {
                return toolCard;
            }
        }
        return null;
    }

    /**
     * method that provides the caller the dice selected by player in the single-player mode for using tool card
     * @return a dice
     */
    public Dice getDiceToolSinglePlayer(){
        return diceToolSinglePlayer;
    }

    /**
     * method that provides the caller the last tool card used by player in the single-player mode
     * @return a tool card
     */
    public ToolCard getToolRemoveSinglePlayer(){
        return toolRemoveSinglePlayer;
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
     * method that allow the controller to set the Private Card list of the player in the model
     * @param listPrivate to set to the player in the single game mode
     */
    public void setPrivateSinglePlayerAndNotify(List<PrivateObjectiveCard> listPrivate){
        playerList.get(0).setPrivateSinglePlayer(listPrivate);
        setChanged();
        notifyObservers(new SinglePrivateEvent(playerList.get(0).getPrivateSinglePlayerCard()));
    }

    /**
     * method that send a notification to the virtual view after the changes of the Draft Pool in the model
     */
    public void updatePoolAndNotify() {
        setChanged();
        notifyObservers(new UpdatePoolEvent(this.getDraftPool()));
    }

    /**
     * method that send a notification to the virtual view after the changes of the Board in the model
     */
    public void updateBoardAndNotify(){
        setChanged();
        notifyObservers(new UpdateBoardEvent(this.getRoundTracker(), this.getDraftPool()));
    }

    /**
     * method that send a notification to the virtual view after the changes of the Pattern card of the player with
     * the specified id in the model
     * @param id of the player
     */
    public void updatePatternAndNotify(int id){
        setChanged();
        notifyObservers(new PatternUpdateEvent(getPlayerFromID(id).getPlayerID(), getPlayerFromID(id).getPattern(), getPlayerFromID(id).getPlayerName()));
    }

    /**
     * method that send a notification to the virtual view after the changes of the tokens of the player with the
     * specified id in the model
     * @param id ofthe player
     */
    public void updateTokenAndNotify(int id){
        setChanged();
        notifyObservers(new PlayerTokensUpdateEvent(getPlayerFromID(id).getPlayerID(), getPlayerFromID(id).getTokensNumber()));
    }

    /**
     * method used to reset to the previous state the value of the tokens if the player decided not to use it or an error occurred
     * @param singlePlayer mode of the game
     * @param id of the player
     * @param toolNumber of the player in that moment
     */
    public void tokenRefactor(boolean singlePlayer, int id, int toolNumber) {
        if (singlePlayer) {
            getDraftPool().getDraftPool().add(getDiceToolSinglePlayer());
            updatePoolAndNotify();
            getToolCardList().add(getToolRemoveSinglePlayer());
        }
        else if (getTool(toolNumber).getUsage() == 1) {
            getTool(toolNumber).setCost(1);
            int token = getPlayerFromID(id).getTokensNumber();
            getPlayerFromID(id).setTokensNumber(token + 1);
            getTool(toolNumber).setUsage(0);
        }
        else {
            int tokenNumber = getPlayerFromID(id).getTokensNumber();
            getPlayerFromID(id).setTokensNumber(tokenNumber + 2);
        }
    }

    /**
     * method that check if the dice at the index in the draft pool match the color of the tool card in the list
     * @param indexPool index of the dice in the draft pool
     * @param indexTool index of the card in the tool card list
     * @return boolean value of the check
     */
    public boolean checkDiceModel(int indexPool, int indexTool) {
        return (getDraftPool().getDraftPool().get(indexPool).getColor().toString().equals(getToolCardList().get(indexTool).getColor().toString()));
    }

    /**
     * method that check if the the player has enough tokens to use a tool card
     * @param id of the player
     * @param indexTool of the tool card in the list
     * @return boolean value of the check
     */
    public boolean checkCostModel(int id, int indexTool) {
         return getPlayerFromID(id).getTokensNumber() < getToolCardList().get(indexTool).getCost();
    }

    /**
     * method that check if the dice at the two index of a pattern card have the same color
     * @param id of the  player
     * @param indexStart of the box of the pattern card of the player
     * @param indexStartTwo of the box of the pattern card of the player
     * @return boolean value of the check
     */
    public boolean checkEqualsDice(int id, int indexStart, int indexStartTwo) {
        return getPlayerFromID(id).getPattern().getDice(indexStart).getColor().equals(getPlayerFromID(id).getPattern().getDice(indexStartTwo).getColor());
    }

    /**
     * method that remove the dice from the draft pool and the tool card from the list after a player in the
     * single game mode used the tool card
     * @param indexPool index of the dice in the draft pool
     * @param indexTool index of the tool card in the list
     */
    public void removeToolSingle(int indexPool, int indexTool) {
        diceToolSinglePlayer = getDraftPool().removeDice(indexPool);
        updatePoolAndNotify();
        toolRemoveSinglePlayer = getToolCardList().remove(indexTool);
    }

    /**
     * method that set the usage of a tool card by a specified player
     * @param id of the player
     * @param indexTool index of the card in the tool card list
     */
    public void setUsageToolCard(int id, int indexTool) {
        getToolCardList().get(indexTool).incrementUsage();
        int token = getPlayerFromID(id).getTokensNumber();
        getPlayerFromID(id).setTokensNumber(token - getToolCardList().get(indexTool).getCost());
        if (getToolCardList().get(indexTool).getCost() == 1) {
            getToolCardList().get(indexTool).setCost(2);
        }
    }

    /**
     * method that send the notification to the virtual view at the end of the
     * use of a tool card to update the state  of the token and the tool card
     * @param singlePlayer game mode
     * @param id of the player/virtual view
     */
    public void endToolCard(boolean singlePlayer, int id) {

        if (!singlePlayer) {
            updateTokenAndNotify(id);
        }
        else {
            setChanged();
            notifyObservers(new ToolCardUpdateEvent(getToolCardList()));
        }
    }

    /**
     * method that's responsible to add a dice in the draft pool representation in the model and send a notify of the changes
     * to the virtual view
     * @param dice to add to the draft pool
     */
    public void addDicePool(Dice dice) {
        this.getDraftPool().getDraftPool().add(dice);
        updatePoolAndNotify();
    }

    // for tool card 1,6,10

    /**
     * method that manage the modification of the the value of a dice, depending on the different tool card used that have
     * similar effects on the value of the dice
     * @param indexPool index of the dice in the draft pool
     * @param increase indicates if increase or decrease the value of a dice
     * @param number the tool card on which run the effect
     * @throws InvalidMoveException
     */
    public void setDiceValue(int indexPool, int increase, int number) throws InvalidMoveException  {

        if (number == 1) {
            Dice dice = getDraftPool().getDraftPool().get(indexPool);
            if (increase == 0) {
                if (dice.getValue() == 1) {
                    updatePoolAndNotify();
                    throw new InvalidMoveException("Not valid decrease if value is 1");
                }
                else {
                    dice.setValue(dice.getValue() - 1);
                }
            }
            if (increase == 1) {
                if (dice.getValue() == 6) {
                    updatePoolAndNotify();
                    throw new InvalidMoveException("Not valid increase if value is 6");
                }
                else {
                    dice.setValue(dice.getValue() + 1);
                }
            }
            updateBoardAndNotify();
        }
        if (number == 10) {
            int value = getDraftPool().getDraftPool().get(indexPool).getValue();
            getDraftPool().getDraftPool().get(indexPool).setValue(7 - value);
            updateBoardAndNotify();
        }
        if (number == 6) {
            Random random = new Random();
            int newValue = random.nextInt(6) + 1;
            getDraftPool().getDraftPool().get(indexPool).setValue(newValue);
            updateBoardAndNotify();
        }
    }

    // for tool card 2,3,4,12

    /**
     * method that manage the put of the first dice on the pattern card of a player depending on the different tool card
     * that have similar effects on moving and putting dice on the card
     * @param id of the player
     * @param indexStart where to take the dice
     * @param indexEnd where to put the dice
     * @param number of the tool card at the moment of the call
     * @throws InvalidMoveException
     */
    public void putFirstDiceToolCard(int id, int indexStart, int indexEnd, int number) throws InvalidMoveException {
        if (number == 2) {
            Dice dice = getPlayerFromID(id).getPattern().removeDice(indexStart);
            try {
                getPlayerFromID(id).getPattern().putDiceOnPatternEglomise(dice, indexEnd, getPlayerFromID(id).getPattern());
                updatePatternAndNotify(id);
            }
            catch (InvalidMoveException e) {
                getPlayerFromID(id).getPattern().putAnyDice(dice, indexStart);
                throw new InvalidMoveException(e.getMessage());
            }
            catch (NullPointerException e) {
                updatePatternAndNotify(id);
                throw new NullPointerException(e.getMessage());
            }
        }
        if (number == 3) {
            Dice dice = getPlayerFromID(id).getPattern().removeDice(indexStart);
            try {
                getPlayerFromID(id).getPattern().putDiceOnPatternCopper(dice, indexEnd, getPlayerFromID(id).getPattern());
                updatePatternAndNotify(id);
            }
            catch (InvalidMoveException e) {
                getPlayerFromID(id).getPattern().putAnyDice(dice, indexStart);
                throw new InvalidMoveException(e.getMessage());
            }
            catch (NullPointerException  e) {
                updatePatternAndNotify(id);
                throw new NullPointerException(e.getMessage());
            }
        }
        if (number == 4) {
            Dice dice = getPlayerFromID(id).getPattern().removeDice(indexStart);
            try {
                getPlayerFromID(id).getPattern().putDiceOnPattern(dice, indexEnd, getPlayerFromID(id).getPattern());
            }
            catch (InvalidMoveException e) {
                getPlayerFromID(id).getPattern().putAnyDice(dice, indexStart);
                updatePatternAndNotify(id);
                throw new InvalidMoveException("Error first dice 4");
            }
            catch (NullPointerException e) {
                updatePatternAndNotify(id);
                throw new NullPointerException(e.getMessage());
            }
        }
        if (number == 12) {
            Dice dice = getPlayerFromID(id).getPattern().removeDice(indexStart);
            try {
                getPlayerFromID(id).getPattern().putDiceOnPattern(dice, indexEnd, getPlayerFromID(id).getPattern());
                updatePatternAndNotify(id);
            }
            catch (InvalidMoveException e) {
                getPlayerFromID(id).getPattern().putAnyDice(dice, indexStart);
                updatePatternAndNotify(id);
                throw new InvalidMoveException("Error first dice 12");
            }
            catch (NullPointerException e) {
                updatePatternAndNotify(id);
                throw new NullPointerException(e.getMessage());
            }
        }
    }

    // for tool card 4,12

    /**
     * method that manage the put of a second dice on the pattern card of a player depending on the different tool card
     * that have similar effects on moving and putting dice on the card
     * @param id of the player
     * @param indexStartOne where to take the first dice
     * @param indexEndOne where to move the first dice
     * @param indexStartTwo where to take the second dice
     * @param indexEndTwo where to move the second dice
     * @param number of the tool card used
     * @throws InvalidMoveException
     */
    public void putSecondDiceToolCard(int id, int indexStartOne, int indexEndOne, int indexStartTwo, int indexEndTwo, int number) throws InvalidMoveException {
        if (number == 4) {
            Dice dice = getPlayerFromID(id).getPattern().removeDice(indexStartTwo);
            try {
                getPlayerFromID(id).getPattern().putDiceOnPattern(dice, indexEndTwo, getPlayerFromID(id).getPattern());
                updatePatternAndNotify(id);
            }
            catch (InvalidMoveException e) {
                Dice dice1 = getPlayerFromID(id).getPattern().removeDice(indexEndOne);
                getPlayerFromID(id).getPattern().putAnyDice(dice1, indexStartOne);
                getPlayerFromID(id).getPattern().putAnyDice(dice, indexStartTwo);
                updatePatternAndNotify(id);
                throw new InvalidMoveException("Error second dice 4");
            }
            catch (NullPointerException e) {
                Dice dice1 = getPlayerFromID(id).getPattern().removeDice(indexEndOne);
                getPlayerFromID(id).getPattern().putAnyDice(dice1, indexStartOne);
                getPlayerFromID(id).getPattern().putAnyDice(dice, indexStartTwo);
                updatePatternAndNotify(id);
                throw new NullPointerException(e.getMessage());
            }
        }
        if (number == 12) {
            Dice dice = getPlayerFromID(id).getPattern().removeDice(indexStartTwo);
            try {
                getPlayerFromID(id).getPattern().putDiceOnPattern(dice, indexEndTwo, getPlayerFromID(id).getPattern());

            }
            catch (InvalidMoveException e) {
                Dice dice1 = getPlayerFromID(id).getPattern().removeDice(indexEndOne);
                getPlayerFromID(id).getPattern().putAnyDice(dice1, indexStartOne);
                getPlayerFromID(id).getPattern().putAnyDice(dice, indexEndTwo);

                throw new InvalidMoveException("Error second dice 12");
            }
            catch (NullPointerException e) {
                Dice dice1 = getPlayerFromID(id).getPattern().removeDice(indexEndOne);
                getPlayerFromID(id).getPattern().putAnyDice(dice1, indexStartOne);
                getPlayerFromID(id).getPattern().putAnyDice(dice, indexEndTwo);

                throw new NullPointerException(e.getMessage());
            }
            finally {
                updatePatternAndNotify(id);
            }

        }
    }

    //for tool card 8-9

    /**
     * method that manage the put of a dice on the pattern card of a player depending on the draft pool available at
     * the moment and the tool card used, used to integrate tool cards that have similar effects on putting dice on the card
     * @param id of the player
     * @param indexPool index of the dice in the draft pool
     * @param indexPattern index of the box of the pattern card where to put the dice
     * @param number of the tool card used
     * @throws InvalidMoveException
     */
    public void putDiceToolCard(int id, int indexPool, int indexPattern, int number) throws InvalidMoveException {

        if (number == 8) {
            Dice dice = getDraftPool().getDraftPool().remove(indexPool);
            try {
                getPlayerFromID(id).getPattern().putDiceOnPattern(dice, indexPattern, getPlayerFromID(id).getPattern());
                getPlayerFromID(id).setRunningP(true);
                updatePatternAndNotify(id);
                updateBoardAndNotify();
                updateTokenAndNotify(id);
            }
            catch (InvalidMoveException e) {
                getDraftPool().getDraftPool().add(dice);
                updatePoolAndNotify();
            }
        }
        if (number == 9) {
            Dice dice = getDraftPool().getDraftPool().remove(indexPool);
            try {
                getPlayerFromID(id).getPattern().putDice(dice, indexPattern);
                updatePatternAndNotify(id);
                updateBoardAndNotify();
            }
            catch (InvalidMoveException e) {
                getDraftPool().getDraftPool().add(dice);
                updatePoolAndNotify();
                throw new InvalidMoveException(e.getMessage());
            }
        }
    }

    //for toolcard 5

    /**
     * method responsible to make an exchange between a dice in the draft pool and one in the Round Tracker
     * @param id of the player
     * @param indexPool of the dice in the draft pool
     * @param indexRound of the round at the moment of the call
     * @param indexPosition index of the dice in the current round
     */
    public void exchangePoolRoundTracker(int id, int indexPool, int indexRound, int indexPosition) {
        Dice dice1 = getDraftPool().getDraftPool().remove(indexPool);
        Dice dice2 = getRoundTracker().getDice(indexRound, indexPosition);
        getDraftPool().setDice(dice2);
        getRoundTracker().addDice(dice1, indexRound);
        updateBoardAndNotify();
    }


    //for toolcard 11

    /**
     * method responsible to make an exchange between a dice in the draft pool and one in the Dice Bag
     * @param indexPool of the dice in the draft pool
     * @param value of the new dice drafted from the bag
     * @param dice to put in the pool
     */
    public void exchangePoolBag(int indexPool, int value, Dice dice) {
        dice.setValue(value);
        Dice dice1 = getDraftPool().getDraftPool().remove(indexPool);
        getDiceBag().setDice(dice1);
        getDraftPool().setDice(dice);
        updateBoardAndNotify();
    }


    //for toolcard 7

    /**
     * method responsible to clean and re-roll all the dice in the draft pool
     */
    public void shufflePool() {

        List<Dice> diceList = getDraftPool().cleanListDice();
        for (Dice dice : diceList) {
            Random random = new Random();
            int value = random.nextInt(6) + 1;
            dice.setValue(value);
            getDraftPool().setDice(dice);
        }
        updateBoardAndNotify();
    }



}
