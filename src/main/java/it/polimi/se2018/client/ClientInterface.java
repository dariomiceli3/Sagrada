package it.polimi.se2018.client;

import it.polimi.se2018.server.model.Cards.PatternCard;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInterface extends Remote {

    public void setPlayerNameToServer(String username, int iD) throws RemoteException;

    public void setPatternCardToServer(PatternCard patternCard, int ID) throws RemoteException;

    public void setDraftPoolToServer() throws RemoteException;

    public void setChooseToServer(int step) throws RemoteException;

    public void setMoveToServer(int indexPool, int indexPattern) throws RemoteException;

    public void setStartToolToServer() throws RemoteException;

    public void setNextTurnToServer() throws RemoteException;

    public void setNoTokenToServer() throws RemoteException;

    public void useToolCardToServer(int id) throws RemoteException;

    public void useGrozingToolCard(int indexPool, int increase) throws RemoteException;

    public void useEglomiseToolCard(int indexStart, int indexEnd) throws RemoteException;

    public void useCopperFoilToolCard(int indexStart, int indexEnd) throws RemoteException;

    public void useLathekinToolCard(int indexStartOne, int indexEndOne, int indexStartTwo, int indexEndTwo) throws RemoteException;

    public void useLensCutterToolCard(int indexPool, int indexRound, int indexPosition) throws RemoteException;

    public void useFluxBrushToolCard(int indexPool) throws RemoteException;

    public void useGlazingHammerToolCard() throws RemoteException;

    public void useRunningPliersToolCard(int indexPool, int indexPattern) throws RemoteException;

    public void useCorkBackedToolCard(int indexPool, int indexPattern) throws RemoteException;

    public void useGrindingStoneToolCard(int indexPool) throws RemoteException;

    public void useFluxRemoverToolCard(int indexPool, int diceValue) throws RemoteException;

    public void useTapWheelToolCard(int number, int indexStartOne, int indexEndOne, int indexStartTwo, int indexEndTwo) throws RemoteException;

    //-------------------------single player mode

    public void setSinglePlayerMode(int id, boolean singlePlayer) throws RemoteException;

    public void setDifficultyToServer(int difficulty) throws RemoteException;



}
