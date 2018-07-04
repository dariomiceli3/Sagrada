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

public class RmiClientImpl extends UnicastRemoteObject implements RmiClientInterface {

    private View view;
    private Ping ping;

    RmiClientImpl(View view, Ping ping) throws RemoteException {
        super();
        this.view = view;
        this.ping = ping;

    }

    //----------------ovveride dei metodi di RmiClientInterface--------------
    // devono fare view.show

    @Override
    public void remoteIDEvent(int id) {
        view.setPlayerID(id);
        ping.setID(id);
        Thread threadPing = new Thread(ping);
        threadPing.start();
        view.showID();
    }

    @Override
    public void remoteSinglePlayerEvent(int id) {
        view.showSinglePlayerRequest();
    }

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

    @Override
    public void remotePlayerNameErrorEvent(int id) {
        if (view.getPlayerID() == id) {
            view.showNameError();
            view.showNameChoose();
        }
    }

    @Override
    public void remoteGameStartedEvent(boolean started) {
        view.setStarted(started);
        view.showGameStarted();
        view.showNameChoose();
    }

    @Override
    public void remotePlayerPrivateUpdateEvent(int id, PrivateObjectiveCard privateCard) {
        if (view.getPlayerID() == id) {
            view.showPrivateCard(privateCard);
        }
    }

    @Override
    public void remoteStartPatternEvent(int id, List<PatternCard> patternList) throws IOException {
        if (view.getPlayerID() == id) {
            view.showPatternList(patternList);
        }

    }

    @Override
    public void remotePublicDrawEvent(List<PublicObjectiveCard> publicList) throws IOException {
        view.showPublicCard(publicList);

    }

    @Override
    public void remotePlayerPatternUpdateEvent(int id, PatternCard patternCard) throws IOException {
        if (view.getPlayerID() == id) {
            view.showPattern(patternCard);
        }
        else {
            view.showOtherStartPattern(patternCard,id);
        }

    }

    @Override
    public void remoteStartGameSceneEvent() throws IOException {
        view.showStartScene();
    }

    @Override
    public void remotePlayerTokensUpdateEvent(int id, int numberTokens) {
        if (view.getPlayerID() == id) {
            view.showTokens(numberTokens);
        }
    }

    @Override
    public void remoteStartRoundEvent(int round) {
        view.showCurrentRound(round);
    }

    @Override
    public void remoteStartTurnEvent(int id, String name) {
        if (view.getPlayerID() == id) {
            view.showCurrentTurn();
        }
        else {
            view.showOtherCurrentTurn(name);
        }

    }

    @Override
    public void remoteRollDraftPoolEvent(int id) {
        if (view.getPlayerID() == id) {
            view.showRollCommand();
        }

    }

    @Override
    public void remotePlayerDraftPoolUpdateEvent(DraftPool draftPool) {
        view.showDraftPool(draftPool);

    }

    @Override
    public void remoteStartChooseEvent(int id) {
        if (view.getPlayerID() == id) {
            view.showChooseCommand();
        }

    }

    @Override
    public void remoteStartMoveEvent(int id, int poolSize) {
        if (view.getPlayerID() == id) {
            view.showMoveCommand(poolSize);
        }

    }

    @Override
    public void remotePatternUpdateEvent(int id, PatternCard patternCard, String name) {
        if (view.getPlayerID() == id) {
            view.showPatternUpdate(patternCard);
        }
        else {
            view.showOtherPattern(patternCard, name, id);
        }

    }

    @Override
    public void remoteRoundTrackerUpdateEvent(RoundTracker roundTracker) {
        view.showRoundTracker(roundTracker);

    }

    @Override
    public void remoteTurnPatternEvent(int id, PatternCard patternCard) {
        if (view.getPlayerID() == id) {
            view.showPatternUpdate(patternCard);
        }

    }

    @Override
    public void remoteStartToolEvent(int id, List<ToolCard> toolCards) {
        if (view.getPlayerID() == id) {
            view.showToolCommand(toolCards);
        }

    }

    @Override
    public void remoteOutOfTokenEvent(int id) {
        if (view.getPlayerID() == id) {
            view.showTokenError();
        }

    }

