package it.polimi.se2018.server.controller;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import it.polimi.se2018.exceptions.InvalidMoveException;
import it.polimi.se2018.server.network.VirtualView;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Components.Dice;
import it.polimi.se2018.server.model.Components.Model;
import it.polimi.se2018.server.model.Components.Player;
import it.polimi.se2018.events.clientserver.*;
import it.polimi.se2018.events.InvalidMoveEvent;
import it.polimi.se2018.events.serverclient.controllerview.*;
import it.polimi.se2018.events.serverclient.modelview.PlayerIDEvent;
import it.polimi.se2018.events.singleplayer.*;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.logging.Logger;

/**
 * Class GameController: the class represents the controller of the MVC pattern used for this project, the class implements
 * the interface Observer because receives the notify from the view, from which the controller updates its state and
 * knows how to modify the model to obey to the user input. The class is responsible of the creation of the new game and
 * of the settings of the observer/observable and the model of the different virtual view connected to the game. The class
 * is used to managing the application logic and the state of the game
 * @see java.util.Observer
 * @author fadda-miceli-mundo
 */
public class GameController implements Observer {

    private final Logger log = Logger.getLogger(GameController.class.getName());
    private static final int DEFAULT = 0;
    private static final int START = 1;
    private static final int END = 10;
    private static final int SET = 2;
    private Model model;
    private List<VirtualView> viewGame;
    private GameSetup setup;
    private PointsManager pointsManager;
    private int turn = DEFAULT;
    private int round = START;
    private int currID;
    private boolean notEnded;
    private int singlePlayerDifficulty;
    private int step;
    private int disconnectPlayerNumber;
    private List<String> activeNames;
    private boolean singlePlayer;
    private int TIMERTURN;
    private int disconnectName;
    private Timer timer;
    private ToolCardController toolController;


    /**
     * Class constructor for the game controller with a list of virtual view to link to the game and the game mode
     * @param viewList list of virtual view connected to the game
     * @param singlePlayer true if the game mode is single-player, else multi-player
     */
    public GameController(List<VirtualView> viewList, boolean singlePlayer) {
        Model modelGame = new Model();
        createGame(viewList, singlePlayer, modelGame);
    }

    /**
     * Class constructor for the game controller with a list of virtual view to link to the game and the game mode
     * and the model linked to this controller
     * @param viewList list of virtual view connected to the game
     * @param singlePlayer true if the game mode is single-player, else multi-player
     * @param model the model
     */
    public GameController(List<VirtualView> viewList, boolean singlePlayer, Model model) {
        createGame(viewList, singlePlayer, model);
    }

    /**
     * method responsible for the creation of every aspects of the Game and the game controller, the method load from
     * a file json the useful settings (timer of the turn), and create the list of the virtual view in the game composed by
     * the different virtual view connected to the game, independently by the technology used to connect to the server.
     * The method also set the model for the current controller instance, set the observer and the model of the virtual view
     * and at the start a new game
     * @param viewList of virtual view connected
     * @param singlePlayer game mode
     * @param model model associated with the controller
     */
    private void createGame(List<VirtualView> viewList, boolean singlePlayer, Model model) {

        Gson gson = new Gson();
        this.model = model;
        this.viewGame = new ArrayList<>(viewList);
        this.setup = new GameSetup(this);
        this.pointsManager = new PointsManager();
        this.toolController = new ToolCardController(this);
        this.singlePlayer = singlePlayer;
        this.disconnectPlayerNumber = DEFAULT;
        this.activeNames = new ArrayList<>();
        this.currID = -1;
        this.notEnded = true;
        this.disconnectName = DEFAULT;

        InputStream fileStream = GameController.class.getResourceAsStream("/json/settings" + ".json");
        JsonObject jsonObject = gson.fromJson(new JsonReader(new InputStreamReader(fileStream)), JsonObject.class);
        TIMERTURN = jsonObject.get("timerTurn").getAsInt();

        List<Player> playerList = new ArrayList<>();

        for (VirtualView view: viewGame) {
            Player player = new Player(view.getPlayerID());
            log.info("Player id in new GameController" + player.getPlayerID());
            playerList.add(player);
        }

        this.model.setPlayerList(playerList);

        for (VirtualView view : viewGame) {
            view.addObserver(this);
            view.addObserver(toolController);
            view.setModel(model);
            this.model.addObserver(view);
        }
        startGame();


    }

