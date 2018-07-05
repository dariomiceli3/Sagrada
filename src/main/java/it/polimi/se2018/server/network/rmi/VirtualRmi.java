package it.polimi.se2018.server.network.rmi;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import it.polimi.se2018.client.network.rmi.RmiClientInterface;
import it.polimi.se2018.server.network.Server;
import it.polimi.se2018.server.network.VirtualView;
import it.polimi.se2018.events.clientserver.DisconnectionEvent;
import it.polimi.se2018.events.clientserver.ReconnectionEvent;
import it.polimi.se2018.events.Event;
import it.polimi.se2018.events.InvalidMoveEvent;
import it.polimi.se2018.events.serverclient.controllerview.*;
import it.polimi.se2018.events.serverclient.modelview.*;
import it.polimi.se2018.events.singleplayer.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

/**
 * Class VirtualSocket: the class is a subclass of the Virtual View, so it implements the same features, but it's
 * responsible to effectively manage the communication with the rmi technology. The class runs a timeout timer for
 * the rmi client disconnection, it's responsible to send the event of the remote client method call directly
 * to the controller and of calling the remote method on the skeleton of the client
 * @see it.polimi.se2018.server.network.VirtualView
 * @author fadda-miceli-mundo
 */
public class VirtualRmi extends VirtualView {

    private final Logger log = Logger.getLogger(VirtualRmi.class.getName());
    private Server server;
    private RmiClientInterface clientRmi;
    private boolean running;
    private Timer timer;
    private final int TIMEKEEPER;

    /**
     * Class constructor for a new Virtual rmi associated with a unique id, that runs on the Server and associated with
     * the rmi client interfare to call the remote method, it also load from a settings file the timeout of the rmi player
     * for the disconnection
     * @param clientRmi for the remote call
     * @param server where te virtual rmi is running
     * @param id the unique id associated
     */
    public VirtualRmi(RmiClientInterface clientRmi, Server server, int id) {
        super(id);
        this.server = server;
        this.running = true;
        this.clientRmi = clientRmi;
        sendEvent(new PlayerIDEvent(this.playerID));
        log.info("Send rmi id to the player " + this.playerID);
        sendEvent(new SinglePlayerRequestEvent(this.playerID));

        Gson gson = new Gson();
        InputStream fileStream = VirtualRmi.class.getResourceAsStream("/json/settings" + ".json");
        JsonObject jsonObject = gson.fromJson(new JsonReader(new InputStreamReader(fileStream)), JsonObject.class);
        TIMEKEEPER = jsonObject.get("timeoutPlayer").getAsInt();

    }

    /**
     * method that provide the caller of the current state of the virtual rmi
     * @return a boolean that represents the state
     */
    private boolean isRunning() {
        return running;
    }


    /**
     * method used to send the notification to the controller of the user input (Observable)
     * @param event to send to the controller
     */
    void sendEventController(Event event) {

        if (event instanceof SinglePlayerEvent) {

            if (!server.isGameStarted()) {

                if (!(((SinglePlayerEvent) event).isSinglePlayer())) {
                    Server.setSinglePlayer(false);
                } else if (((SinglePlayerEvent) event).isSinglePlayer() && Server.getMulti() == 0) {
                    Server.setSinglePlayer(true);
                } else {
                    log.info("client rmi in start multi as single tried to connect");
                    this.server.getRmiGatherer().getServerRmi().getClientsRmi().remove(this);
                    this.server.removeClient(this);
                    this.running = false;
                }
            }

            if (server.checkNumberPlayer()) {

                if (server.isGameStarted()) {
                    log.info("rmi reconnection");
                    this.addObserver(server.getGameController());
                    Server.setMulti(Server.getMulti() + 1);
                    setChanged();
                    notifyObservers(new ReconnectionEvent());
                } else {
                    Server.setMulti(Server.getMulti() + 1);
                    this.server.waitingOtherPlayers();
                }
            } else {
                log.info("extra client rmi tried to connect");
                server.getRmiGatherer().getServerRmi().getClientsRmi().remove(this);
                server.removeClient(this);
                this.running = false;
                try {
                    clientRmi.remoteMaxPlayerLogin();
                } catch (RemoteException e) {
                    log.info("error rmi max player");
                }
            }
        } else {
            setChanged();
            notifyObservers(event);
        }
    }


