package it.polimi.se2018.client.network.socket;

import it.polimi.se2018.client.ClientInterface;
import it.polimi.se2018.client.view.View;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Events.ClientServer.*;
import it.polimi.se2018.server.model.Events.Event;
import it.polimi.se2018.server.model.Events.InvalidMoveEvent;
import it.polimi.se2018.server.model.Events.ServerClient.ControllerView.*;
import it.polimi.se2018.server.model.Events.ServerClient.ModelView.*;
import it.polimi.se2018.server.model.Events.SinglePlayer.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

// this class must do:
// create the new socket connection and get the input/output stream
// method run, waiting to read the object from the server and
// call the readEvent, depending on the runtime types, that it's responsible to set it to the Client View
// method sendEvent, it's responsible of sending the object using socket across the network
// override of the methods of the clientInterface, that could be callable from the Client (aka socketClientImpl)

public class SocketHandler implements ClientInterface, Runnable {

    private Socket clientConnection;
    private ObjectInputStream socketIn;
    private ObjectOutputStream socketOut;
    private View view;

    public SocketHandler(String host, int port, View view) {

        try {
            this.clientConnection = new Socket(host, port);
            //this.socketIn = new ObjectInputStream(clientConnection.getInputStream());
            //socketOut = new ObjectOutputStream(clientConnection.getOutputStream());
            this.view = view;

            //new Thread(this).start();

        }
        catch (IOException e) {
            System.out.println("Connection error socket");
            e.printStackTrace();
        }

    }

    /**
     * The method run represent the Socket Handler Input mode, this is a thread that generate a loop waiting
     * for new object input to read, then call the method responsible for the proper behaviour, catch IOException
     * and ClassNotFoundException if something goes wrong.
     * @author adrianomundo
     */

    @Override
    public void run() {

        boolean loop = true;

        while (loop) {

            try {

                socketIn = new ObjectInputStream(clientConnection.getInputStream());
                Object object = socketIn.readObject();

                if (object instanceof Event) {
                    readEvent((Event) object);
                }
                else {
                    System.out.println("Not received an object");
                }

            }
            catch (IOException e) {
                System.out.println("Error in I/O socket");
                loop = false;
                view.showMaxPlayerLogin();
            }
            catch (ClassNotFoundException e) {
                System.out.println("Error loading class socket");
                e.printStackTrace();
            }
        }

    }