    /**
     * method that provides the caller the list of virtual views linked to the controller
     * @return a list of virtual views
     */
    List<VirtualView> getViewGame(){
        return viewGame;
    }

    /**
     * method that provides the caller current turn number from 0 to number of player multiplied by 2
     * @return current turn number
     */
    int getTurn(){
        return turn;
    }

    /**
     * method that provides the caller the current step of the player's turn:  0 using dice, 1 using tool card
     * @return number identifier of current step of the turn
     */
    int getStep(){
        return step;
    }

    /**
     * method that provides the caller the difficulty of single-player mode chosen by the player, the difficulty
     * goes from 1 to 5 indicates the number of tool card given at the start of the game
     * @return difficulty number
     */
    int getSinglePlayerDifficulty(){
        return singlePlayerDifficulty;
    }

    /**
     * method that provides the caller the identifier number of the player that is playing in the current turn
     * @return current player identifier
     */
    private int getCurrID() {
        return currID;
    }

    /**
     * method that provides the caller true if the mode of the game is single-player
     * @return true if single-player mode
     */
    protected boolean isSinglePlayer(){
        return singlePlayer;
    }

    /**
     * method that provides the caller the model linked of this controller through which can access
     * to the model's components and methods
     * @return the model
     */
    protected Model getModel(){
        return model;
    }

    /**
     * method that allowed the caller to set the single-player mode difficulty, the difficulty goes from 1 to 5 and
     * indicates the number of tool card given at the start of the game
     * @param difficulty difficulty number
     */
    private void setSinglePlayerDifficulty(int difficulty){
        this.singlePlayerDifficulty = difficulty;
    }



    //------------------- update depeding on the notify of the view-------------------

    /**
     * Override of the method update of the interface Observer. The methods is the responsible of receiving all the
     * the notification from the virtual view (representation of the view in the server), as observer of the view.
     * Depending on the runtime events received from the view,the controller updates its state and then changes the model
     * using the methods that manipulate the application logic
     * @param o the observable virtual view
     * @param arg the object received
     */
    @Override
    public void update(Observable o, Object arg) {

        VirtualView virtualView = (VirtualView) o;

        if (arg instanceof PlayerNameEvent) {
            setPlayerNameModel(virtualView, ((PlayerNameEvent) arg).getName());
        }
        if (arg instanceof ToolNumberEvent) {
            this.setSinglePlayerDifficulty(((ToolNumberEvent) arg).getDifficulty());
            startCard();
        }
        if (arg instanceof PlayerPatternEvent) {
            setPatternCardModel(virtualView, ((PlayerPatternEvent) arg).getIndexPatternChoose());

            for (VirtualView view : viewGame) {
                Player player = model.getPlayerFromID(view.getPlayerID());
                if (player.isDisconnect() && player.getPattern() == null) {
                    setPatternCardModel(view, 0);

                }
            }
        }
        if (arg instanceof PlayerDraftPoolEvent) {
            setDraftPoolModel(virtualView);
        }
        if (arg instanceof PlayerMoveEvent) {

            setMoveModel(virtualView, ((PlayerMoveEvent) arg).getIndexPool(), ((PlayerMoveEvent) arg).getIndexPattern());

        }
        if (arg instanceof PlayerStartToolEvent) {

            nextStepMove(virtualView);
        }
        if (arg instanceof PlayerNextTurnEvent) {

            nextStepTool(virtualView);
        }
        if (arg instanceof ToolCardStartEvent) {

            checkCost(virtualView, ((ToolCardStartEvent) arg).getIndexTool());

        }
        if (arg instanceof ToolCardSinglePlayerStartEvent) {

            checkDice(virtualView, ((ToolCardSinglePlayerStartEvent) arg).getIndexTool(), ((ToolCardSinglePlayerStartEvent) arg).getIndexPool());
        }
        if (arg instanceof PlayerChooseEvent) {


            stepController(virtualView, ((PlayerChooseEvent) arg).getStep());
        }
        if (arg instanceof PlayerNoTokenEvent) {
            startTool(virtualView);
        }

        if (arg instanceof EndGameTimerEvent) {
            endTimer();
        }

        if (arg instanceof CustomPatternEvent) {
            setCustomPatternModel(virtualView, ((CustomPatternEvent) arg).getPatternCard());

        }

        //------------------------disconnection-------------------------------------------------------

        if (arg instanceof ExitEvent) {
            setPlayerDisconnection(((ExitEvent) arg).getPlayerID());
            sendExitNotification(((ExitEvent) arg).getPlayerID());
        }
        if (arg instanceof ReconnectPlayerEvent) {
            setPlayerReconnect(((ReconnectPlayerEvent) arg).getPlayerID());
        }
        if (arg instanceof DisconnectionEvent) {
            handlingDisconnection(((DisconnectionEvent) arg).getID(), virtualView);

        }
        if (arg instanceof ReconnectionEvent) {
            handlingReconnection(virtualView);
        }
    }


