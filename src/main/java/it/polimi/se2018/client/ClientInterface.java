package it.polimi.se2018.client;

import it.polimi.se2018.server.model.Cards.PatternCard;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInterface {

    public void setSinglePlayerMode(int id, boolean singlePlayer);

    public void setPlayerNameToServer(String username, int iD);

    public void setPatternCardToServer(int indexPatternChoose, int ID);

    public void setDraftPoolToServer(int ID);

    public void setChooseToServer(int ID, int step);

    public void setMoveToServer(int ID, int indexPool, int indexPattern);

    public void setStartToolToServer(int ID);

    public void setNextTurnToServer(int ID);

    public void setNoTokenToServer(int ID);

    public void useToolCardToServer(int id, int indexTool);

    public void useGrozingToolCard(int ID, int indexPool, int increase);

    public void useEglomiseToolCard(int ID, int indexStart, int indexEnd);

    public void useCopperFoilToolCard(int ID, int indexStart, int indexEnd);

    public void useLathekinToolCard(int ID, int indexStartOne, int indexEndOne, int indexStartTwo, int indexEndTwo);

    public void useLensCutterToolCard(int ID, int indexPool, int indexRound, int indexPosition);

    public void useFluxBrushToolCard(int ID, int indexPool);

    public void useGlazingHammerToolCard(int ID);

    public void useRunningPliersToolCard(int ID, int indexPool, int indexPattern);

    public void useCorkBackedToolCard(int ID, int indexPool, int indexPattern);

    public void useGrindingStoneToolCard(int ID, int indexPool);

    public void useFluxRemoverToolCard(int ID, int indexPool, int diceValue);

    public void useTapWheelToolCard(int ID, int number, int indexStartOne, int indexEndOne, int indexStartTwo, int indexEndTwo);

    public void setEndGameTimer(int ID);

    //-------------------------single player mode

    public void setDifficultyToServer(int ID, int difficulty);

    public void useToolSingleToServer(int ID, int indexTool, int indexPool);

    //-------------------------custom card

    public void setPatternCustomToServer(int ID, PatternCard patternCard);



}
