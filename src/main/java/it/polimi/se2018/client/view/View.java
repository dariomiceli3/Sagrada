package it.polimi.se2018.client.view;

import it.polimi.se2018.client.ClientInterface;
import it.polimi.se2018.server.controller.ToolCard;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.PublicObjectiveCard;
import it.polimi.se2018.server.model.Components.*;
import it.polimi.se2018.server.model.Events.Event;
import it.polimi.se2018.server.model.Cards.PatternCard;

import java.awt.*;
import java.util.List;
import java.util.Scanner;

public abstract class View implements Runnable {

    //qui metodi generici comportamentabili, ovveride nelle varie view e chiamati da fuori

    protected String playerName;
    protected boolean isStarted;
    protected int playerID;
    protected ClientInterface connection;

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setNameView(String nameView){
        this.playerName = nameView;
    }



    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean isStarted) {
        this.isStarted = isStarted;
    }

    public  void setConnection(ClientInterface client) {
        this.connection = client;
    }

    public  ClientInterface getConnection() {
        return connection;
    }

    //start method for gui
    public void startGUI(){

    }



    //---------------------- abstract method , which implementation depends on the view (cli or gui)

    public abstract void showID();

    public abstract void showGameStarted();

    public abstract void showNameChoose();

    public abstract void showName();

    public abstract void showNameOther(String name);

    public abstract void showNameError();

    public abstract void showPrivateCard(PrivateObjectiveCard privateObjectiveCard);

    public abstract void showPublicCard(List<PublicObjectiveCard> publicList);

    public abstract void showPatternList(List<PatternCard> patternCards);

    public abstract void showPatternChoose(int choose, List<PatternCard> patternCards);

    public abstract void showPattern(PatternCard patternCard);

    public abstract void showOtherPattern(PatternCard patternCard, String playerName);

    public abstract void showPatternUpdate(PatternCard patternCard);

    public abstract void showTokens(int tokensNumber);

    public abstract void showCurrentRound(int round);

    public abstract void showCurrentTurn();

    public abstract void showOtherCurrentTurn(String username);

    public abstract void showRollCommand();

    public abstract void showDraftPool(DraftPool draftPool);

    public abstract void showChooseCommand();

    public abstract void showMoveCommand(int poolSize);


    public abstract void showRoundTracker(RoundTracker roundTracker);

    public abstract void showFinalRank(List<Player> playerList);

    public abstract void showWinner();

    public abstract void showLosers();

    public abstract void showTimer();

    public abstract void showOtherTimer(String playerName);

    public abstract void showToolCards(List<ToolCard> toolCardList);

    public abstract void showTokenError();

    public abstract void showGrozingRequest(int poolSize);

    public abstract void showLensCutterRequest(int poolSize, List<Integer> round);

    public abstract void showFluxBrushRequest(int poolSize);

    public abstract void showGlazingHammerRequest();


    public abstract void showGrindingStoneRequest(int poolSize);


    public abstract void showBoard(RoundTracker roundTracker,DraftPool draftPool);

    public abstract void showInvalidMove(String msg);

    //------------------------  single player mode

    public abstract void showSinglePlayerRequest();

    public abstract void showDifficultyRequest();

    public abstract void showPrivateSingle(List<PrivateObjectiveCard> publicList);

    public abstract void showToolSingleCommand(List<ToolCard> toolList, int poolSize);

    public abstract void showMatchError();

}
