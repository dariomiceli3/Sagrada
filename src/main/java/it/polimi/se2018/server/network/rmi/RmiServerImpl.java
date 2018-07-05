package it.polimi.se2018.server.network.rmi;


import it.polimi.se2018.client.network.rmi.RmiClientInterface;
import it.polimi.se2018.server.network.Server;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.events.clientserver.*;
import it.polimi.se2018.events.Event;
import it.polimi.se2018.events.singleplayer.SinglePlayerEvent;
import it.polimi.se2018.events.singleplayer.ToolCardSinglePlayerStartEvent;
import it.polimi.se2018.events.singleplayer.ToolNumberEvent;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Class RmiServerImpl: the class is a subclass of RmiServerInterface, so it's responsible of the implementation of all
 * the abstract method of the interface, the Impl is linked to the Server where it's running and have a list of the clients
 * rmi connected to the server. The methods of the class are remotely called by the client
 * @see it.polimi.se2018.server.network.rmi.RmiServerInterface
 * @author fadda-miceli-mundo
 */
public class RmiServerImpl extends UnicastRemoteObject implements RmiServerInterface {

    private Server server;
    private List<VirtualRmi> clientsRmi;

    /**
     * Class constructor that create a new Rmi Server Impl on the Server
     * @param server where the Impl is running
     * @throws RemoteException
     */
    RmiServerImpl(Server server) throws RemoteException {
        super(0);
        this.server = server;
        this.clientsRmi = new ArrayList<>();
    }

    /**
     * method that provide the caller the list of the clients rmi connected to the server
     * @return a list of virtual rmi connected
     */
    List<VirtualRmi> getClientsRmi() {
        return clientsRmi;
    }

    /**
     * method responsible of send the event of the remote call from client to the virtual rmi that match
     * the id of the client
     * @param id of the client
     * @param event to send to the controller
     */
    private void sendEventVirtual(int id, Event event) {
        for (VirtualRmi virtualRmi : clientsRmi) {
            if (virtualRmi.getPlayerID() == id) {
                virtualRmi.sendEventController(event);
            }
        }
    }

    //-------------------------------override interface methods---------------------------------------------------------


    /**
     * method that add an rmi client to the list of clients in the server
     * @param clientRmi that have to be added
     */
    @Override
    public void registerRmiClient(RmiClientInterface clientRmi) {
        server.addRmiClient(clientRmi, this);
    }

    /**
     * method that add to the server an rmi virtual to the list of the rmi clients
     * @param virtualRmi that have to be added
     */
    @Override
    public void addToClientsRmiImpl(VirtualRmi virtualRmi) {
        clientsRmi.add(virtualRmi);
    }

    /**
     * method that set to the server if the game mode chose is single player or not
     * @param id of the player
     * @param singlePlayer mode game
     */
    @Override
    public void setSinglePlayerMode(int id, boolean singlePlayer)  {
        sendEventVirtual(id, new SinglePlayerEvent(id, singlePlayer));
    }


    /**
     * method that set to the server the name of the player with the id obtained as parameter
     * @param username name to set
     * @param id of the player
     */
    @Override
    public void setPlayerNameToServer(String username, int id)  {
        sendEventVirtual(id, new PlayerNameEvent(username, id));

    }

    /**
     * method that set to the server the Pattern Card used by the player for the rest of the game
     * @param indexPatternChoose index of the list of pattern of the player
     * @param id of the player
     */
    @Override
    public void setPatternCardToServer(int indexPatternChoose, int id)  {
        sendEventVirtual(id, new PlayerPatternEvent(id, indexPatternChoose));

    }

    /**
     * method that alert to the server to roll the draft pool
     * @param id of the player
     */
    @Override
    public void setDraftPoolToServer(int id)  {
        sendEventVirtual(id, new PlayerDraftPoolEvent());

    }

    /**
     * method that set to the server the choose of the first move of the player with that id
     * @param id of the player
     * @param step first move chose of the player
     */
    @Override
    public void setChooseToServer(int id, int step)  {
        sendEventVirtual(id, new PlayerChooseEvent(step));

    }

    /**
     * method that set to the server the move of a dice to the pattern done by the player
     * @param id of the player
     * @param indexPool index of the dice in the draft pool
     * @param indexPattern index of the box of the pattern card
     */
    @Override
    public void setMoveToServer(int id, int indexPool, int indexPattern)  {
        sendEventVirtual(id, new PlayerMoveEvent(indexPool, indexPattern));

    }

    /**
     * method that alert to the server that the player decided to use a tool card
     * @param id of the player
     */
    @Override
    public void setStartToolToServer(int id)  {
        sendEventVirtual(id, new PlayerStartToolEvent());

    }

    /**
     * method that alert of the next turn to the server
     * @param id of the player
     */
    @Override
    public void setNextTurnToServer(int id)  {
        sendEventVirtual(id, new PlayerNextTurnEvent());

    }

    /**
     * method that alert to the server that the player decided to not perform a tool card move
     * because of the cost
     * @param id player id
     */
    @Override
    public void setNoTokenToServer(int id)  {
        sendEventVirtual(id, new PlayerNoTokenEvent());

    }