    //-------------methods that manipulate the application logic (model)----------------------------------------


    /**
     * method that checks if the name set by player is valid, in affirmative case send the name to the model otherwise
     * it signals the error, if all players set name it starts the pattern card chose
     * @param view the virtual view corresponding to the client that has inserted name
     * @param name the name chosen
     */
    private void setPlayerNameModel(VirtualView view, String name) {

        if (activeNames.contains(name)) {
            view.sendEvent(new PlayerNameErrorEvent(view.getPlayerID()));
        }
        else {
            activeNames.add(name);
            model.setPlayerAndNotify((view.getPlayerID()), name);
        }

        if (singlePlayer){
            setToolSinglePlayer();
        }
        else {
            if (model.getNumberPlayer() == (model.getPlayerList().size() - disconnectName)) {
                startCard();
            }
        }
    }

    /**
     * method that checks if custom pattern card inserted by player is valid, in affirmative case send that to the model
     * if all player chose pattern card it starts the first round
     * @param view the virtual view corresponding to the client that has inserted the custom pattern
     * @param patternCard the custom pattern inserted
     */
    private void setCustomPatternModel(VirtualView view, PatternCard patternCard) {

        model.setCustomPatternAndNotify(view.getPlayerID(), patternCard);

        if(!singlePlayer) {
            log.info("custom pattern setting controller");
            setTokensModel(view);

            if (model.getNumberPlayer() == (getViewGame().size() - disconnectName)) {

                for (VirtualView view1 : viewGame) {
                    view1.sendEvent(new StartGameSceneEvent());
                }

                startTurn();
            }
        }else {
            view.sendEvent(new StartGameSceneEvent());
            singlePlayerTurn();
        }
    }


    /**
     * method that send to the model the pattern card chose by the player,
     * if all player chose pattern card it starts the first round
     * @param view the virtual view corresponding to the client that has chosen the pattern
     * @param indexPatternChoose the index in the list of pattern cards delivered to the player
     */
    private void setPatternCardModel(VirtualView view, int indexPatternChoose){

        model.setPatternAndNotify(view.getPlayerID(), indexPatternChoose);

        if(!singlePlayer) {
            setTokensModel(view);

            if (model.getNumberPlayer() == (getViewGame().size() - disconnectName)) {

                for (VirtualView view1 : viewGame) {
                    view1.sendEvent(new StartGameSceneEvent());
                }

                startTurn();
            }
        }else {
            view.sendEvent(new StartGameSceneEvent());
            singlePlayerTurn();
        }
    }

    /**
     * method that send to the model the current tokens of the player
     * @param view the virtual view corresponding to the client whose tokens has to be modified
     */
    private void setTokensModel(VirtualView view) {
        model.setTokenAndNotify(view.getPlayerID());
    }

    /**
     * method that send to the model that the draft pool has to be rolled
     * @param view the virtual view corresponding to the client that rolls draft pool
     */
    private void setDraftPoolModel(VirtualView view){
        model.setDraftPoolAndNotify(singlePlayer);
        startChoose(view);
    }

