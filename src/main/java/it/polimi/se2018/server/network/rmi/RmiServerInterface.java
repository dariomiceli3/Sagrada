package it.polimi.se2018.server.network.rmi;

import it.polimi.se2018.client.network.rmi.RmiClientInterface;
import it.polimi.se2018.server.model.Cards.PatternCard;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RmiServerInterface extends Remote {

    // segnature metodi della client interface + registerRMIClient

    public void registerRmiClient(RmiClientInterface clientRmi) throws RemoteException;

    public void addToClientsRmiImpl(VirtualRmi virtualRmi) throws RemoteException;

    public void setSinglePlayerMode(int id, boolean singlePlayer) throws RemoteException;

    public void setPlayerNameToServer(String username, int iD) throws RemoteException;

    public void setPatternCardToServer(int indexPatternChoose, int ID) throws RemoteException;

    public void setDraftPoolToServer(int ID) throws RemoteException;

    public void setChooseToServer(int ID, int step) throws RemoteException;

    public void setMoveToServer(int ID, int indexPool, int indexPattern) throws RemoteException;

    public void setStartToolToServer(int ID) throws RemoteException;

    public void setNextTurnToServer(int ID) throws RemoteException;

    public void setNoTokenToServer(int ID) throws RemoteException;

    public void useToolCardToServer(int id, int indexTool) throws RemoteException;

    public void useGrozingToolCard(int ID, int indexPool, int increase) throws RemoteException;

    public void useEglomiseToolCard(int ID, int indexStart, int indexEnd) throws RemoteException;

    public void useCopperFoilToolCard(int ID, int indexStart, int indexEnd) throws RemoteException;

    public void useLathekinToolCard(int ID, int indexStartOne, int indexEndOne, int indexStartTwo, int indexEndTwo) throws RemoteException;

    public void useLensCutterToolCard(int ID, int indexPool, int indexRound, int indexPosition) throws RemoteException;

    public void useFluxBrushToolCard(int ID, int indexPool) throws RemoteException;

    public void useGlazingHammerToolCard(int ID) throws RemoteException;

    public void useRunningPliersToolCard(int ID, int indexPool, int indexPattern) throws RemoteException;

    public void useCorkBackedToolCard(int ID, int indexPool, int indexPattern) throws RemoteException;

    public void useGrindingStoneToolCard(int ID, int indexPool) throws RemoteException;

    public void useFluxRemoverToolCard(int ID, int indexPool, int diceValue) throws RemoteException;

    public void useTapWheelToolCard(int ID, int number, int indexStartOne, int indexEndOne, int indexStartTwo, int indexEndTwo) throws RemoteException;

    public void setEndGameTimer(int ID) throws RemoteException;

    //-------------------------single player mode

    public void setDifficultyToServer(int ID, int difficulty) throws RemoteException;

    public void useToolSingleToServer(int ID, int indexTool, int indexPool) throws RemoteException;

    //-------------------------custom card

    public void setPatternCustomToServer(int ID, PatternCard patternCard) throws RemoteException;

    //-------------------------disconnection

    public void setExitToServer(int ID) throws RemoteException;

    public void setReconnectToServer(int ID) throws RemoteException;

    public void clientPing(int ID) throws RemoteException;

}