    /**
     * method that alert to the server that the player decided to use the tool card obtained as parameter
     * @param id of the player
     * @param indexTool index of the tool card list
     */
    @Override
    public void useToolCardToServer(int id, int indexTool)  {
        sendEventVirtual(id, new ToolCardStartEvent(indexTool));

    }

    /**
     * method that set to the server the player uses the Grozing Pliers tool card
     * @param id of the player
     * @param indexPool index of the dice in the draft pool
     * @param increase increase or decrease decision of the player
     */
    @Override
    public void useGrozingToolCard(int id, int indexPool, int increase)  {
        sendEventVirtual(id, new GrozingPliersEvent(indexPool, increase));
    }

    /**
     * method that set to the server the player uses the Eglomise Brush tool card
     * @param id of the player
     * @param indexStart index of the dice to move
     * @param indexEnd index of where to move the dice
     */
    @Override
    public void useEglomiseToolCard(int id, int indexStart, int indexEnd)  {
        sendEventVirtual(id, new EglomiseBrushEvent(indexStart, indexEnd));
    }

    /**
     * method that set to the server the player uses the Copper Foil Burnisher tool card
     * @param id of the player
     * @param indexStart index of the dice to move
     * @param indexEnd index of where to move the dice
     */
    @Override
    public void useCopperFoilToolCard(int id, int indexStart, int indexEnd)  {
        sendEventVirtual(id, new CopperFoilEvent(indexStart, indexEnd));
    }

    /**
     * method that set to the server the player uses Lathekin tool card
     * @param id of the player
     * @param indexStartOne index of the first dice to move
     * @param indexEndOne index of where to move the first dice
     * @param indexStartTwo index of the second dice to move
     * @param indexEndTwo index of where to move the second dice
     */
    @Override
    public void useLathekinToolCard(int id, int indexStartOne, int indexEndOne, int indexStartTwo, int indexEndTwo)  {
        sendEventVirtual(id, new LathekinEvent(indexStartOne, indexEndOne, indexStartTwo, indexEndTwo));
    }

    /**
     * method that set to the server the player uses Lens Cutter tool card
     * @param id of the player
     * @param indexPool index of the dice in the draft pool
     * @param indexRound index of the round
     * @param indexPosition index of the position of the dice in the round list
     */
    @Override
    public void useLensCutterToolCard(int id, int indexPool, int indexRound, int indexPosition)  {
        sendEventVirtual(id, new LensCutterEvent(indexPool, indexRound, indexPosition));
    }

    /**
     * method that set to the server the player uses Flux Brush tool card
     * @param id of the player
     * @param indexPool index of the dice in the draft pool
     */
    @Override
    public void useFluxBrushToolCard(int id, int indexPool)  {
        sendEventVirtual(id, new FluxBrushEvent(indexPool));
    }

    /**
     * method that set to the server
     * @param id
     */
    @Override
    public void useGlazingHammerToolCard(int id)  {
        sendEventVirtual(id, new GlazingHammerEvent());
    }

    @Override
    public void useRunningPliersToolCard(int id, int indexPool, int indexPattern)  {
        sendEventVirtual(id, new RunningPliersEvent(indexPool, indexPattern));
    }

    @Override
    public void useCorkBackedToolCard(int id, int indexPool, int indexPattern)  {
        sendEventVirtual(id, new CorkBackedEvent(indexPool, indexPattern));
    }

    @Override
    public void useGrindingStoneToolCard(int id, int indexPool)  {
        sendEventVirtual(id, new GrindingStoneEvent(indexPool));
    }

    @Override
    public void useFluxRemoverToolCard(int id, int indexPool, int diceValue)  {
        sendEventVirtual(id, new FluxRemoverEvent(indexPool, diceValue));
    }

    @Override
    public void useTapWheelToolCard(int id, int number, int indexStartOne, int indexEndOne, int indexStartTwo, int indexEndTwo)  {
        sendEventVirtual(id, new TapWheelEvent(number, indexStartOne, indexEndOne, indexStartTwo, indexEndTwo));
    }

    @Override
    public void setEndGameTimer(int id) {
        sendEventVirtual(id, new EndGameTimerEvent());
    }

    //---------------------------single player methods-------------------------------------------

    @Override
    public void setDifficultyToServer(int id, int difficulty)  {
        sendEventVirtual(id, new ToolNumberEvent(difficulty));
    }

    @Override
    public void useToolSingleToServer(int id, int indexTool, int indexPool)  {
        sendEventVirtual(id, new ToolCardSinglePlayerStartEvent(indexTool, indexPool));
    }

    //----------------------------card custom-----------------------------------------


    @Override
    public void setPatternCustomToServer(int id, PatternCard patternCard)  {
        sendEventVirtual(id, new CustomPatternEvent(patternCard));
    }

    //------------------------------disconnection----------------------------------------


    @Override
    public void setExitToServer(int id) {
        sendEventVirtual(id, new ExitEvent(id));
    }

    @Override
    public void setReconnectToServer(int id) {
        sendEventVirtual(id, new ReconnectPlayerEvent(id));
    }

    @Override
    public void clientPing(int id) {
        for (VirtualRmi virtualRmi : clientsRmi) {
            if (virtualRmi.getPlayerID() == id) {
                virtualRmi.timeout();
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}


