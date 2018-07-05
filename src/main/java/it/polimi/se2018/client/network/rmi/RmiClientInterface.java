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

/**
 * interface RmiClientInterface: the interface responsible to provide to the class that implements the interface
 * the methods signature for remote call of the server on the client skeleton, the implementation depends from the class
 * @see java.rmi.Remote
 * @author fadda-miceli-mundo
 */
public interface RmiClientInterface extends Remote {

    /**
     * method that update the view associate with the id event
     * @param id of the player to set
     * @throws RemoteException
     */
    void remoteIDEvent(int id) throws RemoteException;

    /**
     * method that update the view with the game mode request event
     * @param id of the player
     * @throws RemoteException
     */
    void remoteSinglePlayerEvent(int id) throws RemoteException;

    /**
     * method that update the view with the player name event
     * @param id of the player
     * @param name setted
     * @throws RemoteException
     */
    void remotePlayerNameUpdateEvent(int id, String name) throws RemoteException;

    /**
     * method that update the view with the error name event
     * @param id of the player
     * @throws RemoteException
     */
    void remotePlayerNameErrorEvent(int id) throws RemoteException;

    /**
     * method that update the view with the game started event
     * @param started state of the game
     * @throws RemoteException
     */
    void remoteGameStartedEvent(boolean started) throws RemoteException;

    /**
     * method that update the view with the private card player event
     * @param id of the player
     * @param privateCard of the player
     * @throws RemoteException
     */
    void remotePlayerPrivateUpdateEvent(int id, PrivateObjectiveCard privateCard) throws RemoteException;

    /**
     * method that update the view with the list of pattern card event
     * @param id of the player
     * @param patternList for the choose of the player
     * @throws IOException
     */
    void remoteStartPatternEvent(int id, List<PatternCard> patternList) throws IOException;

    /**
     * method that update the view with the list of the public card event
     * @param publicList for the game
     * @throws IOException
     */
    void remotePublicDrawEvent(List<PublicObjectiveCard> publicList) throws IOException;

    /**
     * method that update the view with the player pattern card event
     * @param id of the player
     * @param patternCard choosed by the player
     * @throws IOException
     */
    void remotePlayerPatternUpdateEvent(int id, PatternCard patternCard) throws IOException;

    /**
     * method that update the view with the start game scene event
     * @throws IOException
     */
    void remoteStartGameSceneEvent() throws IOException;

    /**
     * method that update the view with the player tokens event
     * @param id of the player
     * @param numberTokens available for the player at the moment of the call
     * @throws RemoteException
     */
    void remotePlayerTokensUpdateEvent(int id, int numberTokens) throws RemoteException;

    /**
     * method that update the view with the start round event
     * @param round of the game at the moment of the call
     * @throws RemoteException
     */
    void remoteStartRoundEvent(int round) throws RemoteException;

    /**
     * method that update the view with the start turn event
     * @param id of the player
     * @param name of the player of the current turn
     * @throws RemoteException
     */
    void remoteStartTurnEvent(int id, String name) throws RemoteException;

    /**
     * method that update the view with the draft pool event
     * @param id of the player
     * @throws RemoteException
     */
    void remoteRollDraftPoolEvent(int id) throws RemoteException;

    /**
     * method that update the view with the draft pool update event
     * @param draftPool of the game at the moment of the call
     * @throws RemoteException
     */
    void remotePlayerDraftPoolUpdateEvent(DraftPool draftPool) throws RemoteException;

    /**
     * method that update the view with the start choose event
     * @param id of the player
     * @throws RemoteException
     */
    void remoteStartChooseEvent(int id) throws RemoteException;

    /**
     * method that update the view with the start move event
     * @param id of the player
     * @param poolSize of the draft pool at the moment of the call
     * @throws RemoteException
     */
    void remoteStartMoveEvent(int id, int poolSize) throws RemoteException;

