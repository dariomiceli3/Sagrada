package it.polimi.se2018.client.network.rmi;

import it.polimi.se2018.server.model.Cards.ToolCard;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.PublicObjectiveCard;
import it.polimi.se2018.server.model.Components.DiceColor;
import it.polimi.se2018.server.model.Components.DraftPool;
import it.polimi.se2018.server.model.Components.Player;
import it.polimi.se2018.server.model.Components.RoundTracker;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RmiClientInterface extends Remote {

    // client stub , tutti i metodi del server sul client
    //  segnature dei metodi


    void remoteIDEvent(int id) throws RemoteException;

    void remoteSinglePlayerEvent(int id) throws RemoteException;

    void remotePlayerNameUpdateEvent(int id, String name) throws RemoteException;

    void remotePlayerNameErrorEvent(int id) throws RemoteException;

    void remoteGameStartedEvent(boolean started) throws RemoteException;

    void remotePlayerPrivateUpdateEvent(int id, PrivateObjectiveCard privateCard) throws RemoteException;

    void remoteStartPatternEvent(int id, List<PatternCard> patternList) throws IOException;

    void remotePublicDrawEvent(List<PublicObjectiveCard> publicList) throws IOException;

    void remotePlayerPatternUpdateEvent(int id, PatternCard patternCard) throws IOException;

    void remoteStartGameSceneEvent() throws IOException;

    void remotePlayerTokensUpdateEvent(int id, int numberTokens) throws RemoteException;

    void remoteStartRoundEvent(int round) throws RemoteException;

    void remoteStartTurnEvent(int id, String name) throws RemoteException;

    void remoteRollDraftPoolEvent(int id) throws RemoteException;

    void remotePlayerDraftPoolUpdateEvent(DraftPool draftPool) throws RemoteException;

    void remoteStartChooseEvent(int id) throws RemoteException;

    void remoteStartMoveEvent(int id, int poolSize) throws RemoteException;

    void remotePatternUpdateEvent(int id, PatternCard patternCard, String name) throws RemoteException;

    void remoteRoundTrackerUpdateEvent(RoundTracker roundTracker) throws RemoteException;

    void remoteTurnPatternEvent(int id, PatternCard patternCard) throws RemoteException;

    void remoteStartToolEvent(int id, List<ToolCard> toolCards) throws RemoteException;

    void remoteOutOfTokenEvent(int id) throws RemoteException;

    void remotePlayerPointsUpdateEvent(List<Player> playerList,boolean ended) throws RemoteException;

    void remoteWinnerEvent(int id) throws RemoteException;

    void remoteTimerEndedEvent(int id) throws RemoteException;

    void remoteTimerOtherEvent(String name) throws RemoteException;

    void remoteToolCardUpdateEvent(List<ToolCard> toolCards) throws RemoteException;

    void remoteGrozingPliersRequestEvent(int id, int poolSize) throws RemoteException;

    void remoteEglomiseBrushRequestEvent(int id) throws RemoteException;

    void remoteCopperFoilRequestEvent(int id) throws RemoteException;

    void remoteLathekinRequestEvent(int id) throws RemoteException;

    void remoteLensCutterRequestEvent(int id, int poolSize, List<Integer> roundSizes) throws RemoteException;

    void remoteFluxBrushRequesEvent(int id, int poolSize) throws RemoteException;

    void remoteGlazingHammerRequestEvent(int id) throws RemoteException;

    void remoteRunningPliersRequestEvent(int id, int poolSize) throws RemoteException;

    void remoteCorkBackedRequestEvent(int id, int poolSize) throws RemoteException;

    void remoteGrindingStoneRequestEvent(int id, int poolSize) throws RemoteException;

    void remoteFluxRemoverRequestEvent(int id, DiceColor color, int poolSize) throws RemoteException;

    void remoteTapWheelRequestEvent(int id) throws RemoteException;

    void remoteUpdateBoardEvent(RoundTracker roundTracker, DraftPool draftPool) throws RemoteException;

    void remoteInvalidMoveEvent(int id, String errorMsg) throws RemoteException;

    void remoteUpdatePoolEvent(DraftPool draftPool) throws RemoteException;

    void remoteToolNumberRequestEvent() throws RemoteException;

    void remoteSinglePrivateEvent(List<PrivateObjectiveCard> privateList) throws RemoteException;

    void remoteEndSinglePlayerEvent(boolean winner, int playerPoint, int threshold) throws RemoteException;

    void remoteStartToolSinglePlayer(List<ToolCard> toolCards, int poolSize) throws RemoteException;

    void remoteNotMatchColorEvent() throws RemoteException;

    //-------------------------disconection----------------------------------------------------------------

    void remoteMaxPlayerLogin() throws RemoteException;

    void remoteExitPlayer(String name) throws RemoteException;

    void remoteReconnectPlayer(String name) throws RemoteException;

    void remoteNotPermittedReconnection() throws RemoteException;

    void remoteSuccessfulReconnection(Player currPlayer,boolean singlePlay, boolean gameStart, List<ToolCard> tool, List<PublicObjectiveCard> publicCard, List<Player> players) throws RemoteException;

}