    // metodo per leggere evento chiamato dal socket INPUT e in base all'evento fare la cosa giusta
    public void readEvent(Event event) throws IOException {

        if (event instanceof PlayerIDEvent) {
            view.setPlayerID(((PlayerIDEvent) event).getPlayerID());
            view.showID();

        }

        else if (event instanceof SinglePlayerRequestEvent) {

            if ((view.getPlayerID()) == ((SinglePlayerRequestEvent) event).getId()) {
                view.showSinglePlayerRequest();
            }

        }
        else if (event instanceof PlayerNameUpdateEvent) {

            if ((view.getPlayerID()) == (((PlayerNameUpdateEvent) event).getID())) {
               view.setNameView(((PlayerNameUpdateEvent) event).getName());
               view.showName();
            }
            else {
                view.showNameOther(((PlayerNameUpdateEvent) event).getName());
            }
        }

        else if (event instanceof PlayerNameErrorEvent) {

            if ((view.getPlayerID()) == (((PlayerNameErrorEvent)event).getId())) {
                view.showNameError();
                view.showNameChoose();
            }
        }

        else if (event instanceof GameStartedEvent) {
            view.setStarted(((GameStartedEvent) event).isStarted());
            view.showGameStarted();
            view.showNameChoose();
        }

        else if (event instanceof PlayerPrivateUpdateEvent) {

            if((view.getPlayerID()) == ((PlayerPrivateUpdateEvent) event).getID()) {
                view.showPrivateCard(((PlayerPrivateUpdateEvent) event).getCard());
            }
        }

        else if (event instanceof StartPatternEvent) {

            if((view.getPlayerID()) == ((StartPatternEvent) event).getID()) {
                view.showPatternList(((StartPatternEvent) event).getPatternListEvent());
            }

        }

        else if (event instanceof PublicDrawEvent) {

            view.showPublicCard(((PublicDrawEvent) event).getCard());
        }

        else if (event instanceof PlayerPatternUpdateEvent) {

            if((view.getPlayerID()) == ((PlayerPatternUpdateEvent) event).getID()) {
                view.showPattern(((PlayerPatternUpdateEvent) event).getCard());
            }
            else {
                view.showOtherStartPattern( ((PlayerPatternUpdateEvent)event).getCard(), ((PlayerPatternUpdateEvent)event).getID());
            }
        }

        else if (event instanceof PlayerTokensUpdateEvent) {

            if ((view.getPlayerID()) == ((PlayerTokensUpdateEvent) event).getID()) {
                view.showTokens(((PlayerTokensUpdateEvent) event).getTokensNumber());
            }
        }

        else if (event instanceof StartGameSceneEvent) {

            view.showStartScene();
        }

        else if (event instanceof StartRoundEvent) {

            view.showCurrentRound(((StartRoundEvent) event).getRound());
        }

        else if (event instanceof StartTurnEvent) {

            if ((view.getPlayerID()) == ((StartTurnEvent) event).getID()) {
                view.showCurrentTurn();
            }

            else {
                view.showOtherCurrentTurn(((StartTurnEvent) event).getName());
            }
        }

        else if (event instanceof RollDraftPoolEvent) {

            if ((view.getPlayerID()) == ((RollDraftPoolEvent) event).getId()) {
                view.showRollCommand();
            }
        }

        else if (event instanceof PlayerDraftPoolUpdateEvent) {

            view.showDraftPool(((PlayerDraftPoolUpdateEvent) event).getDraftPool());
        }

        else if(event instanceof StartChooseEvent){

            if ((view.getPlayerID()) == ((StartChooseEvent) event).getID()) {
                view.showChooseCommand();
            }
        }

        else if (event instanceof StartMoveEvent) {

            if ((view.getPlayerID()) == ((StartMoveEvent) event).getID()) {
                view.showMoveCommand( ((StartMoveEvent) event).getPoolSize());
            }
        }

        else if (event instanceof PatternUpdateEvent) {

            if((view.getPlayerID()) == ((PatternUpdateEvent) event).getID()) {
                view.showPatternUpdate(((PatternUpdateEvent) event).getPatternCard());
            }
            else {
                view.showOtherPattern(((PatternUpdateEvent) event).getPatternCard(), ((PatternUpdateEvent) event).getName(), ((PatternUpdateEvent)event).getID());
            }

        }

        else if (event instanceof RoundTrackerUpdateEvent) {

            view.showRoundTracker(((RoundTrackerUpdateEvent) event).getRoundTracker());
        }

        else if (event instanceof TurnPatternEvent) {

            if((view.getPlayerID()) == ((TurnPatternEvent) event).getID()) {
                view.showPatternUpdate(((TurnPatternEvent) event).getPatternCard());
            }
        }

        else if (event instanceof StartToolEvent) {

            if((view.getPlayerID()) == ((StartToolEvent) event).getId()) {
                view.showToolCommand(((StartToolEvent) event).getToolCardList());
            }

        }

        else if (event instanceof OutOfTokenEvent) {

            if ((view.getPlayerID()) == ((OutOfTokenEvent) event).getId()) {
                view.showTokenError();
            }
        }

        else if (event instanceof PlayerPointsUpdateEvent) {

            view.showFinalRank(((PlayerPointsUpdateEvent) event).getPlayerList());
        }

        else if (event instanceof WinnerEvent) {

            if ((view.getPlayerID()) == ((WinnerEvent) event).getID()) {
                view.showWinner();
            } else {
                view.showLosers();
            }
        }

        else if (event instanceof TimerEndedEvent) {

            if ((view.getPlayerID()) == ((TimerEndedEvent) event).getId()) {
                view.showTimer();
            }

        }

        else if (event instanceof TimerOtherEvent) {

            view.showOtherTimer(((TimerOtherEvent) event).getName());
        }

        else if (event instanceof ToolCardUpdateEvent) {

            view.showToolCards(((ToolCardUpdateEvent) event).getToolCardList());
        }

        else if (event instanceof GrozingPliersRequestEvent) {

            if ((view.getPlayerID()) == ((GrozingPliersRequestEvent) event).getId()) {
                view.showGrozingRequest( ((GrozingPliersRequestEvent) event).getPoolSize());
            }

        }

        else if (event instanceof EglomiseBrushRequestEvent) {

            if ((view.getPlayerID()) == ((EglomiseBrushRequestEvent) event).getId()) {
                view.showEglomiseStart();
            }
        }

        else if (event instanceof CopperFoilRequestEvent) {

            if ((view.getPlayerID()) == ((CopperFoilRequestEvent) event).getId()) {
                view.showCopperFoilStart();
            }
        }

        else if (event instanceof LathekinRequestEvent) {

            if ((view.getPlayerID()) == ((LathekinRequestEvent) event).getId()) {
                view.showLathekinStart();
            }
        }

        else if (event instanceof LensCutterRequestEvent) {

            if ((view.getPlayerID()) == ((LensCutterRequestEvent) event).getId()) {
                view.showLensCutterRequest( ((LensCutterRequestEvent) event).getPoolSize(), ((LensCutterRequestEvent) event).getRoundSizes());
            }
        }

        else if (event instanceof FluxBrushRequestEvent) {

            if ((view.getPlayerID()) == ((FluxBrushRequestEvent) event).getId()) {
                view.showFluxBrushRequest( ((FluxBrushRequestEvent)event).getPoolSize());
            }
        }

        else if (event instanceof GlazingHammerRequestEvent) {

            if ((view.getPlayerID()) == ((GlazingHammerRequestEvent) event).getId()) {
                view.showGlazingHammerRequest();
            }
        }

        else if (event instanceof RunningPliersRequestEvent) {

            if ((view.getPlayerID()) == ((RunningPliersRequestEvent) event).getId()) {
                view.showRunningPliersPool( ((RunningPliersRequestEvent) event).getPoolSize());
            }
        }

        else if (event instanceof CorkBackedRequestEvent) {

            if ((view.getPlayerID()) == ((CorkBackedRequestEvent) event).getId()) {
                view.showCorkBackedPool( ((CorkBackedRequestEvent) event).getPoolSize());
            }
        }

        else if (event instanceof GrindingStoneRequestEvent) {

            if ((view.getPlayerID()) == ((GrindingStoneRequestEvent) event).getId()) {
                view.showGrindingStoneRequest( ((GrindingStoneRequestEvent) event).getPoolSize());
            }
        }

        else if (event instanceof FluxRemoverRequestEvent) {

            if ((view.getPlayerID()) == ((FluxRemoverRequestEvent) event).getId()) {
                view.showFluxRemoverPool( ((FluxRemoverRequestEvent) event).getDiceColor(), ((FluxRemoverRequestEvent) event).getPoolSize());
            }
        }

        else if (event instanceof TapWheelRequestEvent) {

            if ((view.getPlayerID()) == ((TapWheelRequestEvent) event).getId()) {
                view.showTapWheelNumber();
            }
        }

        else if (event instanceof UpdateBoardEvent) {
            view.showBoard(((UpdateBoardEvent) event).getRoundTracker(), ((UpdateBoardEvent) event).getDraftPool());
        }

        else if (event instanceof InvalidMoveEvent) {

            if ((view.getPlayerID()) == ((InvalidMoveEvent) event).getId()) {
                view.showInvalidMove(((InvalidMoveEvent) event).getErrorMsg());
            }
        }

        else if (event instanceof UpdatePoolEvent) {
            view.showDraftPool(((UpdatePoolEvent) event).getDraftPool());
        }

        //---------------------------------single player events-----------------------------------------

        else if (event instanceof ToolNumberRequestEvent) {
            view.showDifficultyRequest();
        }

        else if (event instanceof SinglePrivateEvent) {
            view.showPrivateSingle(((SinglePrivateEvent) event).getPrivateList());
        }

        else if (event instanceof EndSinglePlayerEvent){
            view.showEndSinglePlayer(((EndSinglePlayerEvent) event).isWinner(), ((EndSinglePlayerEvent) event).getPlayerPoints(), ((EndSinglePlayerEvent)event).getGameThreshold());
        }

        else if (event instanceof StartToolSinglePlayerEvent) {
            view.showToolSingleCommand( ((StartToolSinglePlayerEvent) event).getToolCardList(), ((StartToolSinglePlayerEvent)event).getPoolSize());
        }

        else if (event instanceof NotMatchColorEvent) {
            view.showMatchError();
        }

        //------------------------disconnection msg-----------------------------------------------------

        else if (event instanceof DisconnectionMsgEvent) {
            view.showExitPlayer( ((DisconnectionMsgEvent) event).getName());
        }

        else if (event instanceof ReconnectionMsgEvent) {
            view.showReconnectPlayer( ((ReconnectionMsgEvent)event).getName());
        }
        else if (event instanceof NotPlayerDisconnectedEvent) {
            view.showNotPermittedReconnection();
        }
        else if (event instanceof SuccessfulReconnectionEvent) {
            // todo gestire anche per rmi
            view.showReload(((SuccessfulReconnectionEvent) event).getCurrPlayer(), ((SuccessfulReconnectionEvent) event).isSinglePlayer(), ((SuccessfulReconnectionEvent) event).isGameStarted(), ((SuccessfulReconnectionEvent) event).getToolList(), ((SuccessfulReconnectionEvent) event).getPublicCardList(), ((SuccessfulReconnectionEvent) event).getPlayerList());
        }else {
            System.out.println("Not understood the message");
        }
    }


