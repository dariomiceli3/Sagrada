package it.polimi.se2018.client;

import it.polimi.se2018.server.model.Cards.PatternCard;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInterface extends Remote {

    public void setPlayerNameToServer(String username, int iD) throws RemoteException;

    public void setPatternCardToServer(PatternCard patternCard, int ID) throws RemoteException;

    public void setDraftPoolToServer() throws RemoteException;

    public void setMoveToServer(int indexPool, int indexPattern) throws RemoteException;

    public void setStartToolToServer();

    public void setNextTurnToServer() throws RemoteException;

    public void useToolCardToServer(int id) throws RemoteException;

    public void useGrozingToolCard(int indexPool) throws RemoteException;



}
