package it.polimi.se2018.TestController;

import it.polimi.se2018.server.VirtualView;
import it.polimi.se2018.server.controller.Game;
import it.polimi.se2018.server.model.Components.Model;
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

import static org.junit.Assert.assertEquals;

public class TestView {




    public VirtualView createView(int playerID){

        return (new VirtualView(playerID) {
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
            }

            @Override
            public void update(Observable o, Object arg) {

            }
        });
    }

    @Test
    public void testName(){


        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        viewList.add(createView(1));
        Model model = new Model();
        Game game = new Game(viewList, false, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        viewList.get(1).sendEvent(new PlayerNameEvent("Michele", 1));
        assertEquals("Luigi", model.getPlayerFromID(0).getPlayerName());
        assertEquals("Michele",model.getPlayerFromID(1).getPlayerName());



    }



}
