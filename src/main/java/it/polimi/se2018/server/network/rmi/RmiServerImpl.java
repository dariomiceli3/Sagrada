package it.polimi.se2018.server.network.rmi;


import it.polimi.se2018.client.ClientInterface;
import it.polimi.se2018.client.network.rmi.RmiClientInterface;
import it.polimi.se2018.server.Server;
import it.polimi.se2018.server.model.Events.ClientServer.*;
import it.polimi.se2018.server.model.Events.Event;
import it.polimi.se2018.server.model.Events.SinglePlayer.SinglePlayerEvent;
import it.polimi.se2018.server.model.Events.SinglePlayer.SinglePlayerRequestEvent;
import it.polimi.se2018.server.model.Events.SinglePlayer.ToolCardSinglePlayerStartEvent;
import it.polimi.se2018.server.model.Events.SinglePlayer.ToolNumberEvent;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RmiServerImpl extends UnicastRemoteObject implements RmiServerInterface {

    private Server server;
    private List<VirtualRmi> clientsRmi;

    public RmiServerImpl(Server server) throws RemoteException {
        super(0);
        this.server = server;
        this.clientsRmi = new ArrayList<>();

    }

    public void sendEventVirtual(int id, Event event) {
        for (VirtualRmi virtualRmi : clientsRmi) {
            if (virtualRmi.getPlayerID() == id) {
                virtualRmi.sendEventController(event);
            }
        }
    }

    /*public void sendEventVirtualNoID(Event event) {
        for (VirtualRmi virtualRmi : clientsRmi) {
            virtualRmi.sendEventController(event);
        }
    }*/


    @Override
    public void registerRmiClient(RmiClientInterface clientRmi) {
        server.addRmiClient(clientRmi, this);

    }

    @Override
    public void addToClientsRmiImpl(VirtualRmi virtualRmi) {
        clientsRmi.add(virtualRmi);
    }

    // ovveride dei metodi dell'interfaccia che poi chiamano metodo che agisce sul controller

    @Override
    public void setSinglePlayerMode(int id, boolean singlePlayer) throws RemoteException {
        sendEventVirtual(id, new SinglePlayerEvent(id, singlePlayer));
    }



    @Override
    public void setPlayerNameToServer(String username, int iD) throws RemoteException {
        sendEventVirtual(iD, new PlayerNameEvent(username, iD));

    }

    @Override
    public void setPatternCardToServer(int indexPatternChoose, int ID) throws RemoteException {
        sendEventVirtual(ID, new PlayerPatternEvent(ID, indexPatternChoose));

    }

    @Override
    public void setDraftPoolToServer(int ID) throws RemoteException {
        sendEventVirtual(ID, new PlayerDraftPoolEvent());

    }

    @Override
    public void setChooseToServer(int ID, int step) throws RemoteException {
        sendEventVirtual(ID, new PlayerChooseEvent(step));

    }

    @Override
    public void setMoveToServer(int ID, int indexPool, int indexPattern) throws RemoteException {
        sendEventVirtual(ID, new PlayerMoveEvent(indexPool, indexPattern));

    }

    @Override
    public void setStartToolToServer(int ID) throws RemoteException {
        sendEventVirtual(ID, new PlayerStartToolEvent());

    }

    @Override
    public void setNextTurnToServer(int ID) throws RemoteException {
        sendEventVirtual(ID, new PlayerNextTurnEvent());

    }

    @Override
    public void setNoTokenToServer(int ID) throws RemoteException {
        sendEventVirtual(ID, new PlayerNoTokenEvent());

    }

    @Override
    public void useToolCardToServer(int id, int indexTool) throws RemoteException {
        sendEventVirtual(id, new ToolCardStartEvent(indexTool));

    }

    @Override
    public void useGrozingToolCard(int ID, int indexPool, int increase) throws RemoteException {
        sendEventVirtual(ID, new GrozingPliersEvent(indexPool, increase));
    }

    @Override
    public void useEglomiseToolCard(int ID, int indexStart, int indexEnd) throws RemoteException {
        sendEventVirtual(ID, new EglomiseBrushEvent(indexStart, indexEnd));
    }

    @Override
    public void useCopperFoilToolCard(int ID, int indexStart, int indexEnd) throws RemoteException {
        sendEventVirtual(ID, new CopperFoilEvent(indexStart, indexEnd));
    }

    @Override
    public void useLathekinToolCard(int ID, int indexStartOne, int indexEndOne, int indexStartTwo, int indexEndTwo) throws RemoteException {
        sendEventVirtual(ID, new LathekinEvent(indexStartOne, indexEndOne, indexStartTwo, indexEndTwo));
    }

    @Override
    public void useLensCutterToolCard(int ID, int indexPool, int indexRound, int indexPosition) throws RemoteException {
        sendEventVirtual(ID, new LensCutterEvent(indexPool, indexRound, indexPosition));
    }

    @Override
    public void useFluxBrushToolCard(int ID, int indexPool) throws RemoteException {
        sendEventVirtual(ID, new FluxBrushEvent(indexPool));
    }

    @Override
    public void useGlazingHammerToolCard(int ID) throws RemoteException {
        sendEventVirtual(ID, new GlazingHammerEvent());
    }

    @Override
    public void useRunningPliersToolCard(int ID, int indexPool, int indexPattern) throws RemoteException {
        sendEventVirtual(ID, new RunningPliersEvent(indexPool, indexPattern));
    }

    @Override
    public void useCorkBackedToolCard(int ID, int indexPool, int indexPattern) throws RemoteException {
        sendEventVirtual(ID, new CorkBackedEvent(indexPool, indexPattern));
    }

    @Override
    public void useGrindingStoneToolCard(int ID, int indexPool) throws RemoteException {
        sendEventVirtual(ID, new GrindingStoneEvent(indexPool));
    }

    @Override
    public void useFluxRemoverToolCard(int ID, int indexPool, int diceValue) throws RemoteException {
        sendEventVirtual(ID, new FluxRemoverEvent(indexPool, diceValue));
    }

    @Override
    public void useTapWheelToolCard(int ID, int number, int indexStartOne, int indexEndOne, int indexStartTwo, int indexEndTwo) throws RemoteException {
        sendEventVirtual(ID, new TapWheelEvent(number, indexStartOne, indexEndOne, indexStartTwo, indexEndTwo));
    }

    //---------------------------single player methods-------------------------------------------

    @Override
    public void setDifficultyToServer(int ID, int difficulty) throws RemoteException {
        sendEventVirtual(ID, new ToolNumberEvent(difficulty));
    }

    @Override
    public void useToolSingleToServer(int ID, int indexTool, int indexPool) throws RemoteException {
        sendEventVirtual(ID, new ToolCardSinglePlayerStartEvent(indexTool, indexPool));
    }


}


