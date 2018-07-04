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

public class RmiServerImpl extends UnicastRemoteObject implements RmiServerInterface {

    private Server server;
    private List<VirtualRmi> clientsRmi;

    RmiServerImpl(Server server) throws RemoteException {
        super(0);
        this.server = server;
        this.clientsRmi = new ArrayList<>();

    }

    List<VirtualRmi> getClientsRmi() {
        return clientsRmi;
    }

    private void sendEventVirtual(int id, Event event) {
        for (VirtualRmi virtualRmi : clientsRmi) {
            if (virtualRmi.getPlayerID() == id) {
                virtualRmi.sendEventController(event);
            }
        }
    }

    // ovveride dei metodi dell'interfaccia che poi chiamano metodo che agisce sul controller

    @Override
    public void registerRmiClient(RmiClientInterface clientRmi) {
        server.addRmiClient(clientRmi, this);
    }

    @Override
    public void addToClientsRmiImpl(VirtualRmi virtualRmi) {
        clientsRmi.add(virtualRmi);
    }


    @Override
    public void setSinglePlayerMode(int id, boolean singlePlayer)  {
        sendEventVirtual(id, new SinglePlayerEvent(id, singlePlayer));
    }



    @Override
    public void setPlayerNameToServer(String username, int id)  {
        sendEventVirtual(id, new PlayerNameEvent(username, id));

    }

    @Override
    public void setPatternCardToServer(int indexPatternChoose, int id)  {
        sendEventVirtual(id, new PlayerPatternEvent(id, indexPatternChoose));

    }

    @Override
    public void setDraftPoolToServer(int id)  {
        sendEventVirtual(id, new PlayerDraftPoolEvent());

    }

    @Override
    public void setChooseToServer(int id, int step)  {
        sendEventVirtual(id, new PlayerChooseEvent(step));

    }

    @Override
    public void setMoveToServer(int id, int indexPool, int indexPattern)  {
        sendEventVirtual(id, new PlayerMoveEvent(indexPool, indexPattern));

    }

    @Override
    public void setStartToolToServer(int id)  {
        sendEventVirtual(id, new PlayerStartToolEvent());

    }

    @Override
    public void setNextTurnToServer(int id)  {
        sendEventVirtual(id, new PlayerNextTurnEvent());

    }

    @Override
    public void setNoTokenToServer(int id)  {
        sendEventVirtual(id, new PlayerNoTokenEvent());

    }

    @Override
    public void useToolCardToServer(int id, int indexTool)  {
        sendEventVirtual(id, new ToolCardStartEvent(indexTool));

    }

    @Override
    public void useGrozingToolCard(int id, int indexPool, int increase)  {
        sendEventVirtual(id, new GrozingPliersEvent(indexPool, increase));
    }

    @Override
    public void useEglomiseToolCard(int id, int indexStart, int indexEnd)  {
        sendEventVirtual(id, new EglomiseBrushEvent(indexStart, indexEnd));
    }

    @Override
    public void useCopperFoilToolCard(int id, int indexStart, int indexEnd)  {
        sendEventVirtual(id, new CopperFoilEvent(indexStart, indexEnd));
    }

    @Override
    public void useLathekinToolCard(int id, int indexStartOne, int indexEndOne, int indexStartTwo, int indexEndTwo)  {
        sendEventVirtual(id, new LathekinEvent(indexStartOne, indexEndOne, indexStartTwo, indexEndTwo));
    }

    @Override
    public void useLensCutterToolCard(int id, int indexPool, int indexRound, int indexPosition)  {
        sendEventVirtual(id, new LensCutterEvent(indexPool, indexRound, indexPosition));
    }

    @Override
    public void useFluxBrushToolCard(int id, int indexPool)  {
        sendEventVirtual(id, new FluxBrushEvent(indexPool));
    }

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


