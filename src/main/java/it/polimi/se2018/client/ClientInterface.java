package it.polimi.se2018.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInterface extends Remote {

    // metodi chiamabili lato client per inoltrare poi gli eventi

    public void setPlayerNameToServer(String username, int iD) throws RemoteException;




}
