package it.polimi.se2018.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInterface extends Remote {

    // metodi chiamabili lato client

    public void setPlayerName(String username) throws RemoteException;




}