    /**
     * method that send to the model that the player has played his move where the index pool corresponds
     * to the index in the draft pool of the dice chosen by player and the index pattern corresponds to the index
     * of the pattern card where the dice has to be inserted, if model notifies the controller of an InvalidMoveException,
     * the method restarts the step else goes to the next step
     * @param view the virtual view corresponding to the client
     * @param indexPattern the index in the draft pool of the dice chosen by player
     * @param indexPool the index pattern corresponds to the index of the pattern card where the dice has to be inserted
     */
    private void setMoveModel(VirtualView view, int indexPool, int indexPattern)  {

        Dice dice = model.getDraftPool().getDraftPool().get(indexPool);
        try {
            model.setMoveAndNotify(view.getPlayerID(), indexPool, indexPattern);
            nextStepMove(view);
        }
        catch (InvalidMoveException e) {
            view.sendEvent(new InvalidMoveEvent(e.getMessage(), view.getPlayerID()));
            model.addDicePool(dice);
            startMove(view);
        }
    }

    /**
     * method that send to the model that the round ended
     */
    private void setEndRoundModel(){
        model.setEndRoundAndNotify();
    }

    /**
     * method that send to the model the final points of each player through a list of player and signals through
     * a boolean if the current points correspond to the end game rank or an interruption before the game has started
     * @param playerList list that contains players sorted in descending order  by points
     * @param finish false if the game endx for an interruption before the game has started
     */
    private void setFinalPointsModel(List<Player> playerList, boolean finish){
        model.setFinalPointsAndNotify(playerList, finish);
    }

    /**
     * method that send to the model that the player, having the indicated ID, disconnected from the game and
     * increase the number of disconnected players by one. If the number of player is minor of 2  it calls the endMatch,
     * else calls the NextTurn
     * @param playerID the ID of the disconnected player
     */
    private void setPlayerDisconnection(int playerID){

        model.getPlayerFromID(playerID).setDisconnect(true);
        disconnectPlayerNumber++;
        if((viewGame.size() - disconnectPlayerNumber) < 2) {
            for(Player player : model.getPlayerList()){

                if(player.getPattern() == null){
                    notEnded = false;
                }
            }
            endMatch(notEnded);
        }
        else if (currID == playerID) {
            nextTurn();
        }
    }

    /**
     * method that send to the model that the player, having the indicated ID, reconnected from the game and
     * decrease the number of disconnected players by one
     * @param playerID he ID of the reconnected player
     */
    private void setPlayerReconnect(int playerID){
        model.getPlayerFromID(playerID).setDisconnect(false);
        disconnectPlayerNumber--;
        sendReconnectNotification(playerID);
    }



    //---------------------------------logica applicativa---------------------------

    /**
     * method that send the started game event from each virtual view
     */
    private void startGame() {
        model.setNumberPlayer(0);
        for (VirtualView view : viewGame) {
            view.sendEvent(new GameStartedEvent(true));
        }
    }

    /**
     * method that send the request of the difficulty of the game from single-player virtual view
     */
    private void setToolSinglePlayer(){
        for (VirtualView view : viewGame) {
            view.sendEvent(new ToolNumberRequestEvent());
        }
    }

    /**
     * method that send to the model the cards of the game from each virtual view
     */
    private void startCard(){
        model.setNumberPlayer(0);
        model.setToolCardList(setup.setToolCard());
        setup.setPublicCardModel();
        for (VirtualView view : viewGame) {
            view.sendEvent(new ToolCardUpdateEvent(model.getToolCardList()));
            setup.setPrivateCardModel(view);
            setup.startPatternCard(view);

        }
    }

    /**
     * method starts the turn of single-player mode, if turn is the last plus one calls the endRound method
     */
    private void singlePlayerTurn(){
        if(turn == DEFAULT){
            viewGame.get(0).sendEvent(new StartRoundEvent(round));
            if(round > START){
                viewGame.get(0).sendEvent(new TurnPatternEvent(viewGame.get(0).getPlayerID(), model.getPlayerFromID(viewGame.get(0).getPlayerID()).getPattern()));
            }
            viewGame.get(0).sendEvent(new RollDraftPoolEvent(viewGame.get(0).getPlayerID()));

        }
        else if(turn == START) {

            viewGame.get(0).sendEvent(new TurnPatternEvent(viewGame.get(0).getPlayerID(), model.getPlayerFromID(viewGame.get(0).getPlayerID()).getPattern()));
            startChoose(viewGame.get(0));
        }
        else {
            endRound();
        }
    }

