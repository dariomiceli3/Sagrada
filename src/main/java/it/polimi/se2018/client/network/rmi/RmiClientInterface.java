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


    public void remoteIDEvent(int ID) throws RemoteException;

    public void remoteSinglePlayerEvent(int ID) throws RemoteException;

    public void remotePlayerNameUpdateEvent(int ID, String name) throws RemoteException;

    public void remotePlayerNameErrorEvent(int ID) throws RemoteException;

    public void remoteGameStartedEvent(boolean started) throws RemoteException;

    public void remotePlayerPrivateUpdateEvent(int ID, PrivateObjectiveCard privateCard) throws RemoteException;

    public void remoteStartPatternEvent(int ID, List<PatternCard> patternList) throws RemoteException, IOException;

    public void remotePublicDrawEvent(List<PublicObjectiveCard> publicList) throws RemoteException, IOException;

    public void remotePlayerPatternUpdateEvent(int ID, PatternCard patternCard) throws RemoteException, IOException;

    public void remoteStartGameSceneEvent() throws RemoteException, IOException;

    public void remotePlayerTokensUpdateEvent(int ID, int numberTokens) throws RemoteException;

    public void remoteStartRoundEvent(int round) throws RemoteException;

    public void remoteStartTurnEvent(int ID, String name) throws RemoteException;

    public void remoteRollDraftPoolEvent(int ID) throws RemoteException;

    public void remotePlayerDraftPoolUpdateEvent(DraftPool draftPool) throws RemoteException;

    public void remoteStartChooseEvent(int ID) throws RemoteException;

    public void remoteStartMoveEvent(int ID, int poolSize) throws RemoteException;

    public void remotePatternUpdateEvent(int ID, PatternCard patternCard, String name) throws RemoteException;

    public void remoteRoundTrackerUpdateEvent(RoundTracker roundTracker) throws RemoteException;

    public void remoteTurnPatternEvent(int ID, PatternCard patternCard) throws RemoteException;

    public void remoteStartToolEvent(int ID, List<ToolCard> toolCards) throws RemoteException;

    public void remoteOutOfTokenEvent(int ID) throws RemoteException;

    public void remotePlayerPointsUpdateEvent(List<Player> playerList,boolean ended) throws RemoteException;

    public void remoteWinnerEvent(int ID) throws RemoteException;

    public void remoteTimerEndedEvent(int ID) throws RemoteException;

    public void remoteTimerOtherEvent(String name) throws RemoteException;

    public void remoteToolCardUpdateEvent(List<ToolCard> toolCards) throws RemoteException;

    public void remoteGrozingPliersRequestEvent(int ID, int poolSize) throws RemoteException;

    public void remoteEglomiseBrushRequestEvent(int ID) throws RemoteException;

    public void remoteCopperFoilRequestEvent(int ID) throws RemoteException;

    public void remoteLathekinRequestEvent(int ID) throws RemoteException;

    public void remoteLensCutterRequestEvent(int ID, int poolSize, List<Integer> roundSizes) throws RemoteException;

    public void remoteFluxBrushRequesEvent(int ID, int poolSize) throws RemoteException;

    public void remoteGlazingHammerRequestEvent(int ID) throws RemoteException;

    public void remoteRunningPliersRequestEvent(int ID, int poolSize) throws RemoteException;

    public void remoteCorkBackedRequestEvent(int ID, int poolSize) throws RemoteException;

    public void remoteGrindingStoneRequestEvent(int ID, int poolSize) throws RemoteException;

    public void remoteFluxRemoverRequestEvent(int ID, DiceColor color, int poolSize) throws RemoteException;

    public void remoteTapWheelRequestEvent(int ID) throws RemoteException;

    public void remoteUpdateBoardEvent(RoundTracker roundTracker, DraftPool draftPool) throws RemoteException;

    public void remoteInvalidMoveEvent(int ID, String errorMsg) throws RemoteException;

    public void remoteUpdatePoolEvent(DraftPool draftPool) throws RemoteException;

    public void remoteToolNumberRequestEvent() throws RemoteException;

    public void remoteSinglePrivateEvent(List<PrivateObjectiveCard> privateList) throws RemoteException;

    public void remoteEndSinglePlayerEvent(boolean winner, int playerPoint, int threshold) throws RemoteException;

    public void remoteStartToolSinglePlayer(List<ToolCard> toolCards, int poolSize) throws RemoteException;

    public void remoteNotMatchColorEvent() throws RemoteException;

    //-------------------------disconection----------------------------------------------------------------

    public void remoteMaxPlayerLogin() throws RemoteException;

    public void remoteExitPlayer(String name) throws RemoteException;

    public void remoteReconnectPlayer(String name) throws RemoteException;

    public void remoteNotPermittedReconnection() throws RemoteException;

    public void remoteSuccessfulReconnection(Player currPlayer,boolean singlePlay, boolean gameStart, List<ToolCard> tool, List<PublicObjectiveCard> publicCard, List<Player> players) throws RemoteException;

}
