package it.polimi.se2018.server.network.rmi;

import it.polimi.se2018.client.network.rmi.RmiClientInterface;
import it.polimi.se2018.server.model.Cards.PatternCard;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * interface RmiServerInterface : the interface have the same method signature of the ClientInterface, and it's
 * necessary to enable the remote call of the client on the Server
 * @author fadda-miceli-mundo
 */
public interface RmiServerInterface extends Remote {

    void registerRmiClient(RmiClientInterface clientRmi) throws RemoteException;

    void addToClientsRmiImpl(VirtualRmi virtualRmi) throws RemoteException;

    void setSinglePlayerMode(int id, boolean singlePlayer) throws RemoteException;

    void setPlayerNameToServer(String username, int id) throws RemoteException;

    void setPatternCardToServer(int indexPatternChoose, int id) throws RemoteException;

    void setDraftPoolToServer(int id) throws RemoteException;

    void setChooseToServer(int id, int step) throws RemoteException;

    void setMoveToServer(int id, int indexPool, int indexPattern) throws RemoteException;

    void setStartToolToServer(int id) throws RemoteException;

    void setNextTurnToServer(int id) throws RemoteException;

    void setNoTokenToServer(int id) throws RemoteException;

    void useToolCardToServer(int id, int indexTool) throws RemoteException;

    void useGrozingToolCard(int id, int indexPool, int increase) throws RemoteException;

    void useEglomiseToolCard(int id, int indexStart, int indexEnd) throws RemoteException;

    void useCopperFoilToolCard(int id, int indexStart, int indexEnd) throws RemoteException;

    void useLathekinToolCard(int id, int indexStartOne, int indexEndOne, int indexStartTwo, int indexEndTwo) throws RemoteException;

    void useLensCutterToolCard(int id, int indexPool, int indexRound, int indexPosition) throws RemoteException;

    void useFluxBrushToolCard(int id, int indexPool) throws RemoteException;

    void useGlazingHammerToolCard(int id) throws RemoteException;

    void useRunningPliersToolCard(int id, int indexPool, int indexPattern) throws RemoteException;

    void useCorkBackedToolCard(int id, int indexPool, int indexPattern) throws RemoteException;

    void useGrindingStoneToolCard(int id, int indexPool) throws RemoteException;

    void useFluxRemoverToolCard(int id, int indexPool, int diceValue) throws RemoteException;

    void useTapWheelToolCard(int id, int number, int indexStartOne, int indexEndOne, int indexStartTwo, int indexEndTwo) throws RemoteException;

    void setEndGameTimer(int id) throws RemoteException;

    //-------------------------single player mode

    void setDifficultyToServer(int id, int difficulty) throws RemoteException;

    void useToolSingleToServer(int id, int indexTool, int indexPool) throws RemoteException;

    //-------------------------custom card

    void setPatternCustomToServer(int id, PatternCard patternCard) throws RemoteException;

    //-------------------------disconnection

    void setExitToServer(int id) throws RemoteException;

    void setReconnectToServer(int id) throws RemoteException;

    void clientPing(int id) throws RemoteException;

}
