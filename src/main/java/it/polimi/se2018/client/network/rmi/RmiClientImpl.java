package it.polimi.se2018.client.network.rmi;

import it.polimi.se2018.client.view.View;
import it.polimi.se2018.server.model.Cards.ToolCard;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.PublicObjectiveCard;
import it.polimi.se2018.server.model.Components.DiceColor;
import it.polimi.se2018.server.model.Components.DraftPool;
import it.polimi.se2018.server.model.Components.Player;
import it.polimi.se2018.server.model.Components.RoundTracker;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 * class RmiClientImpl: the class implements the RmiClientInterface, so it's responsible of the implementation of the
 * interface methods, the implementation is linked with a Ping responsible to ping the server and the associate view
 * to let the remote call methods to call the generics and behavioural methods of the view
 * @see java.rmi.Remote
 * @see it.polimi.se2018.client.network.rmi.RmiClientInterface
 * @author fadda-miceli-mundo
 */
public class RmiClientImpl extends UnicastRemoteObject implements RmiClientInterface {

    private View view;
    private Ping ping;

    /**
     * Class constructor that link the implementation with the view and the ping
     * @param view to set
     * @param ping to set
     * @throws RemoteException
     */
    RmiClientImpl(View view, Ping ping) throws RemoteException {
        super();
        this.view = view;
        this.ping = ping;

    }

    //----------------Override di RmiClientInterface--------------

    /**
     * @see RmiClientInterface
     * @param id of the player to set
     */
    @Override
    public void remoteIDEvent(int id) {
        view.setPlayerID(id);
        ping.setID(id);
        Thread threadPing = new Thread(ping);
        threadPing.start();
        view.showID();
    }

    /**
     * @see RmiClientInterface
     * @param id of the player
     */
    @Override
    public void remoteSinglePlayerEvent(int id) {
        view.showSinglePlayerRequest();
    }

    /**
     * @see RmiClientInterface
     * @param id of the player
     * @param name setted
     */
    @Override
    public void remotePlayerNameUpdateEvent(int id, String name) {
        if (view.getPlayerID() == id) {
            view.setNameView(name);
            view.showName();
        }
        else {
            view.showNameOther(name);
        }
    }

    /**
     * @see RmiClientInterface
     * @param id of the player
     */
    @Override
    public void remotePlayerNameErrorEvent(int id) {
        if (view.getPlayerID() == id) {
            view.showNameError();
            view.showNameChoose();
        }
    }

    /**
     * @see RmiClientInterface
     * @param started state of the game
     */
    @Override
    public void remoteGameStartedEvent(boolean started) {
        view.setStarted(started);
        view.showGameStarted();
        view.showNameChoose();
    }

    /**
     * @see RmiClientInterface
     * @param id of the player
     * @param privateCard of the player
     */
    @Override
    public void remotePlayerPrivateUpdateEvent(int id, PrivateObjectiveCard privateCard) {
        if (view.getPlayerID() == id) {
            view.showPrivateCard(privateCard);
        }
    }

    /**
     * @see RmiClientInterface
     * @param id of the player
     * @param patternList for the choose of the player
     * @throws IOException
     */
    @Override
    public void remoteStartPatternEvent(int id, List<PatternCard> patternList) throws IOException {
        if (view.getPlayerID() == id) {
            view.showPatternList(patternList);
        }

    }

    /**
     * @see RmiClientInterface
     * @param publicList for the game
     * @throws IOException
     */
    @Override
    public void remotePublicDrawEvent(List<PublicObjectiveCard> publicList) throws IOException {
        view.showPublicCard(publicList);

    }

    /**
     * @see RmiClientInterface
     * @param id of the player
     * @param patternCard choosed by the player
     * @throws IOException
     */
    @Override
    public void remotePlayerPatternUpdateEvent(int id, PatternCard patternCard) throws IOException {
        if (view.getPlayerID() == id) {
            view.showPattern(patternCard);
        }
        else {
            view.showOtherStartPattern(patternCard,id);
        }

    }

    /**
     * @see RmiClientInterface
     * @throws IOException
     */
    @Override
    public void remoteStartGameSceneEvent() throws IOException {
        view.showStartScene();
    }

    /**
     * @see RmiClientInterface
     * @param id of the player
     * @param numberTokens available for the player at the moment of the call
     */
    @Override
    public void remotePlayerTokensUpdateEvent(int id, int numberTokens) {
        if (view.getPlayerID() == id) {
            view.showTokens(numberTokens);
        }
    }

    /**
     * @see RmiClientInterface
     * @param round of the game at the moment of the call
     */
    @Override
    public void remoteStartRoundEvent(int round) {
        view.showCurrentRound(round);
    }

    /**
     * @see RmiClientInterface
     * @param id of the player
     * @param name of the player of the current turn
     */
    @Override
    public void remoteStartTurnEvent(int id, String name) {
        if (view.getPlayerID() == id) {
            view.showCurrentTurn();
        }
        else {
            view.showOtherCurrentTurn(name);
        }
    }

    /**
     * @see RmiClientInterface
     * @param id of the player
     */
    @Override
    public void remoteRollDraftPoolEvent(int id) {
        if (view.getPlayerID() == id) {
            view.showRollCommand();
        }
    }