    /**
     * sendEvent represent the Socket Handler Output mode, it is used to send the event invoked by the client
     * across the network, catch IOException if something goes wrong
     * @param event
     * @author adrianomundo
     *
     */
    public synchronized void sendEvent(Event event) {

        try {
            socketOut = new ObjectOutputStream(clientConnection.getOutputStream());
            socketOut.writeObject(event);
            socketOut.flush();
        }
        catch (IOException e) {
            System.out.println("Error in writing object in socket");
            e.printStackTrace();
        }
    }







    // ----socket client impl----------------override methods callable by the client------------------------------


    @Override
    public void setSinglePlayerMode(int id, boolean singlePlayer) {
        sendEvent(new SinglePlayerEvent(id, singlePlayer));
    }

    @Override
    public void setPlayerNameToServer(String name, int id) {
        sendEvent(new PlayerNameEvent(name, id));
    }

    @Override
    public void setPatternCardToServer(int indexPatternChoose, int id) {
        sendEvent(new PlayerPatternEvent(id, indexPatternChoose));
    }

    @Override
    public void setDraftPoolToServer(int ID) {
        sendEvent(new PlayerDraftPoolEvent());
    }

    @Override
    public void setChooseToServer(int ID, int step) {
        sendEvent(new PlayerChooseEvent(step));
    }

