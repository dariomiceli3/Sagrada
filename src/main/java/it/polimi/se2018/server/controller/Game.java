package it.polimi.se2018.server.controller;


import it.polimi.se2018.exceptions.InvalidMoveException;
import it.polimi.se2018.server.VirtualView;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Components.Model;
import it.polimi.se2018.server.model.Components.Player;
import it.polimi.se2018.server.model.Events.ClientServer.*;
import it.polimi.se2018.server.model.Events.ServerClient.ControllerView.*;

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
    private int step;
    private final int timePlayer;
    private Timer timer;
    private ToolCardController toolController;

    public Game(List<VirtualView> viewList) {

        this.model = new Model();
        this.viewGame = new ArrayList<>(viewList);
        this.playerList = new ArrayList<>();
        this.setup = new GameSetup(this);
        this.roundManager = new RoundManager();
        this.timePlayer = model.getTimeToPlay();
        this.toolController = new ToolCardController(this);
        this.toolCardList = setup.setToolCard();

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







    //------------------- update in base alla notify della view-------------------
    @Override
    public void update(Observable o, Object arg){

        VirtualView virtualView = (VirtualView) o;

        if (arg instanceof PlayerNameEvent) {
            setPlayerNameModel(virtualView, ((PlayerNameEvent) arg).getName());
        }

        if (arg instanceof PlayerPatternEvent){

            setPatternCardModel(virtualView, ((PlayerPatternEvent) arg).getCard());
        }

        if (arg instanceof PlayerDraftPoolEvent){

            setDraftPoolModel(virtualView);
        }
        if (arg instanceof PlayerMoveEvent) {

            try {

                setMoveModel(virtualView, ((PlayerMoveEvent) arg).getIndexPool(), ((PlayerMoveEvent) arg).getIndexPattern());
            }
            catch (InvalidMoveException e) {
                startMove(virtualView);
            }
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
        if (arg instanceof PlayerChooseEvent){

            stepController(virtualView, ((PlayerChooseEvent)arg).getStep());
        }



    }
















    //--------metodi che modificano model e mandano la notify alla view----------
    protected void setPlayerNameModel(VirtualView view, String name) {

        model.setPlayerAndNotify((view.getPlayerID()), name);

        if(model.getNumberPlayer() == (viewGame.size())){
            startCard();
        }
    }

    protected void setPatternCardModel(VirtualView view, PatternCard pattern){

        model.setPatternAndNotify(view.getPlayerID(), pattern);

        setTokensModel(view);

        if(model.getNumberPlayer() == (getViewGame().size())){
            startTurn();
        }

    }

    protected void setTokensModel(VirtualView view) {

        model.setTokenAndNotify(view.getPlayerID());


    }

    protected void setDraftPoolModel(VirtualView view){


        model.setDraftPoolAndNotify();
        startChoose(view);

    }

    protected void setMoveModel(VirtualView view, int indexPool, int indexPattern) throws InvalidMoveException {

        model.setMoveAndNotify(view.getPlayerID(), indexPool, indexPattern);
        nextStepMove(view);
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

    private void startCard(){

        model.setNumberPlayer(0);
        setup.setPublicCardModel();
        for(VirtualView view : viewGame){
            view.sendEvent(new ToolCardUpdateEvent(getToolCardList()));
            setup.setPrivateCardModel(view);
            setup.startPatternCard(view);
        }

    }

    private void startTurn(){
        //startTimer();

        if(turn == DEFAULT){
            for (VirtualView view : viewGame) {
                view.sendEvent(new StartRoundEvent(round));
                this.position = setup.calculatePlayerTurn(turn, viewGame.size());
                this.currID = model.getPlayerList().get(position).getPlayerID();
                view.sendEvent(new StartTurnEvent(this.currID, this.model.getPlayerFromID(this.currID).getPlayerName()));
                if(round > START){
                    view.sendEvent(new TurnPatternEvent(this.currID, model.getPlayerFromID(currID).getPattern()));
                }
                view.sendEvent(new RollDraftPoolEvent(this.currID));

            }

        }
        else if (turn > DEFAULT && turn < (viewGame.size()*2)){
            for (VirtualView view : viewGame) {

                    this.position = setup.calculatePlayerTurn(turn, viewGame.size());
                    this.currID = model.getPlayerList().get(position).getPlayerID();
                    view.sendEvent(new StartTurnEvent(this.currID, this.model.getPlayerFromID(this.currID).getPlayerName()));
                    view.sendEvent(new TurnPatternEvent(this.currID, model.getPlayerFromID(currID).getPattern()));
                    if (currID == view.getPlayerID()) {
                        startChoose(view);
                    }

            }
        }else {

            endRound();
        }


    }

    private void startChoose(VirtualView view){

        view.sendEvent(new StartChooseEvent(view.getPlayerID()));
    }

    protected void startMove(VirtualView view){

        view.sendEvent(new StartMoveEvent(view.getPlayerID(), model.getDraftPool().getNowNumber()));
        //startTimer();

    }

    private void startTool(VirtualView view) {

        view.sendEvent(new StartToolEvent(view.getPlayerID(), toolCardList));
        //startTimer();

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
            setup.changeBagger();
            startTurn();
        }

    }

    private void endMatch(){

        setFinalPointsModel(roundManager.calculateWinner(model.getPlayerList(), model.getPublicList()));
        for (VirtualView view : viewGame){
            view.sendEvent(new WinnerEvent(model.getPlayerList().get(0).getPlayerID()));
        }

    }

    protected void nextTurn() {
        step = SET;
        turn++;
        startTurn();
    }

    protected void checkCost(VirtualView view, int indexTool){
        if(model.getPlayerFromID(view.getPlayerID()).getTokensNumber() < toolCardList.get(indexTool).getCost()){

            view.sendEvent(new OutOfTokenEvent(view.getPlayerID()));
            startTool(view);

        }else {


            toolController.toolCardEffectRequest(toolCardList.get(indexTool).getNumber(), view);
            int n = model.getPlayerFromID(view.getPlayerID()).getTokensNumber();
            model.getPlayerFromID(view.getPlayerID()).setTokensNumber(n - toolCardList.get(indexTool).getCost());
            if (toolCardList.get(indexTool).getCost() == START) {

                toolCardList.get(indexTool).setCost(SET);
            }

            //TODO verificare che i token siano madati giusti insieme alla pattern dopo l'uso della toolcard o nel round successivo

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


    /*protected void startTimer() {

        if (timer != null) {
            timer.cancel();
        }

        timer = new Timer();
        timer.schedule(new TimerTask()
        {
            @Override
            public void run() {
                nextTurn();
            }

        }, (long) 10 * 1000);
    }*/




}