    @Override
    public void remotePlayerPointsUpdateEvent(List<Player> playerList, boolean ended) {
        view.showFinalRank(playerList,ended);

    }

    @Override
    public void remoteWinnerEvent(int id) {
        if (view.getPlayerID() == id) {
            view.showWinner();
        }
        else {
            view.showLosers();
        }

    }

    @Override
    public void remoteTimerEndedEvent(int id) {
        if (view.getPlayerID() == id) {
            view.showTimer();
        }

    }

    @Override
    public void remoteTimerOtherEvent(String name) {
        view.showOtherTimer(name);

    }

    @Override
    public void remoteToolCardUpdateEvent(List<ToolCard> toolCards) {
        view.showToolCards(toolCards);
    }

    @Override
    public void remoteGrozingPliersRequestEvent(int id, int poolSize) {
        if (view.getPlayerID() == id) {
            view.showGrozingRequest(poolSize);
        }

    }

    @Override
    public void remoteEglomiseBrushRequestEvent(int id) {
        if (view.getPlayerID() == id) {
            view.showEglomiseStart();
        }

    }

    @Override
    public void remoteCopperFoilRequestEvent(int id) {
        if (view.getPlayerID() == id) {
            view.showCopperFoilStart();
        }

    }

    @Override
    public void remoteLathekinRequestEvent(int id) {
        if (view.getPlayerID() == id) {
            view.showLathekinStart();
        }

    }

    @Override
    public void remoteLensCutterRequestEvent(int id, int poolSize, List<Integer> roundSizes) {
        if (view.getPlayerID() == id) {
            view.showLensCutterRequest(poolSize, roundSizes);
        }
    }

    @Override
    public void remoteFluxBrushRequesEvent(int id, int poolSize) {
        if (view.getPlayerID() == id) {
            view.showFluxBrushRequest(poolSize);
        }

    }

    @Override
    public void remoteGlazingHammerRequestEvent(int id) {
        if (view.getPlayerID() == id) {
            view.showGlazingHammerRequest();
        }

    }

    @Override
    public void remoteRunningPliersRequestEvent(int id, int poolSize) {
        if (view.getPlayerID() == id) {
            view.showRunningPliersPool(poolSize);
        }

    }

    @Override
    public void remoteCorkBackedRequestEvent(int id, int poolSize) {
        if (view.getPlayerID() == id) {
            view.showCorkBackedPool(poolSize);
        }

    }

    @Override
    public void remoteGrindingStoneRequestEvent(int id, int poolSize) {
        if (view.getPlayerID() == id) {
            view.showGrindingStoneRequest(poolSize);
        }

    }

    @Override
    public void remoteFluxRemoverRequestEvent(int id, DiceColor color, int poolSize) {
        if (view.getPlayerID() == id) {
            view.showFluxRemoverPool(color, poolSize);
        }

    }

    @Override
    public void remoteTapWheelRequestEvent(int id) {
        if (view.getPlayerID() == id) {
            view.showTapWheelNumber();
        }

    }

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

    @Override
    public void remoteUpdatePoolEvent(DraftPool draftPool) {
        view.showDraftPool(draftPool);

    }

    @Override
    public void remoteToolNumberRequestEvent() {
        view.showDifficultyRequest();

    }

    @Override
    public void remoteSinglePrivateEvent(List<PrivateObjectiveCard> privateList) {
        view.showPrivateSingle(privateList);

    }

    @Override
    public void remoteEndSinglePlayerEvent(boolean winner, int playerPoint, int threshold) {
        view.showEndSinglePlayer(winner, playerPoint, threshold);
    }

    @Override
    public void remoteStartToolSinglePlayer(List<ToolCard> toolCards, int poolSize) {
        view.showToolSingleCommand(toolCards, poolSize);
    }

    @Override
    public void remoteNotMatchColorEvent() {
        view.showMatchError();

    }

    @Override
    public void remoteMaxPlayerLogin() {
        view.showMaxPlayerLogin();
    }

    @Override
    public void remoteExitPlayer(String name) {
        view.showExitPlayer(name);
    }

    @Override
    public void remoteReconnectPlayer(String name) {
        view.showReconnectPlayer(name);
    }

    @Override
    public void remoteNotPermittedReconnection() {
        view.showNotPermittedReconnection();
    }

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