    /**
     * @see RmiClientInterface
     * @param draftPool of the game at the moment of the call
     */
    @Override
    public void remotePlayerDraftPoolUpdateEvent(DraftPool draftPool) {
        view.showDraftPool(draftPool);

    }

    /**
     * @see RmiClientInterface
     * @param id of the player
     */
    @Override
    public void remoteStartChooseEvent(int id) {
        if (view.getPlayerID() == id) {
            view.showChooseCommand();
        }
    }

    /**
     * @see RmiClientInterface
     * @param id of the player
     * @param poolSize of the draft pool at the moment of the call
     */
    @Override
    public void remoteStartMoveEvent(int id, int poolSize) {
        if (view.getPlayerID() == id) {
            view.showMoveCommand(poolSize);
        }
    }

    /**
     * @see RmiClientInterface
     * @param id of the player
     * @param patternCard of the player at the moment of the call
     * @param name of the player
     */
    @Override
    public void remotePatternUpdateEvent(int id, PatternCard patternCard, String name) {
        if (view.getPlayerID() == id) {
            view.showPatternUpdate(patternCard);
        }
        else {
            view.showOtherPattern(patternCard, name, id);
        }
    }

    /**
     * @see RmiClientInterface
     * @param roundTracker of the game at the moment of the call
     */
    @Override
    public void remoteRoundTrackerUpdateEvent(RoundTracker roundTracker) {
        view.showRoundTracker(roundTracker);

    }

    /**
     * @see RmiClientInterface
     * @param id of the player
     * @param patternCard of the player at the moment of the call
     */
    @Override
    public void remoteTurnPatternEvent(int id, PatternCard patternCard) {
        if (view.getPlayerID() == id) {
            view.showPatternUpdate(patternCard);
        }
    }

    /**
     * @see RmiClientInterface
     * @param id of the player
     * @param toolCards list of the game at the moment of the call
     */
    @Override
    public void remoteStartToolEvent(int id, List<ToolCard> toolCards) {
        if (view.getPlayerID() == id) {
            view.showToolCommand(toolCards);
        }
    }

    /**
     * @see RmiClientInterface
     * @param id of the player
     */
    @Override
    public void remoteOutOfTokenEvent(int id) {
        if (view.getPlayerID() == id) {
            view.showTokenError();
        }
    }

    /**
     * @see RmiClientInterface
     * @param playerList of the game at the moment of the call
     * @param ended state of the game
     */
    @Override
    public void remotePlayerPointsUpdateEvent(List<Player> playerList, boolean ended) {
        view.showFinalRank(playerList,ended);

    }

    /**
     * @see RmiClientInterface
     * @param id of the player winner
     */
    @Override
    public void remoteWinnerEvent(int id) {
        if (view.getPlayerID() == id) {
            view.showWinner();
        }
        else {
            view.showLosers();
        }
    }

    /**
     * @see RmiClientInterface
     * @param id of the player
     */
    @Override
    public void remoteTimerEndedEvent(int id) {
        if (view.getPlayerID() == id) {
            view.showTimer();
        }
    }


    /**
     * @see RmiClientInterface
     * @param name of the player
     */
    @Override
    public void remoteTimerOtherEvent(String name) {
        view.showOtherTimer(name);

    }

    /**
     * @see RmiClientInterface
     * @param toolCards list of the game at the moment of the call
     */
    @Override
    public void remoteToolCardUpdateEvent(List<ToolCard> toolCards) {
        view.showToolCards(toolCards);
    }

    /**
     * @see RmiClientInterface
     * @param id of the player
     * @param poolSize of the game at the moment of the call
     */
    @Override
    public void remoteGrozingPliersRequestEvent(int id, int poolSize) {
        if (view.getPlayerID() == id) {
            view.showGrozingRequest(poolSize);
        }
    }

    /**
     * @see RmiClientInterface
     * @param id of the player
     */
    @Override
    public void remoteEglomiseBrushRequestEvent(int id) {
        if (view.getPlayerID() == id) {
            view.showEglomiseStart();
        }
    }

    /**
     * @see RmiClientInterface
     * @param id of the player
     */
    @Override
    public void remoteCopperFoilRequestEvent(int id) {
        if (view.getPlayerID() == id) {
            view.showCopperFoilStart();
        }
    }

    /**
     * @see RmiClientInterface
     * @param id of the player
     */
    @Override
    public void remoteLathekinRequestEvent(int id) {
        if (view.getPlayerID() == id) {
            view.showLathekinStart();
        }
    }

    /**
     * @see RmiClientInterface
     * @param id of the player
     * @param poolSize of the game at the moment of the call
     * @param roundSizes of the game at the moment of the call
     */
    @Override
    public void remoteLensCutterRequestEvent(int id, int poolSize, List<Integer> roundSizes) {
        if (view.getPlayerID() == id) {
            view.showLensCutterRequest(poolSize, roundSizes);
        }
    }

