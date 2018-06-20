package it.polimi.se2018.server.controller;


import it.polimi.se2018.client.view.View;
import it.polimi.se2018.exceptions.InvalidMoveException;
import it.polimi.se2018.server.VirtualView;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Components.Dice;
import it.polimi.se2018.server.model.Components.DiceColor;
import it.polimi.se2018.server.model.Components.Model;
import it.polimi.se2018.server.model.Components.Player;
import it.polimi.se2018.server.model.Events.ClientServer.*;
import it.polimi.se2018.server.model.Events.InvalidMoveEvent;
import it.polimi.se2018.server.model.Events.ServerClient.ControllerView.*;
import it.polimi.se2018.server.model.Events.SinglePlayer.*;

import java.util.*;

public class Game implements Observer {

    private static final int DEFAULT = 0;
    private static final int START = 1;
    private static final int END = 10;
    private static final int SET = 2;
    private Model model;
    private List<Player> playerList;
    private List<ToolCard> toolCardList;
    private List<VirtualView> viewGame;
    private GameSetup setup;
    private RoundManager roundManager;
    private static int turn = DEFAULT;
    private int round = START;
    private int position;
    private int currID;
    private Dice diceToolSinglePlayer;
    private ToolCard toolRemoveSinglePlayer;
    private int singlePlayerDifficulty;
    private int step;
    private int disconnectPlayerNumber;
    private List<String> activeNames;
    private boolean singlePlayer;
    private final int timePlayer;
    private Timer timer;
    private ToolCardController toolController;


    public Game(List<VirtualView> viewList, boolean singlePlayer) {

        this.model = new Model();
        this.viewGame = new ArrayList<>(viewList);
        this.playerList = new ArrayList<>();
        this.setup = new GameSetup(this);
        this.roundManager = new RoundManager();
        this.timePlayer = model.getTimeToPlay();
        this.toolController = new ToolCardController(this);
        this.singlePlayer = singlePlayer;
        this.disconnectPlayerNumber = DEFAULT;
        this.activeNames = new ArrayList<>();



        for (VirtualView view: viewGame) {
            Player player = new Player(view.getPlayerID());
            System.out.println("Player id in new Game" + player.getPlayerID());
            playerList.add(player);
        }

        model.setPlayerList(playerList);

        for (VirtualView view : viewGame) {
            view.addObserver(this);
            view.addObserver(toolController);
            view.setModel(model);
            model.addObserver(view);
        }


        startGame();





    }


    // ogni metodo che modifica il model deve essere gestito da update (unico metodo pubblico), e chiamare il metodo
    // protected relativo al cambiamento
    // update gestisce

    protected List<ToolCard> getToolCardList(){

        return toolCardList;
    }

    protected Model getModel(){
        return model;
    }

    protected List<VirtualView> getViewGame(){
        return viewGame;
    }

    protected int getTurn(){
        return turn;
    }

    protected int getStep(){
        return step;
    }

    protected void setStep(int step){
        this.step = step;
    }

    protected boolean isSinglePlayer(){
        return singlePlayer;
    }

    protected int getSinglePlayerDifficulty(){
        return singlePlayerDifficulty;
    }

    private void setSinglePlayerDifficulty(int difficulty){
        this.singlePlayerDifficulty = difficulty;
    }

    protected Dice getDiceToolSinglePlayer(){
        return diceToolSinglePlayer;
    }

    protected ToolCard getToolRemoveSinglePlayer(){
        return toolRemoveSinglePlayer;
    }


    protected int getCurrID() {
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
       /* if(arg instanceof DisconnectPlayerEvent){
            model.getPlayerFromID(getCurrID()).setOff(true);
            disconnectPlayerNumber++;
            if((viewGame.size() - disconnectPlayerNumber) < 2){
                endMatch();
            }
        }
        if (arg instanceof ReconnectPlayerEvent){

        }*/


    }
















