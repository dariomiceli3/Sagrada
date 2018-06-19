package it.polimi.se2018.client.network.rmi;

import it.polimi.se2018.client.view.View;
import it.polimi.se2018.server.controller.ToolCard;
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

    protected RmiClientImpl(View view) throws RemoteException {
        super();
        this.view = view;

    }

    //----------------ovveride dei metodi di RmiClientInterface--------------
    // devono fare view.show

    @Override
    public void remoteIDEvent(int ID) throws RemoteException {
        view.setPlayerID(ID);
        view.showID();
    }

    @Override
    public void remoteSinglePlayerEvent(int ID) {
        view.showSinglePlayerRequest();
    }

    @Override
    public void remotePlayerNameUpdateEvent(int ID, String name) {
        if (view.getPlayerID() == ID) {
            view.setNameView(name);
            view.showName();
        }
        else {
            view.showNameOther(name);
        }
    }

    @Override
    public void remotePlayerNameErrorEvent(int ID) throws RemoteException {
        if (view.getPlayerID() == ID) {
            view.showNameError();
            view.showNameChoose();
        }
    }

    @Override
    public void remoteGameStartedEvent(boolean started) throws RemoteException {
        view.setStarted(started);
        view.showGameStarted();
        view.showNameChoose();
    }

    @Override
    public void remotePlayerPrivateUpdateEvent(int ID, PrivateObjectiveCard privateCard) throws RemoteException {
        if (view.getPlayerID() == ID) {
            view.showPrivateCard(privateCard);
        }
    }

    @Override
    public void remoteStartPatternEvent(int ID, List<PatternCard> patternList) throws RemoteException, IOException {
        if (view.getPlayerID() == ID) {
            view.showPatternList(patternList);
        }

    }

    @Override
    public void remotePublicDrawEvent(List<PublicObjectiveCard> publicList) throws RemoteException, IOException {
        view.showPublicCard(publicList);

    }

    @Override
    public void remotePlayerPatternUpdateEvent(int ID, PatternCard patternCard) throws RemoteException, IOException {
        if (view.getPlayerID() == ID) {
            view.showPattern(patternCard);
        }
        else {
            view.showOtherStartPattern(patternCard,ID);
        }

    }

    @Override
    public void remoteStartGameSceneEvent() throws IOException {
        view.showStartScene();
    }

    @Override
    public void remotePlayerTokensUpdateEvent(int ID, int numberTokens) throws RemoteException {
        if (view.getPlayerID() == ID) {
            view.showTokens(numberTokens);
        }
    }

    @Override
    public void remoteStartRoundEvent(int round) throws RemoteException {
        view.showCurrentRound(round);
    }

    @Override
    public void remoteStartTurnEvent(int ID, String name) throws RemoteException {
        if (view.getPlayerID() == ID) {
            view.showCurrentTurn();
        }
        else {
            view.showOtherCurrentTurn(name);
        }

    }

    @Override
    public void remoteRollDraftPoolEvent(int ID) throws RemoteException {
        if (view.getPlayerID() == ID) {
            view.showRollCommand();
        }

    }

    @Override
    public void remotePlayerDraftPoolUpdateEvent(DraftPool draftPool) throws RemoteException {
        view.showDraftPool(draftPool);

    }

    @Override
    public void remoteStartChooseEvent(int ID) throws RemoteException {
        if (view.getPlayerID() == ID) {
            view.showChooseCommand();
        }

    }

    @Override
    public void remoteStartMoveEvent(int ID, int poolSize) throws RemoteException {
        if (view.getPlayerID() == ID) {
            view.showMoveCommand(poolSize);
        }

    }

    @Override
    public void remotePatternUpdateEvent(int ID, PatternCard patternCard, String name) throws RemoteException {
        if (view.getPlayerID() == ID) {
            view.showPatternUpdate(patternCard);
        }
        else {
            view.showOtherPattern(patternCard, name, ID);
        }

    }

    @Override
    public void remoteRoundTrackerUpdateEvent(RoundTracker roundTracker) throws RemoteException {
        view.showRoundTracker(roundTracker);

    }

    @Override
    public void remoteTurnPatternEvent(int ID, PatternCard patternCard) throws RemoteException {
        if (view.getPlayerID() == ID) {
            view.showPatternUpdate(patternCard);
        }

    }

    @Override
    public void remoteStartToolEvent(int ID, List<ToolCard> toolCards) throws RemoteException {
        if (view.getPlayerID() == ID) {
            view.showToolCommand(toolCards);
        }

    }

    @Override
    public void remoteOutOfTokenEvent(int ID) throws RemoteException {
        if (view.getPlayerID() == ID) {
            view.showTokenError();
        }

    }

    @Override
    public void remotePlayerPointsUpdateEvent(List<Player> playerList) throws RemoteException {
        view.showFinalRank(playerList);

    }

    @Override
    public void remoteWinnerEvent(int ID) throws RemoteException {
        if (view.getPlayerID() == ID) {
            view.showWinner();
        }
        else {
            view.showLosers();
        }

    }

    @Override
    public void remoteTimerEndedEvent(int ID) throws RemoteException {
        if (view.getPlayerID() == ID) {
            view.showTimer();
        }

    }

    @Override
    public void remoteTimerOtherEvent(String name) throws RemoteException {
        view.showOtherTimer(name);

    }

    @Override
    public void remoteToolCardUpdateEvent(List<ToolCard> toolCards) throws RemoteException {
        view.showToolCards(toolCards);
    }

    @Override
    public void remoteGrozingPliersRequestEvent(int ID, int poolSize) throws RemoteException {
        if (view.getPlayerID() == ID) {
            view.showGrozingRequest(poolSize);
        }

    }

    @Override
    public void remoteEglomiseBrushRequestEvent(int ID) throws RemoteException {
        if (view.getPlayerID() == ID) {
            view.showEglomiseStart();
        }

    }

    @Override
    public void remoteCopperFoilRequestEvent(int ID) throws RemoteException {
        if (view.getPlayerID() == ID) {
            view.showCopperFoilStart();
        }

    }

    @Override
    public void remoteLathekinRequestEvent(int ID) throws RemoteException {
        if (view.getPlayerID() == ID) {
            view.showLathekinStart();
        }

    }

    @Override
    public void remoteLensCutterRequestEvent(int ID, int poolSize, List<Integer> roundSizes) throws RemoteException {
        if (view.getPlayerID() == ID) {
            view.showLensCutterRequest(poolSize, roundSizes);
        }
    }

    @Override
    public void remoteFluxBrushRequesEvent(int ID, int poolSize) throws RemoteException {
        if (view.getPlayerID() == ID) {
            view.showFluxBrushRequest(poolSize);
        }

    }

    @Override
    public void remoteGlazingHammerRequestEvent(int ID) throws RemoteException {
        if (view.getPlayerID() == ID) {
            view.showGlazingHammerRequest();
        }

    }

    @Override
    public void remoteRunningPliersRequestEvent(int ID, int poolSize) throws RemoteException {
        if (view.getPlayerID() == ID) {
            view.showRunningPliersPool(poolSize);
        }

    }

    @Override
    public void remoteCorkBackedRequestEvent(int ID, int poolSize) throws RemoteException {
        if (view.getPlayerID() == ID) {
            view.showCorkBackedPool(poolSize);
        }

    }

    @Override
    public void remoteGrindingStoneRequestEvent(int ID, int poolSize) throws RemoteException {
        if (view.getPlayerID() == ID) {
            view.showGrindingStoneRequest(poolSize);
        }

    }

    @Override
    public void remoteFluxRemoverRequestEvent(int ID, DiceColor color, int poolSize) throws RemoteException {
        if (view.getPlayerID() == ID) {
            view.showFluxRemoverPool(color, poolSize);
        }

    }

    @Override
    public void remoteTapWheelRequestEvent(int ID) throws RemoteException {
        if (view.getPlayerID() == ID) {
            view.showTapWheelNumber();
        }

    }

    @Override
    public void remoteUpdateBoardEvent(RoundTracker roundTracker, DraftPool draftPool) throws RemoteException {
        view.showBoard(roundTracker, draftPool);
    }

    @Override
    public void remoteInvalidMoveEvent(int ID, String errorMsg) throws RemoteException {
        if (view.getPlayerID() == ID) {
            view.showInvalidMove(errorMsg);
        }

    }

    @Override
    public void remoteUpdatePoolEvent(DraftPool draftPool) throws RemoteException {
        view.showDraftPool(draftPool);

    }

    @Override
    public void remoteToolNumberRequestEvent() throws RemoteException {
        view.showDifficultyRequest();

    }

    @Override
    public void remoteSinglePrivateEvent(List<PrivateObjectiveCard> privateList) throws RemoteException {
        view.showPrivateSingle(privateList);

    }

    @Override
    public void remoteEndSinglePlayerEvent(boolean winner, int playerPoint, int threshold) throws RemoteException {
        view.showEndSinglePlayer(winner, playerPoint, threshold);
    }

    @Override
    public void remoteStartToolSinglePlayer(List<ToolCard> toolCards, int poolSize) throws RemoteException {
        view.showToolSingleCommand(toolCards, poolSize);
    }

    @Override
    public void remoteNotMatchColorEvent() throws RemoteException {
        view.showMatchError();

    }
}