    /**
     * method starts the turn of multi-player mode, if turn is the last plus one calls the endRound method else
     * calls the startChose method on virtual view of the player that has to play
     */
    private void startTurn(){

        startTimer();

        if(turn == DEFAULT){
            for (VirtualView view : viewGame) {
                int position = calculatePlayerTurn(turn, model.getPlayerList().size());
                this.currID = model.getPlayerList().get(position).getPlayerID();

                if (model.getPlayerFromID(currID).isDisconnect()) {

                    nextTurn();

                }else {

                    view.sendEvent(new StartRoundEvent(round));
                    view.sendEvent(new StartTurnEvent(currID, this.model.getPlayerFromID(this.currID).getPlayerName()));
                    if (round > START) {
                        view.sendEvent(new TurnPatternEvent(currID, model.getPlayerFromID(currID).getPattern()));
                    }
                    view.sendEvent(new RollDraftPoolEvent(currID));

                }
            }
        }
        else if (turn > DEFAULT && turn < (model.getPlayerList().size()*2)){
            for (VirtualView view : viewGame) {

                int position = calculatePlayerTurn(turn, model.getPlayerList().size());
                this.currID = model.getPlayerList().get(position).getPlayerID();

                if(model.getPlayerFromID(currID).isDisconnect()) {

                    nextTurn();
                }else {
                    if (currID == view.getPlayerID() && model.getPlayerFromID(view.getPlayerID()).isRunningP()) {
                        model.getPlayerFromID(view.getPlayerID()).setRunningP(false);
                        nextTurn();
                    } else {
                       if (turn != 0) {
                           view.sendEvent(new StartTurnEvent(this.currID, this.model.getPlayerFromID(this.currID).getPlayerName()));
                           view.sendEvent(new TurnPatternEvent(this.currID, model.getPlayerFromID(currID).getPattern()));
                           if (currID == view.getPlayerID()) {
                               startChoose(view);
                           }
                       }
                    }
                }
            }

        }
        else {
            endRound();
        }
    }

    /**
     * method that calculate the id of the player that has to play in the specified turn using the number of players
     * that are playing the game
     * @param turn current turn
     * @param numberOfPlayers number of players that are playing the game
     */
    private int calculatePlayerTurn(int turn, int numberOfPlayers) {
        if (turn < numberOfPlayers) {
            return turn;
        } else if (turn == numberOfPlayers) {
            return numberOfPlayers - 1;
        } else {
            return (2 * numberOfPlayers) - (turn + 1);
        }
    }

    /**
     * method that increase the turn by one and calls the startTurn method if multi-player mode, else singlePlayerTurn method
     */
    void nextTurn() {
        step = SET;
        turn++;

        if(!singlePlayer) {

            startTurn();
        }else {
            singlePlayerTurn();
        }
    }

    /**
     * method that send the chose, of to use tool card or to do a move, to the player
     * @param view the virtual view corresponding to the client that has to chose
     */
    private void startChoose(VirtualView view){
        view.sendEvent(new StartChooseEvent(view.getPlayerID()));
    }

    /**
     * method that starts the move step
     * @param view the virtual view corresponding to the client that has to do move
     */
    private void startMove(VirtualView view){
        view.sendEvent(new StartMoveEvent(view.getPlayerID(), model.getDraftPool().getNowNumber()));
    }

    /**
     * method that starts the tool card step
     * @param view the virtual view corresponding to the client that has to chose tool card
     */
    void startTool(VirtualView view) {
        if(!singlePlayer){
            view.sendEvent(new StartToolEvent(view.getPlayerID(), model.getToolCardList()));
        }else {
            view.sendEvent( new StartToolSinglePlayerEvent(model.getToolCardList(), model.getDraftPool().getNowNumber()));
        }
    }