    // mandare al client -> fare una serie di instanceof con view.metodo della RmiClientImpl

    /**
     * Override of the method of the superclass, the method is responsible of calling the remote method responsible
     * of the event obtained as parameter
     * @param event to send to the client
     */
    @Override
    public void sendEvent(Event event) {

        try {
            if (this.isRunning()) {

                if (event instanceof PlayerIDEvent) {
                    clientRmi.remoteIDEvent(((PlayerIDEvent) event).getPlayerID());
                } else if (event instanceof SinglePlayerRequestEvent) {
                    clientRmi.remoteSinglePlayerEvent(((SinglePlayerRequestEvent) event).getId());
                } else if (event instanceof PlayerNameUpdateEvent) {
                    clientRmi.remotePlayerNameUpdateEvent(((PlayerNameUpdateEvent) event).getID(), ((PlayerNameUpdateEvent) event).getName());
                } else if (event instanceof PlayerNameErrorEvent) {
                    clientRmi.remotePlayerNameErrorEvent(((PlayerNameErrorEvent) event).getId());
                } else if (event instanceof GameStartedEvent) {
                    clientRmi.remoteGameStartedEvent(((GameStartedEvent) event).isStarted());
                } else if (event instanceof PlayerPrivateUpdateEvent) {
                    clientRmi.remotePlayerPrivateUpdateEvent(((PlayerPrivateUpdateEvent) event).getID(), ((PlayerPrivateUpdateEvent) event).getCard());
                } else if (event instanceof StartPatternEvent) {
                    clientRmi.remoteStartPatternEvent(((StartPatternEvent) event).getID(), ((StartPatternEvent) event).getPatternListEvent());
                } else if (event instanceof PublicDrawEvent) {
                    clientRmi.remotePublicDrawEvent(((PublicDrawEvent) event).getCard());
                } else if (event instanceof PlayerPatternUpdateEvent) {
                    clientRmi.remotePlayerPatternUpdateEvent(((PlayerPatternUpdateEvent) event).getID(), ((PlayerPatternUpdateEvent) event).getCard());
                } else if (event instanceof StartGameSceneEvent) {
                    clientRmi.remoteStartGameSceneEvent();
                } else if (event instanceof PlayerTokensUpdateEvent) {
                    clientRmi.remotePlayerTokensUpdateEvent(((PlayerTokensUpdateEvent) event).getID(), ((PlayerTokensUpdateEvent) event).getTokensNumber());
                } else if (event instanceof StartRoundEvent) {
                    clientRmi.remoteStartRoundEvent(((StartRoundEvent) event).getRound());
                } else if (event instanceof StartTurnEvent) {
                    clientRmi.remoteStartTurnEvent(((StartTurnEvent) event).getID(), ((StartTurnEvent) event).getName());
                } else if (event instanceof RollDraftPoolEvent) {
                    clientRmi.remoteRollDraftPoolEvent(((RollDraftPoolEvent) event).getId());
                } else if (event instanceof PlayerDraftPoolUpdateEvent) {
                    clientRmi.remotePlayerDraftPoolUpdateEvent(((PlayerDraftPoolUpdateEvent) event).getDraftPool());
                } else if (event instanceof StartChooseEvent) {
                    clientRmi.remoteStartChooseEvent(((StartChooseEvent) event).getID());
                } else if (event instanceof StartMoveEvent) {
                    clientRmi.remoteStartMoveEvent(((StartMoveEvent) event).getID(), ((StartMoveEvent) event).getPoolSize());
                } else if (event instanceof PatternUpdateEvent) {
                    clientRmi.remotePatternUpdateEvent(((PatternUpdateEvent) event).getID(), ((PatternUpdateEvent) event).getPatternCard(), ((PatternUpdateEvent) event).getName());
                } else if (event instanceof RoundTrackerUpdateEvent) {
                    clientRmi.remoteRoundTrackerUpdateEvent(((RoundTrackerUpdateEvent) event).getRoundTracker());
                } else if (event instanceof TurnPatternEvent) {
                    clientRmi.remoteTurnPatternEvent(((TurnPatternEvent) event).getID(), ((TurnPatternEvent) event).getPatternCard());
                } else if (event instanceof StartToolEvent) {
                    clientRmi.remoteStartToolEvent(((StartToolEvent) event).getId(), ((StartToolEvent) event).getToolCardList());
                } else if (event instanceof OutOfTokenEvent) {
                    clientRmi.remoteOutOfTokenEvent(((OutOfTokenEvent) event).getId());
                } else if (event instanceof PlayerPointsUpdateEvent) {
                    clientRmi.remotePlayerPointsUpdateEvent(((PlayerPointsUpdateEvent) event).getPlayerList(), ((PlayerPointsUpdateEvent) event).isFinish());
                } else if (event instanceof WinnerEvent) {
                    clientRmi.remoteWinnerEvent(((WinnerEvent) event).getID());
                } else if (event instanceof TimerEndedEvent) {
                    clientRmi.remoteTimerEndedEvent(((TimerEndedEvent) event).getId());
                } else if (event instanceof TimerOtherEvent) {
                    clientRmi.remoteTimerOtherEvent(((TimerOtherEvent) event).getName());
                } else if (event instanceof ToolCardUpdateEvent) {
                    clientRmi.remoteToolCardUpdateEvent(((ToolCardUpdateEvent) event).getToolCardList());
                } else if (event instanceof GrozingPliersRequestEvent) {
                    clientRmi.remoteGrozingPliersRequestEvent(((GrozingPliersRequestEvent) event).getId(), ((GrozingPliersRequestEvent) event).getPoolSize());
                } else if (event instanceof EglomiseBrushRequestEvent) {
                    clientRmi.remoteEglomiseBrushRequestEvent(((EglomiseBrushRequestEvent) event).getId());
                } else if (event instanceof CopperFoilRequestEvent) {
                    clientRmi.remoteCopperFoilRequestEvent(((CopperFoilRequestEvent) event).getId());
                } else if (event instanceof LathekinRequestEvent) {
                    clientRmi.remoteLathekinRequestEvent(((LathekinRequestEvent) event).getId());
                } else if (event instanceof LensCutterRequestEvent) {
                    clientRmi.remoteLensCutterRequestEvent(((LensCutterRequestEvent) event).getId(), ((LensCutterRequestEvent) event).getPoolSize(), ((LensCutterRequestEvent) event).getRoundSizes());
                } else if (event instanceof FluxBrushRequestEvent) {
                    clientRmi.remoteFluxBrushRequesEvent(((FluxBrushRequestEvent) event).getId(), ((FluxBrushRequestEvent) event).getPoolSize());
                } else if (event instanceof GlazingHammerRequestEvent) {
                    clientRmi.remoteGlazingHammerRequestEvent(((GlazingHammerRequestEvent) event).getId());
                } else if (event instanceof RunningPliersRequestEvent) {
                    clientRmi.remoteRunningPliersRequestEvent(((RunningPliersRequestEvent) event).getId(), ((RunningPliersRequestEvent) event).getPoolSize());
                } else if (event instanceof CorkBackedRequestEvent) {
                    clientRmi.remoteCorkBackedRequestEvent(((CorkBackedRequestEvent) event).getId(), ((CorkBackedRequestEvent) event).getPoolSize());
                } else if (event instanceof GrindingStoneRequestEvent) {
                    clientRmi.remoteGrindingStoneRequestEvent(((GrindingStoneRequestEvent) event).getId(), ((GrindingStoneRequestEvent) event).getPoolSize());
                } else if (event instanceof FluxRemoverRequestEvent) {
                    clientRmi.remoteFluxRemoverRequestEvent(((FluxRemoverRequestEvent) event).getId(), ((FluxRemoverRequestEvent) event).getDiceColor(), ((FluxRemoverRequestEvent) event).getPoolSize());
                } else if (event instanceof TapWheelRequestEvent) {
                    clientRmi.remoteTapWheelRequestEvent(((TapWheelRequestEvent) event).getId());
                } else if (event instanceof UpdateBoardEvent) {
                    clientRmi.remoteUpdateBoardEvent(((UpdateBoardEvent) event).getRoundTracker(), ((UpdateBoardEvent) event).getDraftPool());
                } else if (event instanceof InvalidMoveEvent) {
                    clientRmi.remoteInvalidMoveEvent(((InvalidMoveEvent) event).getId(), ((InvalidMoveEvent) event).getErrorMsg());
                } else if (event instanceof UpdatePoolEvent) {
                    clientRmi.remoteUpdatePoolEvent(((UpdatePoolEvent) event).getDraftPool());
                }

                //-----------------single player events-------------

                else if (event instanceof ToolNumberRequestEvent) {
                    clientRmi.remoteToolNumberRequestEvent();
                } else if (event instanceof SinglePrivateEvent) {
                    clientRmi.remoteSinglePrivateEvent(((SinglePrivateEvent) event).getPrivateList());
                } else if (event instanceof EndSinglePlayerEvent) {
                    clientRmi.remoteEndSinglePlayerEvent(((EndSinglePlayerEvent) event).isWinner(), ((EndSinglePlayerEvent) event).getPlayerPoints(), ((EndSinglePlayerEvent) event).getGameThreshold());
                } else if (event instanceof StartToolSinglePlayerEvent) {
                    clientRmi.remoteStartToolSinglePlayer(((StartToolSinglePlayerEvent) event).getToolCardList(), ((StartToolSinglePlayerEvent) event).getPoolSize());
                } else if (event instanceof NotMatchColorEvent) {
                    clientRmi.remoteNotMatchColorEvent();
                }

                //-----------------disconnection------------------------------

                else if (event instanceof DisconnectionMsgEvent) {
                    clientRmi.remoteExitPlayer(((DisconnectionMsgEvent) event).getName());
                } else if (event instanceof ReconnectionMsgEvent) {
                    clientRmi.remoteReconnectPlayer(((ReconnectionMsgEvent) event).getName());
                } else if (event instanceof NotPlayerDisconnectedEvent) {
                    clientRmi.remoteNotPermittedReconnection();
                } else if (event instanceof SuccessfulReconnectionEvent) {
                    clientRmi.remoteSuccessfulReconnection(((SuccessfulReconnectionEvent) event).getCurrPlayer(), ((SuccessfulReconnectionEvent) event).isSinglePlayer(), ((SuccessfulReconnectionEvent) event).isGameStarted(), ((SuccessfulReconnectionEvent) event).getToolList(), ((SuccessfulReconnectionEvent) event).getPublicCardList(), ((SuccessfulReconnectionEvent) event).getPlayerList());
                } else {
                    log.info("Not understood the message");
                }

            }
        } catch (IOException e) {
            log.info("Error I/O rmi");
            this.running = false;
        }
    }