    /**
     * method that update the view with the pattern update event
     * @param id of the player
     * @param patternCard of the player at the moment of the call
     * @param name of the player
     * @throws RemoteException
     */
    void remotePatternUpdateEvent(int id, PatternCard patternCard, String name) throws RemoteException;

    /**
     * method that update the view with the round tracker update event
     * @param roundTracker of the game at the moment of the call
     * @throws RemoteException
     */
    void remoteRoundTrackerUpdateEvent(RoundTracker roundTracker) throws RemoteException;

    /**
     * method that update the view with the turn pattern event
     * @param id of the player
     * @param patternCard of the player at the moment of the call
     * @throws RemoteException
     */
    void remoteTurnPatternEvent(int id, PatternCard patternCard) throws RemoteException;

    /**
     * method that update the view with the start tool event
     * @param id of the player
     * @param toolCards list of the game at the moment of the call
     * @throws RemoteException
     */
    void remoteStartToolEvent(int id, List<ToolCard> toolCards) throws RemoteException;

    /**
     * method that update the view with the out of token event
     * @param id of the player
     * @throws RemoteException
     */
    void remoteOutOfTokenEvent(int id) throws RemoteException;

    /**
     * method that update the view with the player points event
     * @param playerList of the game at the moment of the call
     * @param ended state of the game
     * @throws RemoteException
     */
    void remotePlayerPointsUpdateEvent(List<Player> playerList,boolean ended) throws RemoteException;

    /**
     * method that update the view with the winner event
     * @param id of the player winner
     * @throws RemoteException
     */
    void remoteWinnerEvent(int id) throws RemoteException;

    /**
     * method that update the view with the timer ended event
     * @param id of the player
     * @throws RemoteException
     */
    void remoteTimerEndedEvent(int id) throws RemoteException;

    /**
     * method that update the view with the other timer ended event
     * @param name of the player
     * @throws RemoteException
     */
    void remoteTimerOtherEvent(String name) throws RemoteException;

    /**
     * method that update the view with the tool card list event
     * @param toolCards list of the game at the moment of the call
     * @throws RemoteException
     */
    void remoteToolCardUpdateEvent(List<ToolCard> toolCards) throws RemoteException;

    /**
     * method that update the view with the grozing pliers tool card request
     * @param id of the player
     * @param poolSize of the game at the moment of the call
     * @throws RemoteException
     */
    void remoteGrozingPliersRequestEvent(int id, int poolSize) throws RemoteException;

    /**
     * method that update the view with the eglomise brush tool card request
     * @param id of the player
     * @throws RemoteException
     */
    void remoteEglomiseBrushRequestEvent(int id) throws RemoteException;

    /**
     * method that update the view with the copper foil tool card request
     * @param id of the player
     * @throws RemoteException
     */
    void remoteCopperFoilRequestEvent(int id) throws RemoteException;

    /**
     * method that update the view with the lathekin tool card request
     * @param id of the player
     * @throws RemoteException
     */
    void remoteLathekinRequestEvent(int id) throws RemoteException;

    /**
     * method that update the view with the lens cutter tool card request
     * @param id of the player
     * @param poolSize of the game at the moment of the call
     * @param roundSizes of the game at the moment of the call
     * @throws RemoteException
     */
    void remoteLensCutterRequestEvent(int id, int poolSize, List<Integer> roundSizes) throws RemoteException;

    /**
     * method that update the view with the flux brush tool card request
     * @param id of the player
     * @param poolSize of the game at the moment of the call
     * @throws RemoteException
     */
    void remoteFluxBrushRequesEvent(int id, int poolSize) throws RemoteException;

    /**
     * method that update the view with the glazing hammer tool card request
     * @param id of the player
     * @throws RemoteException
     */
    void remoteGlazingHammerRequestEvent(int id) throws RemoteException;

    /**
     * method that update the view with the running pliers tool card request
     * @param id of the player
     * @param poolSize of the game at the moment of the call
     * @throws RemoteException
     */
    void remoteRunningPliersRequestEvent(int id, int poolSize) throws RemoteException;