    /**
     * method that increase the round by one and calls the endMatch method if the game finish else
     * calls the startTurn method setting the turn to zero
     */
    private void endRound(){

        setEndRoundModel();
        round++;
        if (round > END){
            endMatch(true);
        }else {
            turn = DEFAULT;
            if(!singlePlayer) {
                setup.changeBagger();
                log.info("end round");
                startTurn();
            }else {
                singlePlayerTurn();
            }
        }

    }


    /**
     * method that send to the model that the game was finish
     */
    private void endMatch(boolean finish){

        if(!singlePlayer) {
            if (finish) {
                setFinalPointsModel(pointsManager.calculateWinner(model.getPlayerList(), model.getPublicList()), true);
                for (VirtualView view : viewGame) {
                    view.sendEvent(new WinnerEvent(model.getPlayerList().get(0).getPlayerID()));
                }
            }
            else {
                setFinalPointsModel(null, false);
            }
        }
        else {

            int roundTrackerPoints = pointsManager.calculateWinnerSinglePlayer(model.getPlayerList().get(0), model.getPublicList(), model.getPlayerList().get(0).getPrivateSinglePlayerCard(), model.getRoundTracker());
            int playerPoints = model.getPlayerList().get(0).getFinalPoints();
            if(playerPoints > roundTrackerPoints){
                viewGame.get(0).sendEvent(new EndSinglePlayerEvent(true, playerPoints, roundTrackerPoints));
            }else {
                viewGame.get(0).sendEvent(new EndSinglePlayerEvent(false, playerPoints, roundTrackerPoints));
            }
        }

    }

    /**
     * method use only in multi-player mode that checks if the tokens of the player are enough to use the selected tool card
     * @param view the virtual view corresponding to the client that has chosen to use tool card
     * @param indexTool the chosen tool card
     */
    private void checkCost(VirtualView view, int indexTool) {

        if (model.checkCostModel(view.getPlayerID(), indexTool)) {
            view.sendEvent(new OutOfTokenEvent(view.getPlayerID()));
            startTool(view);
        }
        else {
            toolController.toolCardEffectRequest(model.getToolCardList().get(indexTool).getNumber(), view);
            model.setUsageToolCard(view.getPlayerID(), indexTool);
        }
    }

    /**
     * method that manage the step on the turn using nextStepTool method and nextStepMove method
     * @param view the virtual view corresponding to the client that have to do next step
     * @param step current step
     */
    private void stepController(VirtualView view, int step){

        if(step == DEFAULT){
            this.step = step;
            startMove(view);

        }else{
            this.step = step;
            startTool(view);
        }
    }

    /**
     * method that manage the next step of turn after a tool card step
     * @param view the virtual view corresponding to the client that have to do next step
     */
    void nextStepTool(VirtualView view){

        if(step == START){
            startMove(view);
            step++;
        }
        else {
            nextTurn();
        }
    }

    /**
     * method that manage the next step of turn after a move
     * @param view the virtual view corresponding to the client that have to do next step
     */
    private void nextStepMove(VirtualView view){

        if(step == DEFAULT){
            startTool(view);
        }
        else {
            nextTurn();
        }
    }

    /**
     * method used only in single-player mode that checks if the dice selected by the player is of the same color
     * of the selected tool card using model
     * @param view the virtual view corresponding to the client that has chosen to use tool card
     * @param indexTool the chosen tool card
     * @param indexPool the index of the draft pool corresponding to the selected dice
     */
    private void checkDice(VirtualView view, int indexTool, int indexPool){

        if (model.checkDiceModel(indexPool, indexTool)) {
            model.removeToolSingle(indexPool, indexTool);
            toolController.toolCardEffectRequest(model.getToolRemoveSinglePlayer().getNumber(), view);
        }
        else {
            view.sendEvent(new NotMatchColorEvent());
            startTool(view);
        }
    }

