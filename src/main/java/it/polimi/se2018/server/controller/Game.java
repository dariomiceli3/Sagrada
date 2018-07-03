package it.polimi.se2018.server.controller;


import it.polimi.se2018.exceptions.InvalidMoveException;
import it.polimi.se2018.server.network.VirtualView;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Components.Dice;
import it.polimi.se2018.server.model.Components.Model;
import it.polimi.se2018.server.model.Components.Player;
import it.polimi.se2018.events.ClientServer.*;
import it.polimi.se2018.events.InvalidMoveEvent;
import it.polimi.se2018.events.ServerClient.ControllerView.*;
import it.polimi.se2018.events.ServerClient.ModelView.PlayerIDEvent;
import it.polimi.se2018.events.SinglePlayer.*;

import java.util.*;

public class Game implements Observer {

    private static final int DEFAULT = 0;
    private static final int START = 1;
    private static final int END = 10;
    private static final int SET = 2;
    private Model model;
    private List<ToolCard> toolCardList;
    private List<VirtualView> viewGame;
    private GameSetup setup;
    private RoundManager roundManager;
    private int turn = DEFAULT;
    private int round = START;
    private int currID;
    private boolean notEnded;
    private Dice diceToolSinglePlayer;
    private ToolCard toolRemoveSinglePlayer;
    private int singlePlayerDifficulty;
    private int step;
    private int disconnectPlayerNumber;
    private List<String> activeNames;
    private boolean singlePlayer;
    private int timePlayer;
    private Timer timer;
    private ToolCardController toolController;


    public Game(List<VirtualView> viewList, boolean singlePlayer) {
        Model modelGame = new Model();
        createGame(viewList, singlePlayer, modelGame);
    }

    public Game(List<VirtualView> viewList, boolean singlePlayer, Model model) {
        createGame(viewList, singlePlayer, model);
    }