    // aggiorna in base alla notify del model e usa send event per chiamare in remoto su client

    /**
     * Override of the built-in method of the Observer class, it's called after a notify of the model, so that the
     * virtual rmi can update after a modification of the model and call the remote method on the client (Observer)
     * @param o the observable
     * @param arg the object of the update
     */
    @Override
    public void update(Observable o, Object arg) {

        if (this.isRunning()) {

            if (arg instanceof Event) {
                sendEvent((Event) arg);
            }
        }
    }

    /**
     * method that runs a new timer for waiting TIMEKEEPER seconds, after that the rmi client is considered disconnected
     * if no ping arrives
     */
    void timeout() {

        if (timer != null) {
            timer.cancel();
        }

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.info("client rmi disconnected");
                disconnectionRmi();
            }
        }, TIMEKEEPER);
    }

    /**
     * method responsible of handling the rmi disconnection of the client, both the case of the disconnection
     * before the game started and the disconnection during the game
     */
    private void disconnectionRmi() {

        log.info("error rmi: " + super.getPlayerID() + "disconnected from the game");

        if (server.getGameController() == null) {
            server.getRmiGatherer().getServerRmi().getClientsRmi().remove(this);
            server.removeClient(this);
            Server.setMulti(Server.getMulti() - 1);
            if (Server.getMulti() == 1) {
                server.endTimerLogin();
            }
        }
        else {
            Server.setMulti(Server.getMulti() - 1);
            sendEventController(new DisconnectionEvent(super.getPlayerID()));
        }

    }

}
