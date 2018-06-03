package it.polimi.se2018.client;

import it.polimi.se2018.server.model.Cards.PatternCard;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInterface extends Remote {

    // metodi chiamabili lato client per inoltrare poi gli eventi

    public void setPlayerNameToServer(String username, int iD) throws RemoteException;

    public void setPatternCardToServer(PatternCard patternCard, int ID) throws RemoteException;

    public void setDraftPoolToServer() throws RemoteException;

    public void setMoveToServer(int indexPool, int indexPattern) throws RemoteException;


}