    private void createGame(List<VirtualView> viewList, boolean singlePlayer, Model model) {

        this.model = model;
        this.viewGame = new ArrayList<>(viewList);
        this.setup = new GameSetup(this);
        this.roundManager = new RoundManager();
        this.timePlayer = model.getTimeToPlay();
        this.toolController = new ToolCardController(this);
        this.singlePlayer = singlePlayer;
        this.disconnectPlayerNumber = DEFAULT;
        this.activeNames = new ArrayList<>();
        this.currID = -1;
        this.notEnded = true;

        List<Player> playerList = new ArrayList<>();

        for (VirtualView view: viewGame) {
            Player player = new Player(view.getPlayerID());
            System.out.println("Player id in new Game" + player.getPlayerID());
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


    // ogni metodo che modifica il model deve essere gestito da update (unico metodo pubblico), e chiamare il metodo
    // protected relativo al cambiamento
    // update gestisce

    List<ToolCard> getToolCardList(){
        return toolCardList;
    }

    protected Model getModel(){
        return model;
    }

    List<VirtualView> getViewGame(){
        return viewGame;
    }

    int getTurn(){
        return turn;
    }

    int getStep(){
        return step;
    }

    protected void setStep(int step){
        this.step = step;
    }

    protected boolean isSinglePlayer(){
        return singlePlayer;
    }

    int getSinglePlayerDifficulty(){
        return singlePlayerDifficulty;
    }

    private void setSinglePlayerDifficulty(int difficulty){
        this.singlePlayerDifficulty = difficulty;
    }

    Dice getDiceToolSinglePlayer(){
        return diceToolSinglePlayer;
    }

    ToolCard getToolRemoveSinglePlayer(){
        return toolRemoveSinglePlayer;
    }


    private int getCurrID() {
        return currID;
    }





    //------------------- update in base alla notify della view-------------------
    @Override
    public void update(Observable o, Object arg){

        VirtualView virtualView = (VirtualView) o;

        if (arg instanceof PlayerNameEvent) {

            setPlayerNameModel(virtualView, ((PlayerNameEvent) arg).getName());
        }

        if (arg instanceof ToolNumberEvent){
            this.setSinglePlayerDifficulty(((ToolNumberEvent)arg).getDifficulty());
            startCard();
        }

        if (arg instanceof PlayerPatternEvent){
            setPatternCardModel(virtualView, ((PlayerPatternEvent) arg).getIndexPatternChoose());

            for (VirtualView view : viewGame){
                Player player = model.getPlayerFromID(view.getPlayerID());
                if (player.isDisconnect() && player.getPattern() == null) {
                    setPatternCardModel(view, 0);

                }
            }
        }

        if (arg instanceof PlayerDraftPoolEvent){
            setDraftPoolModel(virtualView);
        }
        if (arg instanceof PlayerMoveEvent) {

            setMoveModel(virtualView, ((PlayerMoveEvent) arg).getIndexPool(), ((PlayerMoveEvent) arg).getIndexPattern());

        }
        if (arg instanceof PlayerStartToolEvent){

            nextStepMove(virtualView);
        }

        if (arg instanceof PlayerNextTurnEvent) {

            nextStepTool(virtualView);
        }
        if (arg instanceof ToolCardStartEvent){

            checkCost(virtualView, ((ToolCardStartEvent) arg).getIndexTool());

        }
        if (arg instanceof ToolCardSinglePlayerStartEvent){

            checkDice(virtualView, ((ToolCardSinglePlayerStartEvent)arg).getIndexTool(), ((ToolCardSinglePlayerStartEvent)arg).getIndexPool());
        }
        if (arg instanceof PlayerChooseEvent){


            stepController(virtualView, ((PlayerChooseEvent)arg).getStep());
        }
        if (arg instanceof PlayerNoTokenEvent){
            startTool(virtualView);
        }

        if (arg instanceof EndGameTimerEvent) {
            endTimer();
        }

        if (arg instanceof CustomPatternEvent) {
            setCustomPatternModel(virtualView, ((CustomPatternEvent)arg).getPatternCard());

        }

        //------------------------disconnection-------------------------------------------------------

        if (arg instanceof ExitEvent) {
            setPlayerDisconnection(((ExitEvent) arg).getPlayerID());
            sendExitNotification( ((ExitEvent) arg).getPlayerID());
        }

        if (arg instanceof ReconnectPlayerEvent){
            setPlayerReconnect(((ReconnectPlayerEvent) arg).getPlayerID());
        }

        if (arg instanceof DisconnectionEvent) {
            handlingDisconnection( ((DisconnectionEvent)arg).getID(), virtualView);

        }
        if (arg instanceof ReconnectionEvent) {
            // arriva la riconnessione
            // se c'è un player libero lo assegni
            // altrimenti mi mandi evento in cui dici che non c'è nessuno libero
            handlingReconnection(virtualView);
        }


    }

    private void handlingDisconnection(int id, VirtualView virtualView) {

        if (model.getPlayerFromID(id).getPlayerName() == null) {
            setPlayerNameModel(virtualView, "default name");
            setPlayerDisconnection(id);
            sendExitNotification(id);

        }
        else if (model.getPlayerFromID(id).getPattern() == null) {
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

    private void handlingReconnection(VirtualView view) {

        System.out.println("tentata riconnessione");
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
            view.sendEvent(new SuccessfulReconnectionEvent(reconnectPlayer, singlePlayer, true, toolCardList, model.getPublicList(), model.getPlayerList()));
        }


    }
















    //--------metodi che modificano model e mandano la notify alla view----------
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
        }else {
            if (model.getNumberPlayer() == (model.getPlayerList().size())) {
                startCard();
            }
        }
    }

    private void setCustomPatternModel(VirtualView view, PatternCard patternCard) {

        model.setCustomPatternAndNotify(view.getPlayerID(), patternCard);

        if(!singlePlayer) {
            System.out.println("custom pattern setting controller");
            setTokensModel(view);

            if (model.getNumberPlayer() == (getViewGame().size())) {

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


    private void setPatternCardModel(VirtualView view, int indexPatternChoose){

        model.setPatternAndNotify(view.getPlayerID(), indexPatternChoose);

        if(!singlePlayer) {
            setTokensModel(view);

            if (model.getNumberPlayer() == (getViewGame().size())) {

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

    private void setTokensModel(VirtualView view) {

        model.setTokenAndNotify(view.getPlayerID());


    }

    private void setDraftPoolModel(VirtualView view){


        model.setDraftPoolAndNotify(singlePlayer);
        startChoose(view);

    }

    private void setMoveModel(VirtualView view, int indexPool, int indexPattern)  {

        Dice dice = model.getDraftPool().getDraftPool().get(indexPool);

        try {
            model.setMoveAndNotify(view.getPlayerID(), indexPool, indexPattern);
            nextStepMove(view);
        }
        catch (InvalidMoveException e) {
            view.sendEvent(new InvalidMoveEvent(e.getMessage(), view.getPlayerID()));
            model.getDraftPool().getDraftPool().add(dice);
            model.updatePoolAndNotify();
            startMove(view);
        }
    }

    private void setEndRoundModel(){

        model.setEndRoundAndNotify();
    }

    private void setFinalPointsModel(List<Player> playerList, boolean finish){

        model.setFinalPointsAndNotify(playerList, finish);

    }

    private void setPlayerDisconnection(int playerID){

        model.getPlayerFromID(playerID).setDisconnect(true);
        disconnectPlayerNumber++;
        if((viewGame.size() - disconnectPlayerNumber) < 2){
            if(model.getPlayerFromID(playerID).getPrivate() == null){
                notEnded = false;
                endMatch(false);
            }
            else {
                endMatch(true);
            }
        }else if (currID == playerID) {
            nextTurn();
        }
        else {
        }
    }

    private void setPlayerReconnect(int playerID){

        model.getPlayerFromID(playerID).setDisconnect(false);
        disconnectPlayerNumber--;
        sendReconnectNotification(playerID);

    }



    //---------------------------------logica applicativa---------------------------

    private void startGame() {

        model.setNumberPlayer(0);
        for (VirtualView view : viewGame) {
            view.sendEvent(new GameStartedEvent(true));
        }

    }

    private void setToolSinglePlayer(){
        for (VirtualView view : viewGame) {
            view.sendEvent(new ToolNumberRequestEvent());
        }
    }

    private void startCard(){

        model.setNumberPlayer(0);
        this.toolCardList = setup.setToolCard();
        setup.setPublicCardModel();
        for (VirtualView view : viewGame) {
            view.sendEvent(new ToolCardUpdateEvent(getToolCardList()));
            setup.setPrivateCardModel(view);
            setup.startPatternCard(view);

        }
    }


    private void singlePlayerTurn(){
        if(turn == DEFAULT){
            viewGame.get(0).sendEvent(new StartRoundEvent(round));
            if(round > START){
                viewGame.get(0).sendEvent(new TurnPatternEvent(viewGame.get(0).getPlayerID(), model.getPlayerFromID(viewGame.get(0).getPlayerID()).getPattern()));
            }
            viewGame.get(0).sendEvent(new RollDraftPoolEvent(viewGame.get(0).getPlayerID()));



        }else if(turn == START) {

            viewGame.get(0).sendEvent(new TurnPatternEvent(viewGame.get(0).getPlayerID(), model.getPlayerFromID(viewGame.get(0).getPlayerID()).getPattern()));
            startChoose(viewGame.get(0));
        }else {
            endRound();
        }
    }

    private void startTurn(){

        //startTimer();

        if(turn == DEFAULT){
            for (VirtualView view : viewGame) {
                int position = calculatePlayerTurn(turn, model.getPlayerList().size());
                this.currID = model.getPlayerList().get(position).getPlayerID();
                System.out.println(currID);
                if (model.getPlayerFromID(currID).isDisconnect()) {

                    //setDraftPoolModel(view);
                    nextTurn();

                }else {

                    view.sendEvent(new StartRoundEvent(round));
                    view.sendEvent(new StartTurnEvent(currID, this.model.getPlayerFromID(this.currID).getPlayerName()));
                    if (round > START) {
                        view.sendEvent(new TurnPatternEvent(currID, model.getPlayerFromID(currID).getPattern()));
                    }
                    view.sendEvent(new RollDraftPoolEvent(currID));
                    System.out.println("roll");

                }


            }


        }
        else if (turn > DEFAULT && turn < (model.getPlayerList().size()*2)){
            for (VirtualView view : viewGame) {

                int position = calculatePlayerTurn(turn, model.getPlayerList().size());
                this.currID = model.getPlayerList().get(position).getPlayerID();
                System.out.println(currID);
                if(model.getPlayerFromID(currID).isDisconnect()) {

                    nextTurn();
                }else {
                    if (currID == view.getPlayerID() && model.getPlayerFromID(view.getPlayerID()).isRunningP()) {
                        model.getPlayerFromID(view.getPlayerID()).setRunningP(false);
                        nextTurn();
                    } else {
                       if (turn != 0) {
                            System.out.println("turno strano " + turn);
                            view.sendEvent(new StartTurnEvent(this.currID, this.model.getPlayerFromID(this.currID).getPlayerName()));
                            view.sendEvent(new TurnPatternEvent(this.currID, model.getPlayerFromID(currID).getPattern()));
                            if (currID == view.getPlayerID()) {
                                startChoose(view);
                                System.out.println(turn);
                                System.out.println("startChoose");

                            }
                       }
                    }
                }

            }

        }else {

            endRound();
        }


    }

    private int calculatePlayerTurn(int turn, int numberOfPlayers) {
        if (turn < numberOfPlayers) {
            return turn;
        } else if (turn == numberOfPlayers) {
            return numberOfPlayers - 1;
        } else {
            return (2 * numberOfPlayers) - (turn + 1);
        }
    }

    private void startChoose(VirtualView view){

        view.sendEvent(new StartChooseEvent(view.getPlayerID()));
    }

    private void startMove(VirtualView view){

        view.sendEvent(new StartMoveEvent(view.getPlayerID(), model.getDraftPool().getNowNumber()));


    }

    void startTool(VirtualView view) {

        if(!singlePlayer){
            view.sendEvent(new StartToolEvent(view.getPlayerID(), toolCardList));
        }else {
            view.sendEvent( new StartToolSinglePlayerEvent(toolCardList, model.getDraftPool().getNowNumber()));
        }


    }



    //fa turn = 0, round++, e se round >10, allora
    //chiama endMatch; gestisce inoltre tutti gli eventi della fine del round
    private void endRound(){

        setEndRoundModel();
        round++;
        if (round > END){
            endMatch(true);
        }else {
            turn = DEFAULT;
            if(!singlePlayer) {
                setup.changeBagger();
                System.out.println("endround" + turn);
                startTurn();
            }else {
                singlePlayerTurn();
            }
        }

    }

    private void endMatch(boolean finish){

        if(!singlePlayer) {
            if (finish) {
                setFinalPointsModel(roundManager.calculateWinner(model.getPlayerList(), model.getPublicList()), true);
                for (VirtualView view : viewGame) {
                    view.sendEvent(new WinnerEvent(model.getPlayerList().get(0).getPlayerID()));
                }
            }
            else {
                setFinalPointsModel(null, false);
            }
        }
        else {

            int roundTrackerPoints = roundManager.calculateWinnerSinglePlayer(model.getPlayerList().get(0), model.getPublicList(), model.getPlayerList().get(0).getPrivateSinglePlayerCard(), model.getRoundTracker());
            int playerPoints = model.getPlayerList().get(0).getFinalPoints();
            if(playerPoints > roundTrackerPoints){
                viewGame.get(0).sendEvent(new EndSinglePlayerEvent(true, playerPoints, roundTrackerPoints));
            }else {
                viewGame.get(0).sendEvent(new EndSinglePlayerEvent(false, playerPoints, roundTrackerPoints));
            }


        }

    }

    void nextTurn() {
        step = SET;
        turn++;
        System.out.println("turn++");
        if(!singlePlayer) {
            System.out.println(turn);
            startTurn();
        }else {
            singlePlayerTurn();
        }
    }

    private void checkCost(VirtualView view, int indexTool){
        if(model.getPlayerFromID(view.getPlayerID()).getTokensNumber() < toolCardList.get(indexTool).getCost()){

            view.sendEvent(new OutOfTokenEvent(view.getPlayerID()));
            startTool(view);

        }else {


            toolCardList.get(indexTool).incrementUsage();
            toolController.toolCardEffectRequest(toolCardList.get(indexTool).getNumber(), view);
            int n = model.getPlayerFromID(view.getPlayerID()).getTokensNumber();
            model.getPlayerFromID(view.getPlayerID()).setTokensNumber(n - toolCardList.get(indexTool).getCost());
            if (toolCardList.get(indexTool).getCost() == START) {

                toolCardList.get(indexTool).setCost(SET);
            }

        }
    }

    private void stepController(VirtualView view, int step){

        if(step == DEFAULT){
            this.step = step;
            startMove(view);

        }else{

            this.step = step;
            startTool(view);
        }
    }

    void nextStepTool(VirtualView view){

        if(step == START){

            startMove(view);
            step++;
        }
        else {
            nextTurn();
        }

    }

    private void nextStepMove(VirtualView view){

        if(step == DEFAULT){

            startTool(view);

        }
        else {
            nextTurn();
        }
    }

    ToolCard getTool(int n) {

        for (ToolCard toolCard : toolCardList ) {
            if (toolCard.getNumber() == n) {
                return toolCard;
            }
        }
        return null;
    }

    private void checkDice(VirtualView view, int indexTool, int indexPool){

        if(model.getDraftPool().getDraftPool().get(indexPool).getColor().toString().equals(toolCardList.get(indexTool).getColor().toString())){

            diceToolSinglePlayer = model.getDraftPool().removeDice(indexPool);
            model.updatePoolAndNotify();
            toolRemoveSinglePlayer = toolCardList.remove(indexTool);
            toolController.toolCardEffectRequest(toolRemoveSinglePlayer.getNumber(), view);



        }else {
            view.sendEvent(new NotMatchColorEvent());
            startTool(view);
        }
    }

    private void sendExitNotification(int iD) {
        for (VirtualView view : viewGame) {
            if(notEnded) {
                view.sendEvent(new DisconnectionMsgEvent(iD, model.getPlayerFromID(iD).getPlayerName()));
            }
        }
    }

    private void sendReconnectNotification(int iD) {
        for (VirtualView view : viewGame) {
            view.sendEvent(new ReconnectionMsgEvent(iD, model.getPlayerFromID(iD).getPlayerName()));
        }

    }


    private void endTimer() {
        if (timer != null) {
            timer.cancel();
        }
    }

    protected void startTimer() {

        if (timer != null) {
            timer.cancel();
        }

        timer = new Timer();
        timer.schedule(new TimerTask()
        {
            @Override
            public void run() {
                //viewGame.get(getCurrID()).sendEvent(new TimerEndedEvent(getCurrID()));

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

        }, (long) 3 * 1000);
    }




}