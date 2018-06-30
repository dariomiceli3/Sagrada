package it.polimi.se2018.server.network.rmi;

import it.polimi.se2018.client.network.rmi.RmiClientInterface;
import it.polimi.se2018.server.Server;
import it.polimi.se2018.server.VirtualView;
import it.polimi.se2018.server.model.Events.ClientServer.GrozingPliersEvent;
import it.polimi.se2018.server.model.Events.Event;
import it.polimi.se2018.server.model.Events.InvalidMoveEvent;
import it.polimi.se2018.server.model.Events.ServerClient.ControllerView.*;
import it.polimi.se2018.server.model.Events.ServerClient.ModelView.*;
import it.polimi.se2018.server.model.Events.SinglePlayer.*;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Observable;

public class VirtualRmi extends VirtualView {

    private Server server;
    private RmiClientInterface clientRmi;
    private boolean running;

    public VirtualRmi(RmiClientInterface clientRmi, Server server, int ID) {
        super(ID);
        this.server = server;
        this.running = true;
        this.clientRmi = clientRmi;
        sendEvent(new PlayerIDEvent(this.playerID));
        System.out.println("Send rmi id to the player " + this.playerID);
        sendEvent(new SinglePlayerRequestEvent(this.playerID));

    }

    public boolean isRunning() {
        return running;
    }



    // metodo per inoltrare i messaggi al controller (chiamato dalla RmiServerImpl)
    public void sendEventController(Event event) {

        if (event instanceof SinglePlayerEvent) {
            this.server.setSinglePlayer( ((SinglePlayerEvent)event).isSinglePlayer());
            //Server.setMulti(Server.getMulti() + 1);
            //this.server.waitingOtherPlayers();

            if (server.checkNumberPlayer(this.getPlayerID())) {
                Server.setMulti(Server.getMulti() + 1);
                this.server.waitingOtherPlayers();
            }
            else {
                System.out.println("client rmi extra ha provato a connettersi");
                this.running = false;
                try {
                    clientRmi.remoteMaxPlayerLogin();
                }
                catch (RemoteException e) {
                    System.out.println("error rmi max player");
                }
            }
        }
        else {
            setChanged();
            notifyObservers(event);
        }
    }





