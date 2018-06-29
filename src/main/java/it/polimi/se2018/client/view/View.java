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
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public abstract class View implements Runnable {

    //qui metodi generici comportamentabili, ovveride nelle varie view e chiamati da fuori

    protected String playerName;
    protected boolean isStarted;
    protected int playerID;

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

    public abstract void setConnection(ClientInterface client);

    public abstract ClientInterface getConnection();


    //---------------------- abstract method , which implementation depends on the view (cli or gui)

    public abstract void showID();

    public abstract void showGameStarted();

    public abstract void showNameChoose();

    public abstract void showName();

    public abstract void showNameOther(String name);

    public abstract void showNameError();

    public abstract void showPrivateCard(PrivateObjectiveCard privateObjectiveCard);

    public abstract void showPublicCard(List<PublicObjectiveCard> publicList) throws IOException;

    public abstract void showPatternList(List<PatternCard> patternCards) throws IOException;

    public abstract void showPattern(PatternCard patternCard) throws IOException;

    public abstract void showOtherPattern(PatternCard patternCard, String playerName, int ID);

    public abstract void showOtherStartPattern(PatternCard patternCard, int ID);

    public abstract void showPatternUpdate(PatternCard patternCard);

    public abstract void showTokens(int tokensNumber);

    public abstract void showStartScene() throws IOException;

    public abstract void showCurrentRound(int round);

    public abstract void showCurrentTurn();

    public abstract void showOtherCurrentTurn(String username);

    public abstract void showRollCommand();

    public abstract void showDraftPool(DraftPool draftPool);

    public abstract void showChooseCommand();

    public abstract void showMoveCommand(int poolSize);

    public abstract void showIndexPoolCommand(int poolsize);

    public abstract void showIndexPatternCommand();

    public abstract void showToolCommand(List<ToolCard> toolCards);

    public abstract void showToolChooseCommand();

    public abstract void showToolCostCommand(List<Integer> toolCost, int indexTool);

    public abstract void showRoundTracker(RoundTracker roundTracker);

    public abstract void showFinalRank(List<Player> playerList);

    public abstract void showWinner();

    public abstract void showLosers();

    public abstract void showTimer();

    public abstract void showOtherTimer(String playerName);

    public abstract void showToolCards(List<ToolCard> toolCardList);

    public abstract void showTokenError();

    //---------------------tool card----------------------------------------------------------------------

    public abstract void showGrozingRequest(int poolSize);

    public abstract void showGrozingCommand();

    public abstract void showEglomiseStart();

    public abstract void showEglomiseEnd();

    public abstract void showCopperFoilStart();

    public abstract void showCopperFoilEnd();

    public abstract void showLathekinStart();

    public abstract void showLathekinStartTwo();

    public abstract void showLathekinEnd();

    public abstract void showLathekinEndTwo();

    public abstract void showLensCutterRequest(int poolSize, List<Integer> round);

    public abstract void showLensCutterRound(List<Integer> round);

    public abstract void showLensCutterDice(List<Integer> round, int roundIndex);

    public abstract void showFluxBrushRequest(int poolSize);

    public abstract void showGlazingHammerRequest();

    public abstract void showRunningPliersPool(int poolSize);

    public abstract void showRunningPliersEnd();

    public abstract void showCorkBackedPool(int poolSize);

    public abstract void showCorkBackedEnd();

    public abstract void showGrindingStoneRequest(int poolSize);

    public abstract void showFluxRemoverPool(DiceColor color, int poolSize);

    public abstract void showFluxRemoverValue();

    public abstract void showTapWheelNumber();

    public abstract void showTapWheelStartOne();

    public abstract void showTapWheelEndOne();

    public abstract void showTapWheelStartTwo();

    public abstract void showTapWheelEndTwo();

    public abstract void showBoard(RoundTracker roundTracker,DraftPool draftPool);

    public abstract void showInvalidMove(String msg);

    //------------------------  single player mode

    public abstract void showSinglePlayerRequest();

    public abstract void showDifficultyRequest();

    public abstract void showPrivateSingle(List<PrivateObjectiveCard> publicList);

    public abstract void showToolSingleCommand(List<ToolCard> toolList, int poolSize);

    public abstract void showToolSingleChoose();

    public abstract void showToolSingleDice();

    public abstract void showMatchError();

    public abstract void showEndSinglePlayer(boolean winner, int playerPoints, int gameThreshold);

    //---------------disconnection

    public abstract void showMaxPlayerLogin();
}
