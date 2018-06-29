package it.polimi.se2018.TestController;

import it.polimi.se2018.server.VirtualView;
import it.polimi.se2018.server.controller.Game;
import it.polimi.se2018.server.model.Events.ClientServer.*;
import it.polimi.se2018.server.model.Events.Event;
import it.polimi.se2018.server.model.Events.InvalidMoveEvent;
import it.polimi.se2018.server.model.Events.ServerClient.ControllerView.*;
import it.polimi.se2018.server.model.Events.ServerClient.ModelView.*;
import it.polimi.se2018.server.model.Events.SinglePlayer.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class ViewTest extends VirtualView {

    public List<VirtualView> viewList;

    public Game game;

    public ViewTest(int playerID) {
        super(playerID);
    }

    @Override
                public void update(Observable o, Object arg) {

                    // autoaticamente chiamata dalla notify del model
                    // eventi sono dentro la readEvent del sockethandler che arrivano dal model

                    if (arg instanceof PlayerNameUpdateEvent ) {

                    }
                    if (arg instanceof PlayerPrivateUpdateEvent) {

                    }
                    if (arg instanceof PublicDrawEvent) {

                    }
                    if (arg instanceof PlayerPatternUpdateEvent) {

                    }
                    if (arg instanceof PlayerTokensUpdateEvent) {

                    }
                    if (arg instanceof PlayerDraftPoolUpdateEvent) {

                    }
                    if (arg instanceof PatternUpdateEvent) {

                    }
                    if (arg instanceof RoundTrackerUpdateEvent) {

                    }
                    if (arg instanceof PlayerPointsUpdateEvent) {

                    }
                    if (arg instanceof UpdatePoolEvent) {

                    }
                    if (arg instanceof UpdateBoardEvent) {

                    }
                    if (arg instanceof SinglePrivateEvent) {

                    }

                }



                @Override
                public void sendEvent(Event event) {

                    //-----eventi mandati al controller

                    if (event instanceof SinglePlayerEvent) {
                        setChanged();
                        notifyObservers(event);
                    }
                    if (event instanceof PlayerNameEvent) {
                        setChanged();
                        notifyObservers(event);
                    }
                    if (event instanceof PlayerPatternEvent) {
                        setChanged();
                        notifyObservers(event);
                    }
                    if (event instanceof PlayerDraftPoolEvent) {
                        setChanged();
                        notifyObservers(event);
                    }
                    if (event instanceof PlayerChooseEvent) {
                        setChanged();
                        notifyObservers(event);
                    }
                    if (event instanceof PlayerMoveEvent) {
                        setChanged();
                        notifyObservers(event);
                    }
                    if (event instanceof PlayerStartToolEvent) {
                        setChanged();
                        notifyObservers(event);
                    }
                    if (event instanceof PlayerNextTurnEvent) {
                        setChanged();
                        notifyObservers(event);
                    }
                    if (event instanceof PlayerNoTokenEvent) {
                        setChanged();
                        notifyObservers(event);
                    }
                    if (event instanceof ToolCardStartEvent) {
                        setChanged();
                        notifyObservers(event);
                    }
                    if (event instanceof GrozingPliersEvent) {
                        setChanged();
                        notifyObservers(event);
                    }
                    if (event instanceof EglomiseBrushEvent) {
                        setChanged();
                        notifyObservers(event);
                    }
                    if (event instanceof CopperFoilEvent) {
                        setChanged();
                        notifyObservers(event);
                    }
                    if (event instanceof LathekinEvent) {
                        setChanged();
                        notifyObservers(event);
                    }
                    if (event instanceof LensCutterEvent) {
                        setChanged();
                        notifyObservers(event);
                    }
                    if (event instanceof FluxBrushEvent) {
                        setChanged();
                        notifyObservers(event);
                    }
                    if (event instanceof GlazingHammerEvent) {
                        setChanged();
                        notifyObservers(event);
                    }
                    if (event instanceof RunningPliersEvent) {
                        setChanged();
                        notifyObservers(event);
                    }
                    if (event instanceof CorkBackedEvent) {
                        setChanged();
                        notifyObservers(event);
                    }
                    if (event instanceof GrindingStoneEvent) {
                        setChanged();
                        notifyObservers(event);
                    }
                    if (event instanceof FluxRemoverEvent) {
                        setChanged();
                        notifyObservers(event);
                    }
                    if (event instanceof TapWheelEvent) {
                        setChanged();
                        notifyObservers(event);
                    }
                    if (event instanceof EndGameTimerEvent) {
                        setChanged();
                        notifyObservers(event);
                    }
                    if (event instanceof ToolNumberEvent) {
                        setChanged();
                        notifyObservers(event);
                    }
                    if (event instanceof ToolCardSinglePlayerStartEvent) {
                        setChanged();
                        notifyObservers(event);
                    }
                    if (event instanceof CustomPatternEvent) {
                        setChanged();
                        notifyObservers(event);
                    }


                    //------eventi che ti arrivano dal controller
                    // PlayerIDEvent e SinglePlayerRequestEvent partono dalla virtualsocket/rmi

                    if (event instanceof PlayerNameErrorEvent) {

                    }
                    if (event instanceof GameStartedEvent) {


                    }
                    if (event instanceof StartPatternEvent) {


                    }
                    if (event instanceof StartGameSceneEvent) {


                    }
                    if (event instanceof StartRoundEvent) {


                    }
                    if (event instanceof StartTurnEvent) {


                    }
                    if (event instanceof RollDraftPoolEvent) {


                    }
                    if (event instanceof StartChooseEvent) {


                    }
                    if (event instanceof StartMoveEvent) {


                    }
                    if (event instanceof TurnPatternEvent) {


                    }
                    if (event instanceof StartToolEvent) {


                    }
                    if (event instanceof OutOfTokenEvent) {


                    }
                    if (event instanceof WinnerEvent) {


                    }
                    if (event instanceof TimerEndedEvent) {


                    }
                    if (event instanceof TimerOtherEvent) {


                    }
                    if (event instanceof ToolCardUpdateEvent) {


                    }
                    if (event instanceof GrozingPliersRequestEvent) {


                    }
                    if (event instanceof EglomiseBrushRequestEvent) {


                    }
                    if (event instanceof CopperFoilRequestEvent) {


                    }
                    if (event instanceof LathekinRequestEvent) {


                    }
                    if (event instanceof LensCutterRequestEvent) {


                    }
                    if (event instanceof FluxBrushRequestEvent) {


                    }
                    if (event instanceof GlazingHammerRequestEvent) {


                    }
                    if (event instanceof RunningPliersRequestEvent) {


                    }
                    if (event instanceof CorkBackedRequestEvent) {


                    }
                    if (event instanceof GrindingStoneRequestEvent) {


                    }
                    if (event instanceof FluxRemoverRequestEvent) {


                    }
                    if (event instanceof TapWheelRequestEvent) {


                    }
                    if (event instanceof InvalidMoveEvent) {


                    }
                    if (event instanceof ToolNumberRequestEvent) {


                    }
                    if (event instanceof EndSinglePlayerEvent) {


                    }
                    if (event instanceof StartToolSinglePlayerEvent) {


                    }
                    if (event instanceof NotMatchColorEvent) {


                    }



                }

    @Test
    public void test(){




    }



}