    //--------metodi che modificano model e mandano la notify alla view----------
    protected void setPlayerNameModel(VirtualView view, String name) {

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
            if (model.getNumberPlayer() == (viewGame.size() - disconnectPlayerNumber)) {
                startCard();
            }
        }
    }

    protected void setPatternCardModel(VirtualView view, int indexPatternChoose){

        model.setPatternAndNotify(view.getPlayerID(), indexPatternChoose);

        if(!singlePlayer) {
            setTokensModel(view);

            if (model.getNumberPlayer() == (getViewGame().size() - disconnectPlayerNumber)) {

                for (VirtualView view1 : viewGame) {
                    view1.sendEvent(new StartGameSceneEvent());
                }

                startTurn();
            }
        }else {
            singlePlayerTurn();
        }

    }

    protected void setTokensModel(VirtualView view) {

        model.setTokenAndNotify(view.getPlayerID());


    }

    protected void setDraftPoolModel(VirtualView view){


        model.setDraftPoolAndNotify(singlePlayer);
        startChoose(view);

    }

    protected void setMoveModel(VirtualView view, int indexPool, int indexPattern)  {

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

    protected void setEndRoundModel(){

        model.setEndRoundAndNotify();
    }

    protected void setFinalPointsModel(List<Player> playerList){

        model.setFinalPointsAndNotify(playerList);

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

    //todo gestire l'utilizzo delle toolcard in singleplayer
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

        startTimer();

        if(turn == DEFAULT){
            for (VirtualView view : viewGame) {
                this.position = calculatePlayerTurn(turn, viewGame.size());
                this.currID = model.getPlayerList().get(position).getPlayerID();
                if (!model.getPlayerFromID(currID).isOff()) {
                    view.sendEvent(new StartRoundEvent(round));
                    view.sendEvent(new StartTurnEvent(currID, this.model.getPlayerFromID(this.currID).getPlayerName()));
                    if (round > START) {
                        view.sendEvent(new TurnPatternEvent(currID, model.getPlayerFromID(currID).getPattern()));
                    }
                    view.sendEvent(new RollDraftPoolEvent(currID));

                }else {
                    nextTurn();
                }
            }

        }
        else if (turn > DEFAULT && turn < (viewGame.size()*2)){
            for (VirtualView view : viewGame) {

                this.position = calculatePlayerTurn(turn, viewGame.size());
                this.currID = model.getPlayerList().get(position).getPlayerID();
                if(!model.getPlayerFromID(currID).isOff()) {
                    if (currID == view.getPlayerID() && model.getPlayerFromID(view.getPlayerID()).isRunningP()) {
                        model.getPlayerFromID(view.getPlayerID()).setRunningP(false);
                        nextTurn();
                    } else {
                        view.sendEvent(new StartTurnEvent(this.currID, this.model.getPlayerFromID(this.currID).getPlayerName()));
                        view.sendEvent(new TurnPatternEvent(this.currID, model.getPlayerFromID(currID).getPattern()));
                        if (currID == view.getPlayerID()) {
                            startChoose(view);
                        }
                    }
                }
            }
        }else {

            endRound();
        }



    }

    protected int calculatePlayerTurn(int turn, int numberOfPlayers) {
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

    protected void startMove(VirtualView view){

        view.sendEvent(new StartMoveEvent(view.getPlayerID(), model.getDraftPool().getNowNumber()));


    }

    protected void startTool(VirtualView view) {

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
            endMatch();
        }else {
            turn = DEFAULT;
            if(!singlePlayer) {
                setup.changeBagger();
                startTurn();
            }else {
                singlePlayerTurn();
            }
        }

    }

    private void endMatch(){

        if(!singlePlayer) {
            setFinalPointsModel(roundManager.calculateWinner(model.getPlayerList(), model.getPublicList()));
            for (VirtualView view : viewGame){
                if(!model.getPlayerFromID(view.getPlayerID()).isOff()){
                    view.sendEvent(new WinnerEvent(model.getPlayerList().get(0).getPlayerID()));
                }
            }
        }else {

            int roundTrackerPoints = roundManager.calculateWinnerSinglePlayer(model.getPlayerList().get(0), model.getPublicList(), model.getPlayerList().get(0).getPrivateSinglePlayerCard(), model.getRoundTracker());
            int playerPoints = model.getPlayerList().get(0).getFinalPoints();
            if(playerPoints > roundTrackerPoints){
                viewGame.get(0).sendEvent(new EndSinglePlayerEvent(true, playerPoints, roundTrackerPoints));
            }else {
                viewGame.get(0).sendEvent(new EndSinglePlayerEvent(false, playerPoints, roundTrackerPoints));
            }


        }

    }

    protected void nextTurn() {
        step = SET;
        turn++;
        if(!singlePlayer) {
            startTurn();
        }else {
            singlePlayerTurn();
        }
    }

    protected void checkCost(VirtualView view, int indexTool){
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

    protected void stepController(VirtualView view, int step){

        if(step == DEFAULT){
            this.step = step;
            startMove(view);

        }else{

            this.step = step;
            startTool(view);
        }
    }

    protected void nextStepTool(VirtualView view){

        if(step == START){

            startMove(view);
            step++;
        }
        else {
            nextTurn();
        }

    }

    protected void nextStepMove(VirtualView view){

        if(step == DEFAULT){

            startTool(view);

        }
        else {
            nextTurn();
        }
    }

    protected ToolCard getTool(int n) {

        for (ToolCard toolCard : toolCardList ) {
            if (toolCard.getNumber() == n) {
                return toolCard;
            }
        }
        return null;
    }

    protected void checkDice(VirtualView view, int indexTool, int indexPool){

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


    protected void endTimer() {
        timer.cancel();
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