    // mandare al client -> fare una serie di instanceof con view.metodo della RmiClientImpl
    @Override
    public void sendEvent(Event event) {

        try {
            if (this.isRunning()) {

                if (event instanceof PlayerIDEvent) {
                    clientRmi.remoteIDEvent(((PlayerIDEvent) event).getPlayerID());
                }

                else if (event instanceof SinglePlayerRequestEvent) {
                    clientRmi.remoteSinglePlayerEvent( ((SinglePlayerRequestEvent) event).getId());

                }
                else if (event instanceof PlayerNameUpdateEvent) {
                    clientRmi.remotePlayerNameUpdateEvent( ((PlayerNameUpdateEvent) event).getID(), ((PlayerNameUpdateEvent) event).getName());
                }

                else if (event instanceof PlayerNameErrorEvent) {
                    clientRmi.remotePlayerNameErrorEvent( ((PlayerNameErrorEvent) event).getId());
                }

                else if (event instanceof GameStartedEvent) {
                    clientRmi.remoteGameStartedEvent( ((GameStartedEvent) event).isStarted());
                }

                else if (event instanceof PlayerPrivateUpdateEvent) {
                    clientRmi.remotePlayerPrivateUpdateEvent( ((PlayerPrivateUpdateEvent) event).getID(), ((PlayerPrivateUpdateEvent) event).getCard());
                }

                else if (event instanceof StartPatternEvent) {
                    clientRmi.remoteStartPatternEvent(((StartPatternEvent) event).getID(), ((StartPatternEvent) event).getPatternListEvent());
                }

                else if (event instanceof PublicDrawEvent) {
                    clientRmi.remotePublicDrawEvent( ((PublicDrawEvent) event).getCard());
                }

                else if (event instanceof PlayerPatternUpdateEvent) {
                    clientRmi.remotePlayerPatternUpdateEvent( ((PlayerPatternUpdateEvent)event).getID(), ((PlayerPatternUpdateEvent)event).getCard() );
                }

                else if (event instanceof StartGameSceneEvent) {
                    clientRmi.remoteStartGameSceneEvent();
                }

                else if (event instanceof PlayerTokensUpdateEvent) {
                    clientRmi.remotePlayerTokensUpdateEvent( ((PlayerTokensUpdateEvent)event).getID(), ((PlayerTokensUpdateEvent)event).getTokensNumber());
                }

                else if (event instanceof StartRoundEvent) {
                    clientRmi.remoteStartRoundEvent( ((StartRoundEvent)event).getRound());
                }

                else if (event instanceof StartTurnEvent) {
                    clientRmi.remoteStartTurnEvent( ((StartTurnEvent)event).getID(), ((StartTurnEvent)event).getName());
                }

                else if (event instanceof RollDraftPoolEvent) {
                    clientRmi.remoteRollDraftPoolEvent( ((RollDraftPoolEvent)event).getId());
                }
                else if (event instanceof PlayerDraftPoolUpdateEvent) {
                    clientRmi.remotePlayerDraftPoolUpdateEvent( ((PlayerDraftPoolUpdateEvent)event).getDraftPool());
                }

                else if(event instanceof StartChooseEvent){
                    clientRmi.remoteStartChooseEvent( ((StartChooseEvent)event).getID());
                }

                else if (event instanceof StartMoveEvent) {
                    clientRmi.remoteStartMoveEvent( ((StartMoveEvent)event).getID(), ((StartMoveEvent) event).getPoolSize());
                }

                else if (event instanceof PatternUpdateEvent) {
                    clientRmi.remotePatternUpdateEvent(((PatternUpdateEvent)event).getID(), ((PatternUpdateEvent)event).getPatternCard(), ((PatternUpdateEvent)event).getName());
                }

                else if (event instanceof RoundTrackerUpdateEvent) {
                    clientRmi.remoteRoundTrackerUpdateEvent(((RoundTrackerUpdateEvent) event).getRoundTracker());
                }

                else if (event instanceof TurnPatternEvent) {
                    clientRmi.remoteTurnPatternEvent(((TurnPatternEvent)event).getID(), ((TurnPatternEvent)event).getPatternCard());
                }

                else if (event instanceof StartToolEvent) {
                    clientRmi.remoteStartToolEvent( ((StartToolEvent)event).getId(), ((StartToolEvent)event).getToolCardList());
                }

                else if (event instanceof OutOfTokenEvent) {
                    clientRmi.remoteOutOfTokenEvent( ((OutOfTokenEvent)event).getId());
                }

                else if (event instanceof PlayerPointsUpdateEvent) {
                    clientRmi.remotePlayerPointsUpdateEvent( ((PlayerPointsUpdateEvent) event).getPlayerList());
                }

                else if (event instanceof WinnerEvent) {
                    clientRmi.remoteWinnerEvent(((WinnerEvent)event).getID());
                }

                else if (event instanceof TimerEndedEvent) {
                    clientRmi.remoteTimerEndedEvent(((TimerEndedEvent)event).getId());
                }

                else if (event instanceof TimerOtherEvent) {
                    clientRmi.remoteTimerOtherEvent( ((TimerOtherEvent)event).getName());
                }

                else if (event instanceof ToolCardUpdateEvent) {
                    clientRmi.remoteToolCardUpdateEvent( ((ToolCardUpdateEvent) event).getToolCardList());
                }

                else if (event instanceof GrozingPliersRequestEvent) {
                    clientRmi.remoteGrozingPliersRequestEvent(((GrozingPliersRequestEvent)event).getId(), ((GrozingPliersRequestEvent)event).getPoolSize());
                }

                else if (event instanceof EglomiseBrushRequestEvent) {
                    clientRmi.remoteEglomiseBrushRequestEvent(((EglomiseBrushRequestEvent)event).getId());
                }

                else if (event instanceof CopperFoilRequestEvent) {
                    clientRmi.remoteCopperFoilRequestEvent( ((CopperFoilRequestEvent)event).getId());
                }

                else if (event instanceof LathekinRequestEvent) {
                    clientRmi.remoteLathekinRequestEvent( ((LathekinRequestEvent) event).getId());
                }

                else if (event instanceof LensCutterRequestEvent) {
                    clientRmi.remoteLensCutterRequestEvent( ((LensCutterRequestEvent)event).getId(), ((LensCutterRequestEvent)event).getPoolSize(), ((LensCutterRequestEvent)event).getRoundSizes());
                }

                else if (event instanceof FluxBrushRequestEvent) {
                    clientRmi.remoteFluxBrushRequesEvent( ((FluxBrushRequestEvent)event).getId(), ((FluxRemoverRequestEvent)event).getPoolSize());
                }

                else if (event instanceof GlazingHammerRequestEvent) {
                    clientRmi.remoteGlazingHammerRequestEvent( ((GlazingHammerRequestEvent)event).getId());
                }

                else if (event instanceof RunningPliersRequestEvent) {
                    clientRmi.remoteRunningPliersRequestEvent( ((RunningPliersRequestEvent)event).getId(), ((RunningPliersRequestEvent)event).getPoolSize());
                }

                else if (event instanceof CorkBackedRequestEvent) {
                    clientRmi.remoteCorkBackedRequestEvent(((CorkBackedRequestEvent)event).getId(), ((CorkBackedRequestEvent)event).getPoolSize());
                }

                else if (event instanceof GrindingStoneRequestEvent) {
                    clientRmi.remoteGrindingStoneRequestEvent(((GrindingStoneRequestEvent)event).getId(), ((GrindingStoneRequestEvent)event).getPoolSize());

                }
                else if (event instanceof FluxRemoverRequestEvent) {
                    clientRmi.remoteFluxRemoverRequestEvent(((FluxRemoverRequestEvent)event).getId(), ((FluxRemoverRequestEvent)event).getDiceColor(), ((FluxRemoverRequestEvent)event).getPoolSize());
                }

                else if (event instanceof TapWheelRequestEvent) {
                    clientRmi.remoteTapWheelRequestEvent( ((TapWheelRequestEvent)event).getId());
                }

                else if (event instanceof UpdateBoardEvent) {
                    clientRmi.remoteUpdateBoardEvent( ((UpdateBoardEvent)event).getRoundTracker(), ((UpdateBoardEvent)event).getDraftPool());
                }

                else if (event instanceof InvalidMoveEvent) {
                    clientRmi.remoteInvalidMoveEvent(((InvalidMoveEvent)event).getId(), ((InvalidMoveEvent)event).getErrorMsg());
                }

                else if (event instanceof UpdatePoolEvent) {
                    clientRmi.remoteUpdatePoolEvent(((UpdatePoolEvent)event).getDraftPool());
                }

                //-----------------single player events-------------

                else if (event instanceof ToolNumberRequestEvent) {
                    clientRmi.remoteToolNumberRequestEvent();
                }

                else if (event instanceof SinglePrivateEvent) {
                    clientRmi.remoteSinglePrivateEvent( ((SinglePrivateEvent)event).getPrivateList());
                }

                else if (event instanceof EndSinglePlayerEvent){
                    clientRmi.remoteEndSinglePlayerEvent(((EndSinglePlayerEvent)event).isWinner(), ((EndSinglePlayerEvent) event).getPlayerPoints(), ((EndSinglePlayerEvent)event).getGameThreshold());
                }

                else if (event instanceof StartToolSinglePlayerEvent) {
                    clientRmi.remoteStartToolSinglePlayer( ((StartToolSinglePlayerEvent)event).getToolCardList(), ((StartToolSinglePlayerEvent)event).getPoolSize());
                }

                else if (event instanceof NotMatchColorEvent) {
                    clientRmi.remoteNotMatchColorEvent();
                }
                else if (event instanceof DisconnectionMsgEvent ) {
                    clientRmi.remoteExitPlayer( ((DisconnectionMsgEvent)event).getName());
                }
                else if (event instanceof ReconnectionMsgEvent) {
                    clientRmi.remoteReconnectPlayer( ((ReconnectionMsgEvent)event).getName());
                }
                else {
                    System.out.println("Not understood the message");
                }

            }
        }
        catch (IOException e) {
            System.out.println("Error i/O rmi");
            this.running = false;

        }



    }

    // aggiorna in base alla notify del model e usa send event per chiamare in remoto su client
    @Override
    public void update(Observable o, Object arg) {

        if (this.isRunning()) {

            if (arg instanceof Event) {
                sendEvent((Event) arg);
            }

        }

    }

}
