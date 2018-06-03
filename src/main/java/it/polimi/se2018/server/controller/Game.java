package it.polimi.se2018.server.controller;


import it.polimi.se2018.exceptions.InvalidMoveException;
import it.polimi.se2018.server.VirtualView;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Components.DraftPool;
import it.polimi.se2018.server.model.Components.Model;
import it.polimi.se2018.server.model.Components.Player;
import it.polimi.se2018.server.model.Events.ClientServer.*;
import it.polimi.se2018.server.model.Events.ServerClient.ControllerView.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Game implements Observer {

    private static final int STARTTURN = 0;
    private static final int START = 1;
    private static final int END = 10;
    private Model model;
    private List<Player> playerList;
    private List<VirtualView> viewGame;
    private GameSetup setup;
    private RoundManager roundManager;
    private static int turn = STARTTURN;
    private static int round = START;
    private int position;
    private int currID;

    // add timer

    public Game(List<VirtualView> viewList) {

        this.model = new Model();
        this.viewGame = new ArrayList<>(viewList);
        this.playerList = new ArrayList<>();
        this.setup = new GameSetup(this);
        this.roundManager = new RoundManager();

        for (VirtualView view: viewGame) {
            Player player = new Player(view.getPlayerID());
            System.out.println("Player id in new Game" + player.getPlayerID());
            playerList.add(player);
        }

        model.setPlayerList(playerList);

        for (VirtualView view : viewGame) {
            view.addObserver(this);
            view.setModel(model);
            model.addObserver(view);
        }

        startGame();



    }


    // ogni metodo che modifica il model deve essere gestito da update (unico metodo pubblico), e chiamare il metodo
    // protected relativo al cambiamento
    // update gestisce

    protected Model getModel(){
        return model;
    }

    protected List<VirtualView> getViewGame(){
        return viewGame;
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

            turn++; //non presente
            startTurn(); //è startTool(view);
        }



    }
















    //--------metodi che modificano model e mandano la notify alla view----------
    protected void setPlayerNameModel(VirtualView view, String name) {

        //model.getPlayerFromID(view.getPlayerID()).setPlayerName(name);
        model.setPlayerAndNotify((view.getPlayerID()), name);

        if(model.getNumberPlayer() == (viewGame.size())){
            startCard();
        }
        //System.out.println("Sto modificando model" + view.getPlayerID() + "name" + name);
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
        startMove(view);

    }

    protected void setMoveModel(VirtualView view, int indexPool, int indexPattern) throws InvalidMoveException {

        model.setMoveAndNotify(view.getPlayerID(), indexPool, indexPattern);
        turn++;
        startTurn(); //in relatà sarebbe startTool(view)
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
            setup.setPrivateCardModel(view);
            setup.startPatternCard(view);
        }

    }

    private void startTurn(){
        if(turn == STARTTURN){
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
        else if (turn > STARTTURN && turn < (viewGame.size()*2)){
            for (VirtualView view : viewGame) {

                //System.out.println(turn);
                this.position = setup.calculatePlayerTurn(turn, viewGame.size());
                //System.out.println(position);
                this.currID = model.getPlayerList().get(position).getPlayerID();
                //System.out.println(currID);
                view.sendEvent(new StartTurnEvent(this.currID, this.model.getPlayerFromID(this.currID).getPlayerName()));
                view.sendEvent(new TurnPatternEvent(this.currID, model.getPlayerFromID(currID).getPattern()));
                if (currID == view.getPlayerID()) {
                    startMove(view);
                }

            }
        }else {

            endRound();
        }


    }

    private void startMove(VirtualView view){

        view.sendEvent(new StartMoveEvent(view.getPlayerID()));

    }

    /*private void startTool(VirtualView view){

       view.sendEvent(new StartToolEvent(view.getPlayerID()));
    }


    fa turn = 0, round++, e se round >10, allora
    chiama endMatch; gestisce inoltre tutti gli eventi della fine del round */
    private void endRound(){

        setEndRoundModel();
        round++;
        if (round > END){
            endMatch();
        }else {
            turn = STARTTURN;
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
}