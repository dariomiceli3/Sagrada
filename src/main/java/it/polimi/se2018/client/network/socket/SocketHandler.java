package it.polimi.se2018.client.network.socket;

import it.polimi.se2018.client.network.ClientInterface;
import it.polimi.se2018.client.view.View;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.events.clientserver.*;
import it.polimi.se2018.events.Event;
import it.polimi.se2018.events.InvalidMoveEvent;
import it.polimi.se2018.events.serverclient.controllerview.*;
import it.polimi.se2018.events.serverclient.modelview.*;
import it.polimi.se2018.events.singleplayer.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Logger;

/**
 * Class SocketHandler: represents the connection link between the client and the server, the socket handler is responsible
 * to take the input the client provided to view and send it to the virtual socket (socket client implementation) across
 * the network using the socket technology for the communication. It creates the socket connection to the server,
 * send the event to server after the choose of the client and receives in a thread (infinite loop) the object sent by
 * the virtual socket, let the view show the different output depending on the runtime event it receives.
 * @see it.polimi.se2018.client.network.ClientInterface
 * @see java.lang.Runnable
 * @author fadda-miceli-mundo
 */
public class SocketHandler implements ClientInterface, Runnable {

    private final Logger log = Logger.getLogger(SocketHandler.class.getName());
    private Socket clientConnection;
    private View view;

    /**
     * Class constructor: create a new socket handler with an associated host (ip address) of the server to connect to,
     * the port where socket has to be connected and a view
     * @param host ip address
     * @param port of the server
     * @param view associated
     */
    public SocketHandler(String host, int port, View view) {

        log.info("connecting to ip socket: " + host);

        try {
            this.clientConnection = new Socket(host, port);
            this.view = view;
        }
        catch (IOException e) {
            log.info("Connection error socket");
            log.warning(e.getMessage());
        }
    }

    /**
     * Override of the method run represent the Socket Handler Input mode, this is a thread that generate a loop waiting
     * for new object input to read, then call the method responsible for the proper behaviour, catch IOException
     * if something goes wrong.
     */
    @Override
    public void run() {
        boolean loop = true;

        while (loop) {
            try {
                ObjectInputStream socketIn = new ObjectInputStream(clientConnection.getInputStream());
                Object object = socketIn.readObject();

                if (object instanceof Event) {
                    readEvent((Event) object);
                }
                else {
                    log.info("Not received an object");
                }
            }
            catch (IOException e) {
                log.info("Error in I/O socket");
                loop = false;
                view.showMaxPlayerLogin();
            }
            catch (ClassNotFoundException e) {
                log.info("Error loading class socket");
                log.warning(e.getMessage());
            }
        }

    }

