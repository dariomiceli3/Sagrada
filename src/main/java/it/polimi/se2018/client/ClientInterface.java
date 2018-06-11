package it.polimi.se2018.client;

import it.polimi.se2018.server.model.Cards.PatternCard;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInterface {

    public void setPlayerNameToServer(String username, int iD);

    public void setPatternCardToServer(int indexPatternChoose, int ID);

    public void setDraftPoolToServer();

    public void setChooseToServer(int step);

    public void setMoveToServer(int indexPool, int indexPattern);

    public void setStartToolToServer();

    public void setNextTurnToServer();

    public void setNoTokenToServer();

    public void useToolCardToServer(int id);

    public void useGrozingToolCard(int indexPool, int increase);

    public void useEglomiseToolCard(int indexStart, int indexEnd);

    public void useCopperFoilToolCard(int indexStart, int indexEnd);

    public void useLathekinToolCard(int indexStartOne, int indexEndOne, int indexStartTwo, int indexEndTwo);

    public void useLensCutterToolCard(int indexPool, int indexRound, int indexPosition);

    public void useFluxBrushToolCard(int indexPool);

    public void useGlazingHammerToolCard();

    public void useRunningPliersToolCard(int indexPool, int indexPattern);

    public void useCorkBackedToolCard(int indexPool, int indexPattern);

    public void useGrindingStoneToolCard(int indexPool);

    public void useFluxRemoverToolCard(int indexPool, int diceValue);

    public void useTapWheelToolCard(int number, int indexStartOne, int indexEndOne, int indexStartTwo, int indexEndTwo);

    //-------------------------single player mode

    public void setSinglePlayerMode(int id, boolean singlePlayer);

    public void setDifficultyToServer(int difficulty);

    public void useToolSingleToServer(int indexTool, int indexPool);



}