    /**
     * @see RmiClientInterface
     * @param id of the player
     * @param poolSize of the game at the moment of the call
     */
    @Override
    public void remoteFluxBrushRequesEvent(int id, int poolSize) {
        if (view.getPlayerID() == id) {
            view.showFluxBrushRequest(poolSize);
        }
    }

    /**
     * @see RmiClientInterface
     * @param id of the player
     */
    @Override
    public void remoteGlazingHammerRequestEvent(int id) {
        if (view.getPlayerID() == id) {
            view.showGlazingHammerRequest();
        }
    }

    /**
     * @see RmiClientInterface
     * @param id of the player
     * @param poolSize of the game at the moment of the call
     */
    @Override
    public void remoteRunningPliersRequestEvent(int id, int poolSize) {
        if (view.getPlayerID() == id) {
            view.showRunningPliersPool(poolSize);
        }
    }

    /**
     * @see RmiClientInterface
     * @param id of the player
     * @param poolSize of the game at the moment of the call
     */
    @Override
    public void remoteCorkBackedRequestEvent(int id, int poolSize) {
        if (view.getPlayerID() == id) {
            view.showCorkBackedPool(poolSize);
        }
    }

    /**
     * @see RmiClientInterface
     * @param id of the player
     * @param poolSize of the game at the moment of the call
     */
    @Override
    public void remoteGrindingStoneRequestEvent(int id, int poolSize) {
        if (view.getPlayerID() == id) {
            view.showGrindingStoneRequest(poolSize);
        }
    }

    /**
     * @see RmiClientInterface
     * @param id of the player
     * @param color of the dice
     * @param poolSize of the game at the moment of the call
     */
    @Override
    public void remoteFluxRemoverRequestEvent(int id, DiceColor color, int poolSize) {
        if (view.getPlayerID() == id) {
            view.showFluxRemoverPool(color, poolSize);
        }
    }

    /**
     * @see RmiClientInterface
     * @param id of the player
     */
    @Override
    public void remoteTapWheelRequestEvent(int id) {
        if (view.getPlayerID() == id) {
            view.showTapWheelNumber();
        }
    }

    /**
     * @see RmiClientInterface
     * @param roundTracker of the game at the moment of the call
     * @param draftPool of the game at the moment of the call
     */
    @Override
    public void remoteUpdateBoardEvent(RoundTracker roundTracker, DraftPool draftPool) {
        view.showBoard(roundTracker, draftPool);
    }

    @Override
    public void remoteInvalidMoveEvent(int id, String errorMsg) {
        if (view.getPlayerID() == id) {
            view.showInvalidMove(errorMsg);
        }
    }

    /**
     * @see RmiClientInterface
     * @param draftPool of the game at the moment of the call
     */
    @Override
    public void remoteUpdatePoolEvent(DraftPool draftPool) {
        view.showDraftPool(draftPool);
    }

    /**
     * @see RmiClientInterface
     */
    @Override
    public void remoteToolNumberRequestEvent() {
        view.showDifficultyRequest();
    }

    /**
     * @see RmiClientInterface
     * @param privateList of the game at the moment of the call
     */
    @Override
    public void remoteSinglePrivateEvent(List<PrivateObjectiveCard> privateList) {
        view.showPrivateSingle(privateList);
    }

    /**
     * @see RmiClientInterface
     * @param winner state of the game
     * @param playerPoint of the player
     * @param threshold to reach to win
     */
    @Override
    public void remoteEndSinglePlayerEvent(boolean winner, int playerPoint, int threshold) {
        view.showEndSinglePlayer(winner, playerPoint, threshold);
    }

    /**
     * @see RmiClientInterface
     * @param toolCards list of the game at the moment of the call
     * @param poolSize of the game at the moment of the call
     */
    @Override
    public void remoteStartToolSinglePlayer(List<ToolCard> toolCards, int poolSize) {
        view.showToolSingleCommand(toolCards, poolSize);
    }

    /**
     * @see RmiClientInterface
     */
    @Override
    public void remoteNotMatchColorEvent() {
        view.showMatchError();
    }

    /**
     * @see RmiClientInterface
     */
    @Override
    public void remoteMaxPlayerLogin() {
        view.showMaxPlayerLogin();
    }

    /**
     * @see RmiClientInterface
     * @param name of the player
     */
    @Override
    public void remoteExitPlayer(String name) {
        view.showExitPlayer(name);
    }

    /**
     * @see RmiClientInterface
     * @param name of the player
     */
    @Override
    public void remoteReconnectPlayer(String name) {
        view.showReconnectPlayer(name);
    }

    /**
     * @see RmiClientInterface
     */
    @Override
    public void remoteNotPermittedReconnection() {
        view.showNotPermittedReconnection();
    }

    /**
     * @see RmiClientInterface
     * @param currPlayer of the game
     * @param singlePlay mode game
     * @param gameStart state of the game
     * @param tool list of the game
     * @param publicCard list of the game
     * @param players in the game
     */
    @Override
    public void remoteSuccessfulReconnection(Player currPlayer,boolean singlePlay, boolean gameStart, List<ToolCard> tool, List<PublicObjectiveCard> publicCard, List<Player> players) {
        view.showReload(currPlayer, singlePlay, gameStart, tool, publicCard, players);
    }


    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