    /**
     * method that read the event passed as parameter and depending on the type of the event received let the view
     * with the correct id use their generics and  behavioural show methods to show output to the client
     * @param event to read
     * @throws IOException if something goes wrong
     */
    private void readEvent(Event event) throws IOException {
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
            view.showFinalRank(((PlayerPointsUpdateEvent) event).getPlayerList(), ((PlayerPointsUpdateEvent)event).isFinish());
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
            view.showReload(((SuccessfulReconnectionEvent) event).getCurrPlayer(), ((SuccessfulReconnectionEvent) event).isSinglePlayer(), ((SuccessfulReconnectionEvent) event).isGameStarted(), ((SuccessfulReconnectionEvent) event).getToolList(), ((SuccessfulReconnectionEvent) event).getPublicCardList(), ((SuccessfulReconnectionEvent) event).getPlayerList());
        }else {
            log.info("Not understood the message");
        }
    }


    /**
     * sendEvent represent the Socket Handler Output mode, it is used to send the event invoked by the client to
     * the virtual socket across the network, catch IOException if something goes wrong
     * @param event to send to the server
     */
    private synchronized void sendEvent(Event event) {

        try {
            ObjectOutputStream socketOut = new ObjectOutputStream(clientConnection.getOutputStream());
            socketOut.writeObject(event);
            socketOut.flush();
        }
        catch (IOException e) {
            log.info("Error in writing object in socket");
            log.warning(e.getMessage());
        }
    }


    // -----------------socket client impl--------override methods callable by the client------------------------------


    /**
     * @see ClientInterface
     * @param id of the player
     * @param singlePlayer mode game
     */
    @Override
    public void setSinglePlayerMode(int id, boolean singlePlayer) {
        sendEvent(new SinglePlayerEvent(id, singlePlayer));
    }

    /**
     * @see ClientInterface
     * @param name
     * @param id of the player
     */
    @Override
    public void setPlayerNameToServer(String name, int id) {
        sendEvent(new PlayerNameEvent(name, id));
    }

    /**
     * @see ClientInterface
     * @param indexPatternChoose index of the player's pattern  card list
     * @param id of the player
     */
    @Override
    public void setPatternCardToServer(int indexPatternChoose, int id) {
        sendEvent(new PlayerPatternEvent(id, indexPatternChoose));
    }

    /**
     * @see ClientInterface
     * @param id of the player
     */
    @Override
    public void setDraftPoolToServer(int id) {
        sendEvent(new PlayerDraftPoolEvent());
    }

    /**
     * @see ClientInterface
     * @param id of the player
     * @param step first move chose of the player
     */
    @Override
    public void setChooseToServer(int id, int step) {
        sendEvent(new PlayerChooseEvent(step));
    }

    /**
     * @see ClientInterface
     * @param id of the player
     * @param indexPool index of the dice in the draft pool
     * @param indexPattern index of the box of the pattern card
     */
    @Override
    public void setMoveToServer(int id, int indexPool, int indexPattern) {
        sendEvent(new PlayerMoveEvent(indexPool, indexPattern));
    }

    /**
     * @see ClientInterface
     * @param id of the player
     */
    @Override
    public void setStartToolToServer(int id) {
        sendEvent(new PlayerStartToolEvent());
    }

    /**
     * @see ClientInterface
     * @param id of the player
     */
    @Override
    public void setNextTurnToServer(int id) {
        sendEvent(new PlayerNextTurnEvent());
    }


    /**
     * @see ClientInterface
     * @param id player id
     */
    @Override
    public void setNoTokenToServer(int id) {
        sendEvent(new PlayerNoTokenEvent());
    }

    /**
     * @see ClientInterface
     * @param id of the player
     * @param indexTool index of the tool card list
     */
    @Override
    public void useToolCardToServer(int id, int indexTool) {
        sendEvent(new ToolCardStartEvent(indexTool));
    }

    /**
     * @see ClientInterface
     * @param id of the player
     * @param indexPool index of the dice in the draft pool
     * @param increase increase or decrease decision of the player
     */
    @Override
    public void useGrozingToolCard(int id, int indexPool, int increase) {
        sendEvent(new GrozingPliersEvent(indexPool,increase));
    }

    /**
     * @see ClientInterface
     * @param id of the player
     * @param indexStart index of the dice to move
     * @param indexEnd index of where to move the dice
     */
    @Override
    public void useEglomiseToolCard(int id, int indexStart, int indexEnd) {
        sendEvent(new EglomiseBrushEvent(indexStart, indexEnd));
    }

    /**
     * @see ClientInterface
     * @param id of the player
     * @param indexStart index of the dice to move
     * @param indexEnd index of where to move the dice
     */
    @Override
    public void useCopperFoilToolCard(int id, int indexStart, int indexEnd) {
        sendEvent(new CopperFoilEvent(indexStart, indexEnd));
    }

    /**
     * @see ClientInterface
     * @param id of the player
     * @param indexStartOne index of the first dice to move
     * @param indexEndOne index of where to move the first dice
     * @param indexStartTwo index of the second dice to move
     * @param indexEndTwo index of where to move the second dice
     */
    @Override
    public void useLathekinToolCard(int id, int indexStartOne, int indexEndOne, int indexStartTwo, int indexEndTwo) {
        sendEvent(new LathekinEvent(indexStartOne, indexEndOne, indexStartTwo, indexEndTwo));
    }

    /**
     * @see ClientInterface
     * @param id of the player
     * @param indexPool index of the dice in the draft pool
     * @param indexRound index of the round
     * @param indexPosition index of the position of the dice in the round list
     */
    @Override
    public void useLensCutterToolCard(int id, int indexPool, int indexRound, int indexPosition) {
        sendEvent(new LensCutterEvent(indexPool, indexRound, indexPosition));
    }

    /**
     * @see ClientInterface
     * @param id of the player
     * @param indexPool index of the dice in the draft pool
     */
    @Override
    public void useFluxBrushToolCard(int id, int indexPool) {
        sendEvent(new FluxBrushEvent(indexPool));
    }

    /**
     * @see ClientInterface
     * @param id of the player
     */
    @Override
    public void useGlazingHammerToolCard(int id) {
        sendEvent(new GlazingHammerEvent());
    }

    /**
     * @see ClientInterface
     * @param id of the player
     * @param indexPool index of the dice in the draft pool
     * @param indexPattern index of the box of the pattern card
     */
    @Override
    public void useRunningPliersToolCard(int id, int indexPool, int indexPattern) {
        sendEvent(new RunningPliersEvent(indexPool, indexPattern));
    }

    /**
     * @see ClientInterface
     * @param id of the player
     * @param indexPool index of the dice in the draft pool
     * @param indexPattern index of the box of the pattern card
     */
    @Override
    public void useCorkBackedToolCard(int id, int indexPool, int indexPattern) {
        sendEvent(new CorkBackedEvent(indexPool, indexPattern));
    }

    /**
     * @see ClientInterface
     * @param id of the player
     * @param indexPool index of the dice in the draft pool
     */
    @Override
    public void useGrindingStoneToolCard(int id, int indexPool) {
        sendEvent(new GrindingStoneEvent(indexPool));
    }

    /**
     * @see ClientInterface
     * @param id of the player
     * @param indexPool index of the dice in the draft pool
     * @param diceValue the value to change the dice
     */
    @Override
    public void useFluxRemoverToolCard(int id, int indexPool, int diceValue) {
        sendEvent(new FluxRemoverEvent(indexPool, diceValue));
    }

    /**
     * @see ClientInterface
     * @param id of the player
     * @param number of dice to move
     * @param indexStartOne index of the first dice to move
     * @param indexEndOne index where to move the first dice
     * @param indexStartTwo index of the second dice to move
     * @param indexEndTwo index where to move the second dice
     */
    @Override
    public void useTapWheelToolCard(int id, int number, int indexStartOne, int indexEndOne, int indexStartTwo, int indexEndTwo) {
        sendEvent(new TapWheelEvent(number, indexStartOne, indexEndOne, indexStartTwo, indexEndTwo));

    }

    /**
     * @see ClientInterface
     * @param id of the player
     */
    @Override
    public void setEndGameTimer(int id) {
        sendEvent(new EndGameTimerEvent());
    }

    //-------------------------single player methods------------------


    /**
     * @see ClientInterface
     * @param id of the player
     * @param difficulty value of the difficulty
     */
    @Override
    public void setDifficultyToServer(int id, int difficulty) {
        sendEvent(new ToolNumberEvent(difficulty));
    }

    /**
     * @see ClientInterface
     * @param id of the player
     * @param indexTool index of the tool card in tool card list
     * @param indexPool index of the the dice in the draft pool
     */
    @Override
    public void useToolSingleToServer(int id, int indexTool, int indexPool) {
        sendEvent(new ToolCardSinglePlayerStartEvent(indexTool,indexPool));
    }

    //------------------------custom card--------------------------------------------------

    /**
     * @see ClientInterface
     * @param id player id
     * @param patternCard pattern card to set to the player
     */
    @Override
    public void setPatternCustomToServer(int id, PatternCard patternCard) {
        sendEvent(new CustomPatternEvent(patternCard));
    }

    //--------------------------disconnection-----------------------------------------------

    /**
     * @see ClientInterface
     * @param id of the player
     */
    @Override
    public void setExitToServer(int id) {
        sendEvent(new ExitEvent(id));

    }

    /**
     * @see ClientInterface
     * @param id of the player
     */
    @Override
    public void setReconnectToServer(int id) {
        sendEvent(new ReconnectPlayerEvent(id));
    }
}