    /**
     * method that update the view with the cork backed tool card request
     * @param id of the player
     * @param poolSize of the game at the moment of the call
     * @throws RemoteException
     */
    void remoteCorkBackedRequestEvent(int id, int poolSize) throws RemoteException;

    /**
     * method that update the view with the grinding stone tool card request
     * @param id of the player
     * @param poolSize of the game at the moment of the call
     * @throws RemoteException
     */
    void remoteGrindingStoneRequestEvent(int id, int poolSize) throws RemoteException;

    /**
     * method that update the view with the flux remover tool card request
     * @param id of the player
     * @param color of the dice
     * @param poolSize of the game at the moment of the call
     * @throws RemoteException
     */
    void remoteFluxRemoverRequestEvent(int id, DiceColor color, int poolSize) throws RemoteException;

    /**
     * method that update the view with the tap wheel tool card request
     * @param id of the player
     * @throws RemoteException
     */
    void remoteTapWheelRequestEvent(int id) throws RemoteException;

    /**
     * method that update the view with the update board event
     * @param roundTracker of the game at the moment of the call
     * @param draftPool of the game at the moment of the call
     * @throws RemoteException
     */
    void remoteUpdateBoardEvent(RoundTracker roundTracker, DraftPool draftPool) throws RemoteException;

    /**
     * method that update the view with the invalid move event
     * @param id of the player
     * @param errorMsg of the game
     * @throws RemoteException
     */
    void remoteInvalidMoveEvent(int id, String errorMsg) throws RemoteException;

    /**
     * method that update the view with the update draft pool event
     * @param draftPool of the game at the moment of the call
     * @throws RemoteException
     */
    void remoteUpdatePoolEvent(DraftPool draftPool) throws RemoteException;

    /**
     * method that update the view with the tool number request event
     * @throws RemoteException
     */
    void remoteToolNumberRequestEvent() throws RemoteException;

    /**
     * method that update the view with the private list event
     * @param privateList of the game at the moment of the call
     * @throws RemoteException
     */
    void remoteSinglePrivateEvent(List<PrivateObjectiveCard> privateList) throws RemoteException;

    /**
     * method that update the view with the end of single player event
     * @param winner state of the game
     * @param playerPoint of the player
     * @param threshold to reach to win
     * @throws RemoteException
     */
    void remoteEndSinglePlayerEvent(boolean winner, int playerPoint, int threshold) throws RemoteException;

    /**
     * method that update the view with the start tool single player event
     * @param toolCards list of the game at the moment of the call
     * @param poolSize of the game at the moment of the call
     * @throws RemoteException
     */
    void remoteStartToolSinglePlayer(List<ToolCard> toolCards, int poolSize) throws RemoteException;

    /**
     * method that update the view with the not match color event
     * @throws RemoteException
     */
    void remoteNotMatchColorEvent() throws RemoteException;

    //-------------------------disconection----------------------------------------------------------------

    /**
     * method that update the view with the max player login event
     * @throws RemoteException
     */
    void remoteMaxPlayerLogin() throws RemoteException;

    /**
     * method that update the view with the exit player event
     * @param name of the player
     * @throws RemoteException
     */
    void remoteExitPlayer(String name) throws RemoteException;

    /**
     * method that update the view with the reconnect player event
     * @param name of the player
     * @throws RemoteException
     */
    void remoteReconnectPlayer(String name) throws RemoteException;

    /**
     * method that update the view with the not permitted reconnection event
     * @throws RemoteException
     */
    void remoteNotPermittedReconnection() throws RemoteException;

    /**
     * method that update the view with the remote successful reconnection event
     * @param currPlayer of the game
     * @param singlePlay mode game
     * @param gameStart state of the game
     * @param tool list of the game
     * @param publicCard list of the game
     * @param players in the game
     * @throws RemoteException
     */
    void remoteSuccessfulReconnection(Player currPlayer,boolean singlePlay, boolean gameStart, List<ToolCard> tool, List<PublicObjectiveCard> publicCard, List<Player> players) throws RemoteException;

}