    /**
     * method that manage the disconnection of the client on the basis of the current game moment, handle also the case of the
     * player doesn't set name or doesn't chose pattern card or both
     * @param virtualView the virtual view corresponds to the disconnected client
     * @param id the id corresponds to the disconnect player
     */
    private void handlingDisconnection(int id, VirtualView virtualView) {

        log.info("disconnection in controller");

        if (model.getPlayerFromID(id).getPlayerName() == null) {
            setPlayerNameModel(virtualView, "default name");
            setPlayerDisconnection(id);
            sendExitNotification(id);

        }
        else if (model.getPlayerFromID(id).getPattern() == null) {
            if(model.getPlayerFromID(id).getPatterChooseList() == null) {
                model.setNumberPlayer(model.getNumberPlayer() - 2);
                disconnectName++;
                model.getPlayerFromID(id).setPatterChooseList(setup.loadPatternCard());
            }
            setPatternCardModel(virtualView, 0);
            setPlayerDisconnection(id);
            sendExitNotification(id);
        }
        else if ((currID == id) && (model.getDraftPool().getNowNumber() == 0)) {
            setDraftPoolModel(virtualView);
            setPlayerDisconnection(id);
            sendExitNotification(id);

        }
        else {
            setPlayerDisconnection(id);
            sendExitNotification(id);

        }

    }

    /**
     * method that manage the reconnection of the client linking the new virtual view with that one previously disconnected
     * @param view the virtual view corresponding to the reconnected client
     */
    private void handlingReconnection(VirtualView view) {

        log.info("reconnection in progress");
        VirtualView viewRemove = null;
        Player reconnectPlayer = null;
        for(Player player : model.getPlayerList()) {

            if(player.isDisconnect()) {
                for (VirtualView virtualView : viewGame) {
                    if (virtualView.getPlayerID() == player.getPlayerID()) {
                        reconnectPlayer = player;
                        viewRemove = virtualView;
                    }
                }
                viewGame.remove(viewRemove);
                view.setPlayerID(player.getPlayerID());
                view.sendEvent(new PlayerIDEvent(player.getPlayerID()));
                view.addObserver(this);
                view.addObserver(toolController);
                view.setModel(model);
                this.model.addObserver(view);
                viewGame.add(view);
                break;
            }
        }
        if(view.getModel() != getModel()){
            view.sendEvent(new NotPlayerDisconnectedEvent());
        }else{
            setPlayerReconnect(view.getPlayerID());
            view.sendEvent(new SuccessfulReconnectionEvent(reconnectPlayer, singlePlayer, true, model.getToolCardList(), model.getPublicList(), model.getPlayerList()));
        }


    }

    /**
     * method that send to the model the id of the player that  has decided to exit from the game
     * @param iD iD of the player that  has decided to exit from the game
     */
    private void sendExitNotification(int iD) {
        for (VirtualView view : viewGame) {
            if(notEnded) {
                view.sendEvent(new DisconnectionMsgEvent(iD, model.getPlayerFromID(iD).getPlayerName()));
            }
        }
    }

    /**
     * method that send to the model the id of the player that  has decided to reconnect to the game
     * after to be exited
     * @param iD iD of the player that  has decided reconnect to the game
     */
    private void sendReconnectNotification(int iD) {
        for (VirtualView view : viewGame) {
            view.sendEvent(new ReconnectionMsgEvent(iD, model.getPlayerFromID(iD).getPlayerName()));
        }

    }


    /**
     * method responsible of starting the timer of the player's turn and let the player TIMERTURN seconds to do
     * the move, after that switch to the next turn ignoring the current player
      */
    protected void startTimer() {

        if (timer != null) {
            timer.cancel();
        }

        timer = new Timer();
        timer.schedule(new TimerTask()
        {
            @Override
            public void run() {

                for (VirtualView view : viewGame) {
                    if (view.getPlayerID() == getCurrID()) {
                        view.sendEvent(new TimerEndedEvent(getCurrID()));
                    }
                    else {
                        view.sendEvent(new TimerOtherEvent(model.getPlayerFromID(currID).getPlayerName()));
                    }
                }
                nextTurn();
            }

        }, TIMERTURN);
    }

    /**
     * method that stop the timer if there's one currently running
     */
    private void endTimer() {
        if (timer != null) {
            timer.cancel();
        }
    }




}