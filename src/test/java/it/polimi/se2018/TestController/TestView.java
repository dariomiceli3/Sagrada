package it.polimi.se2018.TestController;

import it.polimi.se2018.exceptions.InvalidMoveException;
import it.polimi.se2018.server.network.VirtualView;
import it.polimi.se2018.server.controller.Game;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Components.Dice;
import it.polimi.se2018.server.model.Components.DiceColor;
import it.polimi.se2018.server.model.Components.Model;
import it.polimi.se2018.events.ClientServer.*;
import it.polimi.se2018.events.Event;
import it.polimi.se2018.events.SinglePlayer.*;
import org.junit.Test;

import java.io.FileNotFoundException;
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

                if (event instanceof ExitEvent) {
                    setChanged();
                    notifyObservers(event);
                }
                if (event instanceof ReconnectPlayerEvent){
                    setChanged();
                    notifyObservers(event);
                }
                if (event instanceof DisconnectionEvent) {
                    setChanged();
                    notifyObservers(event);
                }
                if (event instanceof ReconnectionEvent) {
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
        viewList.add(createView(2));
        Model model = new Model();
        Game game = new Game(viewList, false, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        viewList.get(1).sendEvent(new PlayerNameEvent("Michele", 1));
        viewList.get(1).sendEvent(new PlayerNameEvent("Michele", 2));
        assertEquals("Luigi", model.getPlayerFromID(0).getPlayerName());
        assertEquals("Michele",model.getPlayerFromID(1).getPlayerName());
        Game game1 = new Game(viewList,false);

    }

    @Test
    public void testPattern() {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        viewList.add(createView(1));
        Model model = new Model();
        Game game = new Game(viewList, false, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        viewList.get(1).sendEvent(new PlayerNameEvent("Michele", 1));

        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(1).sendEvent(new PlayerPatternEvent(1, 2));
        //assertEquals("Kaleidoscopic Dream", model.getPlayerFromID(0).getPattern());
        //assertEquals("Virtus",model.getPlayerFromID(1).getPattern());
    }

    @Test
    public void testDraftPool() {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        viewList.add(createView(1));
        Model model = new Model();
        Game game = new Game(viewList, false, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        viewList.get(1).sendEvent(new PlayerNameEvent("Michele", 1));

        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(1).sendEvent(new PlayerPatternEvent(1, 2));
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(1).sendEvent(new PlayerDraftPoolEvent());
    }

    @Test
    public void testPlayerMove() {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        viewList.add(createView(1));
        Model model = new Model();
        Game game = new Game(viewList, false, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        viewList.get(1).sendEvent(new PlayerNameEvent("Michele", 1));

        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(1).sendEvent(new PlayerPatternEvent(1, 2));
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(1).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerMoveEvent(0,1));
        viewList.get(1).sendEvent(new PlayerMoveEvent(1,2));
    }

    @Test
    public void testPlayerStartTool() {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        viewList.add(createView(1));
        Model model = new Model();
        Game game = new Game(viewList, false, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        viewList.get(1).sendEvent(new PlayerNameEvent("Michele", 1));

        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(1).sendEvent(new PlayerPatternEvent(1, 2));
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(1).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerMoveEvent(0,1));
        viewList.get(1).sendEvent(new PlayerMoveEvent(1,2));
        viewList.get(0).sendEvent(new PlayerStartToolEvent());
        viewList.get(1).sendEvent(new PlayerStartToolEvent());
    }

    @Test
    public void testPlayerNextTurnEvent() {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        viewList.add(createView(1));
        Model model = new Model();
        Game game = new Game(viewList, false, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        viewList.get(1).sendEvent(new PlayerNameEvent("Michele", 1));

        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(1).sendEvent(new PlayerPatternEvent(1, 2));
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(1).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerMoveEvent(0,1));
        viewList.get(1).sendEvent(new PlayerMoveEvent(1,2));
        viewList.get(0).sendEvent(new PlayerStartToolEvent());
        viewList.get(1).sendEvent(new PlayerStartToolEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
    }

    @Test
    public void testToolCardStartEvent() {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        viewList.add(createView(1));
        Model model = new Model();
        Game game = new Game(viewList, false, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        viewList.get(1).sendEvent(new PlayerNameEvent("Michele", 1));

        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(1).sendEvent(new PlayerPatternEvent(1, 2));
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(1).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerMoveEvent(0,1));
        viewList.get(1).sendEvent(new PlayerMoveEvent(1,2));
        viewList.get(0).sendEvent(new PlayerStartToolEvent());
        viewList.get(1).sendEvent(new PlayerStartToolEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new ToolCardStartEvent(0));
        viewList.get(1).sendEvent(new ToolCardStartEvent(1));
    }

    @Test
    public void testPlayerChooseEvent() {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        viewList.add(createView(1));
        Model model = new Model();
        Game game = new Game(viewList, false, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        viewList.get(1).sendEvent(new PlayerNameEvent("Michele", 1));

        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(1).sendEvent(new PlayerPatternEvent(1, 2));
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(1).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerMoveEvent(0,1));
        viewList.get(1).sendEvent(new PlayerMoveEvent(1,2));
        viewList.get(0).sendEvent(new PlayerStartToolEvent());
        viewList.get(1).sendEvent(new PlayerStartToolEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new ToolCardStartEvent(0));
        viewList.get(1).sendEvent(new ToolCardStartEvent(1));
        viewList.get(0).sendEvent(new PlayerChooseEvent(0));
        viewList.get(1).sendEvent(new PlayerChooseEvent(1));
    }

    @Test
    public void testPlayerNoTokensEvent() {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        viewList.add(createView(1));
        Model model = new Model();
        Game game = new Game(viewList, false, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        viewList.get(1).sendEvent(new PlayerNameEvent("Michele", 1));

        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(1).sendEvent(new PlayerPatternEvent(1, 2));
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(1).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerMoveEvent(0,1));
        viewList.get(1).sendEvent(new PlayerMoveEvent(1,2));
        viewList.get(0).sendEvent(new PlayerNoTokenEvent());
        viewList.get(1).sendEvent(new PlayerNoTokenEvent());
    }

    @Test
    public void testEndGameTimerEvent() {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        viewList.add(createView(1));
        Model model = new Model();
        Game game = new Game(viewList, false, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        viewList.get(1).sendEvent(new PlayerNameEvent("Michele", 1));

        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(1).sendEvent(new PlayerPatternEvent(1, 2));
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(1).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerMoveEvent(0,1));
        viewList.get(1).sendEvent(new PlayerMoveEvent(1,2));
        viewList.get(0).sendEvent(new PlayerNoTokenEvent());
        viewList.get(1).sendEvent(new PlayerNoTokenEvent());
        viewList.get(0).sendEvent(new EndGameTimerEvent());
        viewList.get(1).sendEvent(new EndGameTimerEvent());
    }

    @Test
    public void testCustomPatternEvent() throws FileNotFoundException {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        viewList.add(createView(1));
        Model model = new Model();
        Game game = new Game(viewList, false, model);
        PatternCard patternCard = new PatternCard().loadPatternForTesting();
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        viewList.get(1).sendEvent(new PlayerNameEvent("Michele", 1));


        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(1).sendEvent(new PlayerPatternEvent(1, 2));
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(1).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerMoveEvent(0,1));
        viewList.get(1).sendEvent(new PlayerMoveEvent(1,2));
        viewList.get(0).sendEvent(new PlayerNoTokenEvent());
        viewList.get(1).sendEvent(new PlayerNoTokenEvent());
        viewList.get(0).sendEvent(new CustomPatternEvent(patternCard));
        viewList.get(1).sendEvent(new CustomPatternEvent(patternCard));
    }

    @Test
    public void testExitEvent() throws FileNotFoundException {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        viewList.add(createView(1));
        Model model = new Model();
        Game game = new Game(viewList, false, model);
        PatternCard patternCard = new PatternCard().loadPatternForTesting();
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        viewList.get(1).sendEvent(new PlayerNameEvent("Michele", 1));


        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(1).sendEvent(new PlayerPatternEvent(1, 2));
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(1).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerMoveEvent(0,1));
        viewList.get(1).sendEvent(new PlayerMoveEvent(1,2));
        viewList.get(0).sendEvent(new PlayerNoTokenEvent());
        viewList.get(1).sendEvent(new PlayerNoTokenEvent());
        viewList.get(0).sendEvent(new CustomPatternEvent(patternCard));
        viewList.get(1).sendEvent(new CustomPatternEvent(patternCard));

        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        //viewList.get(1).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        // 2 round
        viewList.get(1).sendEvent(new PlayerDraftPoolEvent());

        viewList.get(1).sendEvent(new ExitEvent(1));
        viewList.get(1).sendEvent(new ReconnectPlayerEvent(1));
        viewList.get(1).sendEvent(new DisconnectionEvent(1));
        viewList.get(1).sendEvent(new ReconnectionEvent());
        //viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        //viewList.get(1).sendEvent(new PlayerNextTurnEvent());

    }

    @Test
    public void testDisconnectionEvent() throws FileNotFoundException {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        viewList.add(createView(1));
        Model model = new Model();
        Game game = new Game(viewList, false, model);
        PatternCard patternCard = new PatternCard().loadPatternForTesting();

        viewList.get(1).sendEvent(new DisconnectionEvent(1));

        //viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        //viewList.get(1).sendEvent(new PlayerNameEvent("Michele", 1));



    }

    @Test
    public void testDisconnectionPatternEvent() throws FileNotFoundException {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        viewList.add(createView(1));
        Model model = new Model();
        Game game = new Game(viewList, false, model);
        PatternCard patternCard = new PatternCard().loadPatternForTesting();

        //viewList.get(1).sendEvent(new DisconnectionEvent(1));

        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        viewList.get(1).sendEvent(new PlayerNameEvent("Michele", 1));

        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(1).sendEvent(new DisconnectionEvent(1));


    }

    @Test
    public void testDisconnectionRollEvent() throws FileNotFoundException {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        viewList.add(createView(1));
        Model model = new Model();
        Game game = new Game(viewList, false, model);
        PatternCard patternCard = new PatternCard().loadPatternForTesting();

        //viewList.get(1).sendEvent(new DisconnectionEvent(1));

        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        viewList.get(1).sendEvent(new PlayerNameEvent("Michele", 1));

        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(1).sendEvent(new PlayerPatternEvent(0, 1));

        viewList.get(0).sendEvent(new DisconnectionEvent(0));


    }

    @Test
    public void testEndMatch() {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        viewList.add(createView(1));
        Model model = new Model();
        Game game = new Game(viewList, false, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        viewList.get(1).sendEvent(new PlayerNameEvent("Michele", 1));

        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(1).sendEvent(new PlayerPatternEvent(1, 2));
        // 1 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        //viewList.get(1).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        // 2 round
        viewList.get(1).sendEvent(new PlayerDraftPoolEvent());

        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());

        // 3 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        //viewList.get(1).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());

        // 4 round
        viewList.get(1).sendEvent(new PlayerDraftPoolEvent());

        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());

        // 5 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        //viewList.get(1).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());

        // 6 round
        viewList.get(1).sendEvent(new PlayerDraftPoolEvent());

        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());

        // 7 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        //viewList.get(1).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());

        // 8 round
        viewList.get(1).sendEvent(new PlayerDraftPoolEvent());

        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());

        // 9 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        //viewList.get(1).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());

        // 10 round
        viewList.get(1).sendEvent(new PlayerDraftPoolEvent());

        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());

        viewList.get(0).getModel().getPlayerFromID(0).setFinalPoints(150);
        viewList.get(0).getModel().getPlayerFromID(0).setPrivatePoints(29);
        viewList.get(0).getModel().getPlayerFromID(0).setTokensNumber(3);

        viewList.get(1).getModel().getPlayerFromID(1).setFinalPoints(150);
        viewList.get(1).getModel().getPlayerFromID(1).setPrivatePoints(30);
        viewList.get(1).getModel().getPlayerFromID(1).setTokensNumber(3);

        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
    }


    @Test
    public void testSingleplayer(){


        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        Model model = new Model();
        Game game = new Game(viewList, true, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        assertEquals("Luigi", model.getPlayerFromID(0).getPlayerName());
    }

    @Test
    public void testToolNumberSingleplayerEvent(){


        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        Model model = new Model();
        Game game = new Game(viewList, true, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        assertEquals("Luigi", model.getPlayerFromID(0).getPlayerName());

        viewList.get(0).sendEvent(new ToolNumberEvent(3));
        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerMoveEvent(0,1));
        viewList.get(0).sendEvent(new PlayerNoTokenEvent());
        viewList.get(0).sendEvent(new EndGameTimerEvent());
    }

    @Test
    public void testToolCardSingleplayerStartEvent() throws FileNotFoundException {


        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        Model model = new Model();
        Game game = new Game(viewList, true, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        assertEquals("Luigi", model.getPlayerFromID(0).getPlayerName());
        PatternCard patternCard = new PatternCard().loadPatternForTesting();

        viewList.get(0).sendEvent(new ToolNumberEvent(3));
        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerMoveEvent(0,1));
        viewList.get(0).sendEvent(new PlayerNoTokenEvent());
        viewList.get(0).sendEvent(new CustomPatternEvent(patternCard));
        viewList.get(0).sendEvent(new EndGameTimerEvent());
        viewList.get(0).sendEvent(new ToolCardSinglePlayerStartEvent(1,0));
    }

    @Test
    public void testEndMatchSinglePlayer() throws FileNotFoundException {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        Model model = new Model();
        Game game = new Game(viewList, true, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        assertEquals("Luigi", model.getPlayerFromID(0).getPlayerName());
        PatternCard patternCard = new PatternCard().loadPatternForTesting();

        viewList.get(0).sendEvent(new ToolNumberEvent(3));
        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerMoveEvent(0,1));
        viewList.get(0).sendEvent(new PlayerNoTokenEvent());
        viewList.get(0).sendEvent(new CustomPatternEvent(patternCard));
        viewList.get(0).sendEvent(new EndGameTimerEvent());
        viewList.get(0).sendEvent(new ToolCardSinglePlayerStartEvent(1,0));

        viewList.get(0).sendEvent(new EndGameTimerEvent());

        // 1 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());

        // 2 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());

        // 3 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());

        // 4 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());

        // 5 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());

        // 6 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());

        // 7 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());

        // 8 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());

        // 9 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());

        // 10 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
    }


    @Test
    public void testGrozingPliers() throws FileNotFoundException {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        viewList.add(createView(1));
        Model model = new Model();
        Game game = new Game(viewList, false, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        viewList.get(1).sendEvent(new PlayerNameEvent("Michele", 1));

        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(1).sendEvent(new PlayerPatternEvent(1, 2));

        PatternCard patternCard = new PatternCard().loadPatternForTesting();

        viewList.get(0).getModel().getPlayerFromID(0).setPattern(patternCard);
        // 1 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        ArrayList<Dice> diceArrayList = new ArrayList<>();
        Dice dice = new Dice(3, DiceColor.RED);
        Dice dice1 = new Dice(4, DiceColor.GREEN);
        Dice dice3 = new Dice(4, DiceColor.YELLOW);
        diceArrayList.add(dice3);
        diceArrayList.add(dice1);
        diceArrayList.add(dice);
        viewList.get(0).getModel().getDraftPool().setDraftPool(diceArrayList);
        viewList.get(0).sendEvent(new GrozingPliersEvent(0,1));
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        //viewList.get(0).sendEvent(new GrozingPliersEvent(1,0));
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
    }

    @Test
    public void testGrozingPliers0() throws FileNotFoundException {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        viewList.add(createView(1));
        Model model = new Model();
        Game game = new Game(viewList, false, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        viewList.get(1).sendEvent(new PlayerNameEvent("Michele", 1));

        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(1).sendEvent(new PlayerPatternEvent(1, 2));

        PatternCard patternCard = new PatternCard().loadPatternForTesting();

        viewList.get(0).getModel().getPlayerFromID(0).setPattern(patternCard);
        // 1 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        ArrayList<Dice> diceArrayList = new ArrayList<>();
        Dice dice = new Dice(3, DiceColor.RED);
        Dice dice1 = new Dice(4, DiceColor.GREEN);
        Dice dice3 = new Dice(4, DiceColor.YELLOW);
        diceArrayList.add(dice3);
        diceArrayList.add(dice1);
        diceArrayList.add(dice);
        viewList.get(0).getModel().getDraftPool().setDraftPool(diceArrayList);
        viewList.get(0).sendEvent(new GrozingPliersEvent(0,0));
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        //viewList.get(0).sendEvent(new GrozingPliersEvent(1,0));
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
    }

    @Test
    public void testEglomiseBrush() throws InvalidMoveException {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        viewList.add(createView(1));
        Model model = new Model();
        Game game = new Game(viewList, false, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        viewList.get(1).sendEvent(new PlayerNameEvent("Michele", 1));
        Dice dice = new Dice(3, DiceColor.RED);


        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(1).sendEvent(new PlayerPatternEvent(1, 2));
        // 1 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());

        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).getModel().getPlayerFromID(0).getPattern().putDiceOnPattern(dice,3,model.getPlayerFromID(0).getPattern());
        viewList.get(0).sendEvent(new EglomiseBrushEvent(3,1));
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
    }



    @Test
    public void testCopperFoil() throws InvalidMoveException, FileNotFoundException {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        viewList.add(createView(1));
        Model model = new Model();
        Game game = new Game(viewList, false, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        viewList.get(1).sendEvent(new PlayerNameEvent("Michele", 1));
        Dice dice = new Dice(3, DiceColor.RED);
        Dice dice1 = new Dice(4, DiceColor.GREEN);

        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(1).sendEvent(new PlayerPatternEvent(1, 2));

        PatternCard patternCard = new PatternCard().loadPatternForTesting();

        viewList.get(0).getModel().getPlayerFromID(0).setPattern(patternCard);
        // 1 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());

        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).getModel().getPlayerFromID(0).getPattern().putDiceOnPattern(dice,3,model.getPlayerFromID(0).getPattern());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).getModel().getPlayerFromID(0).getPattern().putDiceOnPattern(dice1,4,model.getPlayerFromID(0).getPattern());
        viewList.get(0).sendEvent(new CopperFoilEvent(3,3));
    }

    @Test(expected = NullPointerException.class)
    public void testCopperFoilInvalid() throws InvalidMoveException, FileNotFoundException {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        viewList.add(createView(1));
        Model model = new Model();
        Game game = new Game(viewList, false, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        viewList.get(1).sendEvent(new PlayerNameEvent("Michele", 1));
        Dice dice = new Dice(3, DiceColor.RED);
        Dice dice1 = new Dice(4, DiceColor.GREEN);
        viewList.get(0).sendEvent(new CopperFoilEvent(3,3));
        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(1).sendEvent(new PlayerPatternEvent(1, 2));


        PatternCard patternCard = new PatternCard().loadPatternForTesting();

        viewList.get(0).getModel().getPlayerFromID(0).setPattern(patternCard);
        // 1 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());

        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).getModel().getPlayerFromID(0).getPattern().putDiceOnPattern(dice,3,model.getPlayerFromID(0).getPattern());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).getModel().getPlayerFromID(0).getPattern().putDiceOnPattern(dice1,4,model.getPlayerFromID(0).getPattern());
        viewList.get(0).sendEvent(new CopperFoilEvent(3,3));
    }

    @Test
    public void testLathekin() throws InvalidMoveException, FileNotFoundException {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        viewList.add(createView(1));
        Model model = new Model();
        Game game = new Game(viewList, false, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        viewList.get(1).sendEvent(new PlayerNameEvent("Michele", 1));
        Dice dice = new Dice(3, DiceColor.RED);
        Dice dice1 = new Dice(4, DiceColor.GREEN);
        PatternCard patternCard = new PatternCard().loadPatternForTesting();


        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(0).getModel().getPlayerFromID(0).setPattern(patternCard);
        System.out.println(viewList.get(0).getModel().getPlayerFromID(0).getPattern().toString());
        viewList.get(1).sendEvent(new PlayerPatternEvent(1, 2));
        // 1 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());

        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).getModel().getPlayerFromID(0).getPattern().putDiceOnPattern(dice,3,model.getPlayerFromID(0).getPattern());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).getModel().getPlayerFromID(0).getPattern().putDiceOnPattern(dice1,8,model.getPlayerFromID(0).getPattern());
        viewList.get(0).sendEvent(new LathekinEvent(3,7,8,8));
    }

    /*@Test(expected = NullPointerException.class)
    public void testLathekinInvalid1() throws InvalidMoveException, FileNotFoundException {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        viewList.add(createView(1));
        Model model = new Model();
        Game game = new Game(viewList, false, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        viewList.get(1).sendEvent(new PlayerNameEvent("Michele", 1));
        Dice dice = new Dice(3, DiceColor.RED);
        Dice dice1 = new Dice(4, DiceColor.GREEN);
        PatternCard patternCard = new PatternCard().loadPatternForTesting();


        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(0).getModel().getPlayerFromID(0).setPattern(patternCard);
        System.out.println(viewList.get(0).getModel().getPlayerFromID(0).getPattern().toString());
        viewList.get(1).sendEvent(new PlayerPatternEvent(1, 2));
        // 1 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());

        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).getModel().getPlayerFromID(0).getPattern().putDiceOnPattern(dice,3,model.getPlayerFromID(0).getPattern());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).getModel().getPlayerFromID(0).getPattern().putDiceOnPattern(dice1,8,model.getPlayerFromID(0).getPattern());
        viewList.get(0).sendEvent(new LathekinEvent(3,7,8,8));
        viewList.get(0).sendEvent(new LathekinEvent(3,7,8,7));
    }*/

    @Test
    public void testFluxBrush() throws InvalidMoveException, FileNotFoundException {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        viewList.add(createView(1));
        Model model = new Model();
        Game game = new Game(viewList, false, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        viewList.get(1).sendEvent(new PlayerNameEvent("Michele", 1));
        Dice dice = new Dice(3, DiceColor.RED);
        Dice dice1 = new Dice(4, DiceColor.GREEN);
        PatternCard patternCard = new PatternCard().loadPatternForTesting();


        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(0).getModel().getPlayerFromID(0).setPattern(patternCard);
        System.out.println(viewList.get(0).getModel().getPlayerFromID(0).getPattern().toString());
        viewList.get(1).sendEvent(new PlayerPatternEvent(1, 2));
        // 1 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new FluxBrushEvent(0));
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        //viewList.get(0).sendEvent(new FluxBrushEvent(0));
        //viewList.get(0).getModel().getPlayerFromID(0).getPattern().putDiceOnPattern(dice,3,model.getPlayerFromID(0).getPattern());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        //viewList.get(0).getModel().getPlayerFromID(0).getPattern().putDiceOnPattern(dice1,8,model.getPlayerFromID(0).getPattern());
        //viewList.get(0).sendEvent(new LathekinEvent(3,7,8,8));
    }

    @Test
    public void testGlazingHammer() throws InvalidMoveException, FileNotFoundException {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        viewList.add(createView(1));
        Model model = new Model();
        Game game = new Game(viewList, false, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        viewList.get(1).sendEvent(new PlayerNameEvent("Michele", 1));
        Dice dice = new Dice(3, DiceColor.RED);
        Dice dice1 = new Dice(4, DiceColor.GREEN);
        PatternCard patternCard = new PatternCard().loadPatternForTesting();


        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(0).getModel().getPlayerFromID(0).setPattern(patternCard);
        System.out.println(viewList.get(0).getModel().getPlayerFromID(0).getPattern().toString());
        viewList.get(1).sendEvent(new PlayerPatternEvent(1, 2));
        // 1 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());

        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        //viewList.get(0).sendEvent(new GlazingHammerEvent());

        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new GlazingHammerEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());

    }

    @Test
    public void testRunningPliers() throws InvalidMoveException, FileNotFoundException {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        viewList.add(createView(1));
        Model model = new Model();
        Game game = new Game(viewList, false, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        viewList.get(1).sendEvent(new PlayerNameEvent("Michele", 1));
        Dice dice = new Dice(3, DiceColor.RED);
        Dice dice1 = new Dice(4, DiceColor.GREEN);
        PatternCard patternCard = new PatternCard().loadPatternForTesting();


        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(0).getModel().getPlayerFromID(0).setPattern(patternCard);
        System.out.println(viewList.get(0).getModel().getPlayerFromID(0).getPattern().toString());
        viewList.get(1).sendEvent(new PlayerPatternEvent(1, 2));
        // 1 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new RunningPliersEvent(0,0));
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());

    }

    // todo rivedere
    /*@Test(expected = NullPointerException.class)
    public void testRunningPliersInvalid() throws InvalidMoveException, FileNotFoundException {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        viewList.add(createView(1));
        Model model = new Model();
        Game game = new Game(viewList, false, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        viewList.get(1).sendEvent(new PlayerNameEvent("Michele", 1));
        Dice dice = new Dice(3, DiceColor.RED);
        Dice dice1 = new Dice(4, DiceColor.GREEN);
        PatternCard patternCard = new PatternCard().loadPatternForTesting();


        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(0).getModel().getPlayerFromID(0).setPattern(patternCard);
        System.out.println(viewList.get(0).getModel().getPlayerFromID(0).getPattern().toString());
        viewList.get(1).sendEvent(new PlayerPatternEvent(1, 2));
        // 1 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new RunningPliersEvent(0,0));
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new RunningPliersEvent(0,0));
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());


    }*/

    /*@Test
    public void testCorkBacked() throws InvalidMoveException, FileNotFoundException {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        viewList.add(createView(1));
        Model model = new Model();
        Game game = new Game(viewList, false, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        viewList.get(1).sendEvent(new PlayerNameEvent("Michele", 1));
        Dice dice = new Dice(3, DiceColor.RED);
        Dice dice1 = new Dice(4, DiceColor.GREEN);
        PatternCard patternCard = new PatternCard().loadPatternForTesting();

        ArrayList<Dice> diceArrayList = new ArrayList<>();
        Dice dice3 = new Dice(4, DiceColor.YELLOW);
        diceArrayList.add(dice3);
        diceArrayList.add(dice1);
        diceArrayList.add(dice);
        viewList.get(0).getModel().getDraftPool().setDraftPool(diceArrayList);



        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(0).getModel().getPlayerFromID(0).setPattern(patternCard);
        System.out.println(viewList.get(0).getModel().getPlayerFromID(0).getPattern().toString());
        viewList.get(1).sendEvent(new PlayerPatternEvent(1, 2));
        // 1 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).getModel().getDraftPool().setDraftPool(diceArrayList);
        viewList.get(0).getModel().getPlayerFromID(0).getPattern().putDiceOnPattern(dice,0,model.getPlayerFromID(0).getPattern());
        viewList.get(0).sendEvent(new CorkBackedEvent(0,13));
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());

        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        //viewList.get(0).sendEvent(new CorkBackedEvent(0,13));
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());

        viewList.get(1).sendEvent(new PlayerDraftPoolEvent());

        //2 round
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new CorkBackedEvent(0,13));
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());


    }*/


    @Test
    public void testGrindindStone() throws InvalidMoveException, FileNotFoundException {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        viewList.add(createView(1));
        Model model = new Model();
        Game game = new Game(viewList, false, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        viewList.get(1).sendEvent(new PlayerNameEvent("Michele", 1));
        Dice dice = new Dice(3, DiceColor.RED);
        Dice dice1 = new Dice(4, DiceColor.GREEN);
        PatternCard patternCard = new PatternCard().loadPatternForTesting();


        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(0).getModel().getPlayerFromID(0).setPattern(patternCard);
        System.out.println(viewList.get(0).getModel().getPlayerFromID(0).getPattern().toString());
        viewList.get(1).sendEvent(new PlayerPatternEvent(1, 2));
        // 1 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new GrindingStoneEvent(0));
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());

        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());

    }

    /*@Test
    public void testFluxRemover() throws InvalidMoveException, FileNotFoundException {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        viewList.add(createView(1));
        Model model = new Model();
        Game game = new Game(viewList, false, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        viewList.get(1).sendEvent(new PlayerNameEvent("Michele", 1));
        Dice dice = new Dice(3, DiceColor.RED);
        Dice dice1 = new Dice(4, DiceColor.GREEN);
        PatternCard patternCard = new PatternCard().loadPatternForTesting();




        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(0).getModel().getPlayerFromID(0).setPattern(patternCard);
        System.out.println(viewList.get(0).getModel().getPlayerFromID(0).getPattern().toString());
        viewList.get(1).sendEvent(new PlayerPatternEvent(1, 2));
        // 1 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());

        ArrayList<Dice> diceArrayList = new ArrayList<>();
        Dice dice3 = new Dice(4, DiceColor.YELLOW);
        diceArrayList.add(dice3);
        diceArrayList.add(dice1);
        diceArrayList.add(dice);
        viewList.get(0).getModel().getDraftPool().setDraftPool(diceArrayList);
        System.out.println(viewList.get(0).getModel().getDraftPool().toString());
        //viewList.get(0).sendEvent(new FluxRemoverEvent(0,3));
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());

        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new FluxRemoverEvent(0,1));
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());

    }*/

    @Test
    public void testTapWheel() throws InvalidMoveException, FileNotFoundException {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        viewList.add(createView(1));
        Model model = new Model();
        Game game = new Game(viewList, false, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        viewList.get(1).sendEvent(new PlayerNameEvent("Michele", 1));
        Dice dice = new Dice(3, DiceColor.RED);
        Dice dice1 = new Dice(4, DiceColor.GREEN);
        PatternCard patternCard = new PatternCard().loadPatternForTesting();




        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(0).getModel().getPlayerFromID(0).setPattern(patternCard);
        System.out.println(viewList.get(0).getModel().getPlayerFromID(0).getPattern().toString());
        viewList.get(1).sendEvent(new PlayerPatternEvent(1, 2));
        // 1 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());

        ArrayList<Dice> diceArrayList = new ArrayList<>();

        Dice dice3 = new Dice(5, DiceColor.YELLOW);
        diceArrayList.add(dice3);
        diceArrayList.add(dice1);
        diceArrayList.add(dice);
        viewList.get(0).getModel().getDraftPool().setDraftPool(diceArrayList);
        viewList.get(0).getModel().getRoundTracker().setTracker(diceArrayList);

        viewList.get(0).getModel().getPlayerFromID(0).getPattern().putDiceOnPattern(dice,0,model.getPlayerFromID(0).getPattern());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());

        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).getModel().getPlayerFromID(0).getPattern().putDiceOnPattern(dice1,1,model.getPlayerFromID(0).getPattern());
        viewList.get(0).sendEvent(new TapWheelEvent(1,0,2,0,0));
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());

        viewList.get(1).sendEvent(new PlayerDraftPoolEvent());

        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).getModel().getPlayerFromID(0).getPattern().putDiceOnPattern(dice1,3,model.getPlayerFromID(0).getPattern());
        System.out.println(viewList.get(0).getModel().getPlayerFromID(0).getPattern().toString());
        viewList.get(0).sendEvent(new TapWheelEvent(2,1,7,3,3));
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());

    }

    /*@Test(expected = NullPointerException.class)
    public void testTapWheelInvalid() throws InvalidMoveException, FileNotFoundException {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        viewList.add(createView(1));
        Model model = new Model();
        Game game = new Game(viewList, false, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        viewList.get(1).sendEvent(new PlayerNameEvent("Michele", 1));
        Dice dice = new Dice(3, DiceColor.RED);
        Dice dice1 = new Dice(4, DiceColor.GREEN);
        PatternCard patternCard = new PatternCard().loadPatternForTesting();




        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(0).getModel().getPlayerFromID(0).setPattern(patternCard);
        System.out.println(viewList.get(0).getModel().getPlayerFromID(0).getPattern().toString());
        viewList.get(1).sendEvent(new PlayerPatternEvent(1, 2));
        // 1 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());

        ArrayList<Dice> diceArrayList = new ArrayList<>();

        Dice dice3 = new Dice(5, DiceColor.YELLOW);
        diceArrayList.add(dice3);
        diceArrayList.add(dice1);
        diceArrayList.add(dice);
        viewList.get(0).getModel().getDraftPool().setDraftPool(diceArrayList);
        viewList.get(0).getModel().getRoundTracker().setTracker(diceArrayList);
        viewList.get(0).sendEvent(new TapWheelEvent(1,0,2,0,0));

        viewList.get(0).getModel().getPlayerFromID(0).getPattern().putDiceOnPattern(dice,0,model.getPlayerFromID(0).getPattern());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());

        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).getModel().getPlayerFromID(0).getPattern().putDiceOnPattern(dice1,1,model.getPlayerFromID(0).getPattern());
        viewList.get(0).sendEvent(new TapWheelEvent(1,0,2,0,0));
        //viewList.get(0).sendEvent(new TapWheelEvent(1,0,2,0,0));
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());

        viewList.get(1).sendEvent(new PlayerDraftPoolEvent());

        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).getModel().getPlayerFromID(0).getPattern().putDiceOnPattern(dice1,3,model.getPlayerFromID(0).getPattern());
        System.out.println(viewList.get(0).getModel().getPlayerFromID(0).getPattern().toString());
        viewList.get(0).sendEvent(new TapWheelEvent(2,1,7,3,3));
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());

    }*/

    @Test
    public void testLensCutter() throws InvalidMoveException, FileNotFoundException {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        viewList.add(createView(1));
        Model model = new Model();
        Game game = new Game(viewList, false, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        viewList.get(1).sendEvent(new PlayerNameEvent("Michele", 1));
        Dice dice = new Dice(3, DiceColor.RED);
        Dice dice1 = new Dice(4, DiceColor.GREEN);
        PatternCard patternCard = new PatternCard().loadPatternForTesting();




        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(0).getModel().getPlayerFromID(0).setPattern(patternCard);
        System.out.println(viewList.get(0).getModel().getPlayerFromID(0).getPattern().toString());
        viewList.get(1).sendEvent(new PlayerPatternEvent(1, 2));
        // 1 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());

        ArrayList<Dice> diceArrayList = new ArrayList<>();

        Dice dice3 = new Dice(5, DiceColor.YELLOW);
        diceArrayList.add(dice3);
        diceArrayList.add(dice1);
        diceArrayList.add(dice);
        viewList.get(0).getModel().getDraftPool().setDraftPool(diceArrayList);
        viewList.get(0).getModel().getRoundTracker().setTracker(diceArrayList);

        viewList.get(0).sendEvent(new LensCutterEvent(0,0,0));
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());

        viewList.get(1).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());

        viewList.get(0).sendEvent(new PlayerNextTurnEvent());

        viewList.get(1).sendEvent(new PlayerDraftPoolEvent());

        viewList.get(1).sendEvent(new PlayerNextTurnEvent());

        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(1).sendEvent(new PlayerNextTurnEvent());

    }


    @Test
    public void testGrozingPliersSinglePlayer() throws FileNotFoundException {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        Model model = new Model();
        Game game = new Game(viewList, true, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        assertEquals("Luigi", model.getPlayerFromID(0).getPlayerName());
        PatternCard patternCard = new PatternCard().loadPatternForTesting();

        viewList.get(0).sendEvent(new ToolNumberEvent(3));
        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerMoveEvent(0, 1));
        viewList.get(0).sendEvent(new PlayerNoTokenEvent());
        viewList.get(0).sendEvent(new CustomPatternEvent(patternCard));
        viewList.get(0).sendEvent(new EndGameTimerEvent());
        viewList.get(0).sendEvent(new ToolCardSinglePlayerStartEvent(1, 0));

        viewList.get(0).sendEvent(new EndGameTimerEvent());

        // 1 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());

        ArrayList<Dice> diceArrayList = new ArrayList<>();
        Dice dice = new Dice(3, DiceColor.RED);
        Dice dice1 = new Dice(4, DiceColor.GREEN);
        Dice dice3 = new Dice(4, DiceColor.YELLOW);
        diceArrayList.add(dice3);
        diceArrayList.add(dice1);
        diceArrayList.add(dice);
        viewList.get(0).getModel().getDraftPool().setDraftPool(diceArrayList);
        viewList.get(0).sendEvent(new GrozingPliersEvent(0,0));

        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
    }

    @Test
    public void testEglomiseBrushPlayer() throws FileNotFoundException, InvalidMoveException {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        Model model = new Model();
        Game game = new Game(viewList, true, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        assertEquals("Luigi", model.getPlayerFromID(0).getPlayerName());
        PatternCard patternCard = new PatternCard().loadPatternForTesting();
        Dice dice = new Dice(2,DiceColor.RED);

        viewList.get(0).sendEvent(new ToolNumberEvent(3));
        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerMoveEvent(0, 1));
        viewList.get(0).sendEvent(new PlayerNoTokenEvent());
        viewList.get(0).sendEvent(new CustomPatternEvent(patternCard));
        viewList.get(0).sendEvent(new EndGameTimerEvent());
        viewList.get(0).sendEvent(new ToolCardSinglePlayerStartEvent(1, 0));

        viewList.get(0).sendEvent(new EndGameTimerEvent());

        // 1 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());

        viewList.get(0).getModel().getPlayerFromID(0).getPattern().putDiceOnPattern(dice,3,model.getPlayerFromID(0).getPattern());
        viewList.get(0).sendEvent(new EglomiseBrushEvent(3,1));

        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
    }

    @Test
    public void testCopperFoilSinglePlayer() throws FileNotFoundException, InvalidMoveException {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        Model model = new Model();
        Game game = new Game(viewList, true, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        assertEquals("Luigi", model.getPlayerFromID(0).getPlayerName());
        PatternCard patternCard = new PatternCard().loadPatternForTesting();
        Dice dice = new Dice(3, DiceColor.RED);
        Dice dice1 = new Dice(4, DiceColor.GREEN);

        viewList.get(0).sendEvent(new ToolNumberEvent(3));
        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerMoveEvent(0, 1));
        viewList.get(0).sendEvent(new PlayerNoTokenEvent());
        viewList.get(0).sendEvent(new CustomPatternEvent(patternCard));
        viewList.get(0).sendEvent(new EndGameTimerEvent());


        viewList.get(0).getModel().getPlayerFromID(0).setPattern(patternCard);

        viewList.get(0).sendEvent(new EndGameTimerEvent());

        // 1 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());

        viewList.get(0).getModel().getPlayerFromID(0).getPattern().putDiceOnPattern(dice,3,model.getPlayerFromID(0).getPattern());

        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).getModel().getPlayerFromID(0).getPattern().putDiceOnPattern(dice1,4,model.getPlayerFromID(0).getPattern());
        viewList.get(0).sendEvent(new CopperFoilEvent(3,3));
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());

    }

    @Test
    public void testLathekinSinglePlayer() throws FileNotFoundException, InvalidMoveException {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        Model model = new Model();
        Game game = new Game(viewList, true, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        assertEquals("Luigi", model.getPlayerFromID(0).getPlayerName());
        PatternCard patternCard = new PatternCard().loadPatternForTesting();
        Dice dice = new Dice(3, DiceColor.RED);
        Dice dice1 = new Dice(4, DiceColor.GREEN);

        viewList.get(0).sendEvent(new ToolNumberEvent(3));
        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerMoveEvent(0, 1));
        viewList.get(0).sendEvent(new PlayerNoTokenEvent());
        viewList.get(0).sendEvent(new CustomPatternEvent(patternCard));
        viewList.get(0).sendEvent(new EndGameTimerEvent());


        viewList.get(0).getModel().getPlayerFromID(0).setPattern(patternCard);

        viewList.get(0).sendEvent(new EndGameTimerEvent());

        // 1 round
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());

        viewList.get(0).getModel().getPlayerFromID(0).getPattern().putDiceOnPattern(dice,3,model.getPlayerFromID(0).getPattern());

        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).getModel().getPlayerFromID(0).getPattern().putDiceOnPattern(dice1,8,model.getPlayerFromID(0).getPattern());
        viewList.get(0).sendEvent(new LathekinEvent(3,7,8,8));
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());



    }

    @Test
    public void testLensCutterSinglePlayer() throws FileNotFoundException, InvalidMoveException {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        Model model = new Model();
        Game game = new Game(viewList, true, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        assertEquals("Luigi", model.getPlayerFromID(0).getPlayerName());
        PatternCard patternCard = new PatternCard().loadPatternForTesting();
        Dice dice = new Dice(3, DiceColor.RED);
        Dice dice1 = new Dice(4, DiceColor.GREEN);

        viewList.get(0).sendEvent(new ToolNumberEvent(3));
        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerMoveEvent(0, 1));
        viewList.get(0).sendEvent(new PlayerNoTokenEvent());
        viewList.get(0).sendEvent(new CustomPatternEvent(patternCard));
        viewList.get(0).sendEvent(new EndGameTimerEvent());


        viewList.get(0).getModel().getPlayerFromID(0).setPattern(patternCard);

        viewList.get(0).sendEvent(new EndGameTimerEvent());
        ArrayList<Dice> diceArrayList = new ArrayList<>();

        Dice dice3 = new Dice(5, DiceColor.YELLOW);
        diceArrayList.add(dice3);
        diceArrayList.add(dice1);
        diceArrayList.add(dice);
        viewList.get(0).getModel().getDraftPool().setDraftPool(diceArrayList);
        viewList.get(0).getModel().getRoundTracker().setTracker(diceArrayList);

        viewList.get(0).sendEvent(new LensCutterEvent(0, 0, 0));
    }

    @Test
    public void testFluxBrushSinglePlayer() throws FileNotFoundException, InvalidMoveException {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        Model model = new Model();
        Game game = new Game(viewList, true, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        assertEquals("Luigi", model.getPlayerFromID(0).getPlayerName());
        PatternCard patternCard = new PatternCard().loadPatternForTesting();
        Dice dice = new Dice(3, DiceColor.RED);
        Dice dice1 = new Dice(4, DiceColor.GREEN);

        viewList.get(0).sendEvent(new ToolNumberEvent(3));
        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerMoveEvent(0, 1));
        viewList.get(0).sendEvent(new PlayerNoTokenEvent());
        viewList.get(0).sendEvent(new CustomPatternEvent(patternCard));
        viewList.get(0).sendEvent(new EndGameTimerEvent());


        viewList.get(0).getModel().getPlayerFromID(0).setPattern(patternCard);

        viewList.get(0).sendEvent(new EndGameTimerEvent());
        ArrayList<Dice> diceArrayList = new ArrayList<>();

        Dice dice3 = new Dice(5, DiceColor.YELLOW);
        diceArrayList.add(dice3);
        diceArrayList.add(dice1);
        diceArrayList.add(dice);
        viewList.get(0).getModel().getDraftPool().setDraftPool(diceArrayList);
        viewList.get(0).getModel().getRoundTracker().setTracker(diceArrayList);

        viewList.get(0).sendEvent(new FluxBrushEvent(0));
    }

    @Test
    public void testGlazingHammerSinglePlayer() throws FileNotFoundException, InvalidMoveException {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        Model model = new Model();
        Game game = new Game(viewList, true, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        assertEquals("Luigi", model.getPlayerFromID(0).getPlayerName());
        PatternCard patternCard = new PatternCard().loadPatternForTesting();
        Dice dice = new Dice(3, DiceColor.RED);
        Dice dice1 = new Dice(4, DiceColor.GREEN);

        viewList.get(0).sendEvent(new ToolNumberEvent(3));
        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerMoveEvent(0, 1));
        viewList.get(0).sendEvent(new PlayerNoTokenEvent());
        viewList.get(0).sendEvent(new CustomPatternEvent(patternCard));
        viewList.get(0).sendEvent(new EndGameTimerEvent());


        viewList.get(0).getModel().getPlayerFromID(0).setPattern(patternCard);

        viewList.get(0).sendEvent(new EndGameTimerEvent());
        ArrayList<Dice> diceArrayList = new ArrayList<>();

        Dice dice3 = new Dice(5, DiceColor.YELLOW);
        diceArrayList.add(dice3);
        diceArrayList.add(dice1);
        diceArrayList.add(dice);
        viewList.get(0).getModel().getDraftPool().setDraftPool(diceArrayList);
        viewList.get(0).getModel().getRoundTracker().setTracker(diceArrayList);

        viewList.get(0).sendEvent(new GlazingHammerEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
    }


    @Test
    public void testGrindingStoneSinglePlayer() throws FileNotFoundException, InvalidMoveException {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        Model model = new Model();
        Game game = new Game(viewList, true, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        assertEquals("Luigi", model.getPlayerFromID(0).getPlayerName());
        PatternCard patternCard = new PatternCard().loadPatternForTesting();
        Dice dice = new Dice(3, DiceColor.RED);
        Dice dice1 = new Dice(4, DiceColor.GREEN);

        viewList.get(0).sendEvent(new ToolNumberEvent(3));
        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerMoveEvent(0, 1));
        viewList.get(0).sendEvent(new PlayerNoTokenEvent());
        viewList.get(0).sendEvent(new CustomPatternEvent(patternCard));
        viewList.get(0).sendEvent(new EndGameTimerEvent());


        viewList.get(0).getModel().getPlayerFromID(0).setPattern(patternCard);

        viewList.get(0).sendEvent(new EndGameTimerEvent());
        ArrayList<Dice> diceArrayList = new ArrayList<>();

        Dice dice3 = new Dice(5, DiceColor.YELLOW);
        diceArrayList.add(dice3);
        diceArrayList.add(dice1);
        diceArrayList.add(dice);
        viewList.get(0).getModel().getDraftPool().setDraftPool(diceArrayList);
        viewList.get(0).getModel().getRoundTracker().setTracker(diceArrayList);

        viewList.get(0).sendEvent(new GrindingStoneEvent(0));

    }

    @Test
    public void testTapWheelSinglePlayer() throws FileNotFoundException, InvalidMoveException {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        Model model = new Model();
        Game game = new Game(viewList, true, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        assertEquals("Luigi", model.getPlayerFromID(0).getPlayerName());
        PatternCard patternCard = new PatternCard().loadPatternForTesting();
        Dice dice = new Dice(3, DiceColor.RED);
        Dice dice1 = new Dice(4, DiceColor.GREEN);

        viewList.get(0).sendEvent(new ToolNumberEvent(3));
        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerMoveEvent(0, 1));
        viewList.get(0).sendEvent(new PlayerNoTokenEvent());
        viewList.get(0).sendEvent(new CustomPatternEvent(patternCard));
        viewList.get(0).sendEvent(new EndGameTimerEvent());


        viewList.get(0).getModel().getPlayerFromID(0).setPattern(patternCard);

        viewList.get(0).sendEvent(new EndGameTimerEvent());
        ArrayList<Dice> diceArrayList = new ArrayList<>();

        Dice dice3 = new Dice(5, DiceColor.YELLOW);
        diceArrayList.add(dice3);
        diceArrayList.add(dice1);
        diceArrayList.add(dice);
        viewList.get(0).getModel().getDraftPool().setDraftPool(diceArrayList);
        viewList.get(0).getModel().getRoundTracker().setTracker(diceArrayList);

        viewList.get(0).getModel().getPlayerFromID(0).getPattern().putDiceOnPattern(dice1,1,model.getPlayerFromID(0).getPattern());
        viewList.get(0).sendEvent(new TapWheelEvent(1,0,2,0,0));

    }

    /*@Test(expected = NullPointerException.class)
    public void testEglomiseBrushNullPlayer() throws FileNotFoundException, InvalidMoveException {
        List<VirtualView> viewList = new ArrayList<>();
        viewList.add(createView(0));
        Model model = new Model();
        Game game = new Game(viewList, true, model);
        viewList.get(0).sendEvent(new PlayerNameEvent("Luigi", 0));
        assertEquals("Luigi", model.getPlayerFromID(0).getPlayerName());
        PatternCard patternCard = new PatternCard().loadPatternForTesting();
        Dice dice = new Dice(2,DiceColor.RED);

        viewList.get(0).sendEvent(new ToolNumberEvent(3));
        viewList.get(0).sendEvent(new PlayerPatternEvent(0, 1));
        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());
        viewList.get(0).sendEvent(new PlayerMoveEvent(0, 1));
        viewList.get(0).sendEvent(new PlayerNoTokenEvent());
        viewList.get(0).sendEvent(new CustomPatternEvent(patternCard));
        viewList.get(0).sendEvent(new EndGameTimerEvent());
        viewList.get(0).sendEvent(new ToolCardSinglePlayerStartEvent(1, 0));

        viewList.get(0).sendEvent(new EndGameTimerEvent());

        viewList.get(0).sendEvent(new PlayerDraftPoolEvent());

        viewList.get(0).getModel().getPlayerFromID(0).getPattern().putDiceOnPattern(dice,3,model.getPlayerFromID(0).getPattern());

        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
        //viewList.get(0).getModel().getPlayerFromID(0).getPattern().putDiceOnPattern(dice1,4,model.getPlayerFromID(0).getPattern());
        viewList.get(0).sendEvent(new CopperFoilEvent(2,3));
        viewList.get(0).sendEvent(new PlayerNextTurnEvent());
    }*/
}