    @Override
    public void setMoveToServer(int ID, int indexPool, int indexPattern) {
        sendEvent(new PlayerMoveEvent(indexPool, indexPattern));
    }

    @Override
    public void setStartToolToServer(int ID) {
        sendEvent(new PlayerStartToolEvent());
    }

    @Override
    public void setNextTurnToServer(int ID) {
        sendEvent(new PlayerNextTurnEvent());
    }

    @Override
    public void setNoTokenToServer(int ID) {
        sendEvent(new PlayerNoTokenEvent());
    }

    @Override
    public void useToolCardToServer(int ID, int indexTool) {
        sendEvent(new ToolCardStartEvent(indexTool));
    }

    @Override
    public void useGrozingToolCard(int ID, int indexPool, int increase) {
        sendEvent(new GrozingPliersEvent(indexPool,increase));
    }

    @Override
    public void useEglomiseToolCard(int ID, int indexStart, int indexEnd) {
        sendEvent(new EglomiseBrushEvent(indexStart, indexEnd));
    }

    @Override
    public void useCopperFoilToolCard(int ID, int indexStart, int indexEnd) {
        sendEvent(new CopperFoilEvent(indexStart, indexEnd));
    }

    @Override
    public void useLathekinToolCard(int ID, int indexStartOne, int indexEndOne, int indexStartTwo, int indexEndTwo) {
        sendEvent(new LathekinEvent(indexStartOne, indexEndOne, indexStartTwo, indexEndTwo));
    }

    @Override
    public void useLensCutterToolCard(int ID, int indexPool, int indexRound, int indexPosition) {
        sendEvent(new LensCutterEvent(indexPool, indexRound, indexPosition));
    }

    @Override
    public void useFluxBrushToolCard(int ID, int indexPool) {
        sendEvent(new FluxBrushEvent(indexPool));
    }

    @Override
    public void useGlazingHammerToolCard(int ID) {
        sendEvent(new GlazingHammerEvent());
    }

    @Override
    public void useRunningPliersToolCard(int ID, int indexPool, int indexPattern) {
        sendEvent(new RunningPliersEvent(indexPool, indexPattern));
    }

    @Override
    public void useCorkBackedToolCard(int ID, int indexPool, int indexPattern) {
        sendEvent(new CorkBackedEvent(indexPool, indexPattern));
    }

    @Override
    public void useGrindingStoneToolCard(int ID, int indexPool) {
        sendEvent(new GrindingStoneEvent(indexPool));
    }

    @Override
    public void useFluxRemoverToolCard(int ID, int indexPool, int diceValue) {
        sendEvent(new FluxRemoverEvent(indexPool, diceValue));
    }

    @Override
    public void useTapWheelToolCard(int ID, int number, int indexStartOne, int indexEndOne, int indexStartTwo, int indexEndTwo) {
        sendEvent(new TapWheelEvent(number, indexStartOne, indexEndOne, indexStartTwo, indexEndTwo));

    }

    @Override
    public void setEndGameTimer(int ID) {
        sendEvent(new EndGameTimerEvent());
    }

    //-------------------------single player methods------------------


    @Override
    public void setDifficultyToServer(int ID, int difficulty) {
        sendEvent(new ToolNumberEvent(difficulty));
    }

    @Override
    public void useToolSingleToServer(int ID, int indexTool, int indexPool) {
        sendEvent(new ToolCardSinglePlayerStartEvent(indexTool,indexPool));
    }

    //------------------------custom card--------------------------------------------------


    @Override
    public void setPatternCustomToServer(int ID, PatternCard patternCard) {
        sendEvent(new CustomPatternEvent(patternCard));
    }

    //--------------------------disconnection-----------------------------------------------

    @Override
    public void setExitToServer(int ID) {
        sendEvent(new ExitEvent(ID));

    }

    @Override
    public void setReconnectToServer(int ID) {
        sendEvent(new ReconnectPlayerEvent(ID));
    }
}
