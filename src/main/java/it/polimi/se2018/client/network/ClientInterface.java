package it.polimi.se2018.client.network;

import it.polimi.se2018.server.model.Cards.PatternCard;

public interface ClientInterface {

    void setSinglePlayerMode(int id, boolean singlePlayer);

    void setPlayerNameToServer(String username, int id);

    void setPatternCardToServer(int indexPatternChoose, int id);

    void setDraftPoolToServer(int id);

    void setChooseToServer(int id, int step);

    void setMoveToServer(int id, int indexPool, int indexPattern);

    void setStartToolToServer(int id);

    void setNextTurnToServer(int id);

    void setNoTokenToServer(int id);

    void useToolCardToServer(int id, int indexTool);

    void useGrozingToolCard(int id, int indexPool, int increase);

    void useEglomiseToolCard(int id, int indexStart, int indexEnd);

    void useCopperFoilToolCard(int id, int indexStart, int indexEnd);

    void useLathekinToolCard(int id, int indexStartOne, int indexEndOne, int indexStartTwo, int indexEndTwo);

    void useLensCutterToolCard(int id, int indexPool, int indexRound, int indexPosition);

    void useFluxBrushToolCard(int id, int indexPool);

    void useGlazingHammerToolCard(int id);

    void useRunningPliersToolCard(int id, int indexPool, int indexPattern);

    void useCorkBackedToolCard(int id, int indexPool, int indexPattern);

    void useGrindingStoneToolCard(int id, int indexPool);

    void useFluxRemoverToolCard(int id, int indexPool, int diceValue);

    void useTapWheelToolCard(int id, int number, int indexStartOne, int indexEndOne, int indexStartTwo, int indexEndTwo);

    void setEndGameTimer(int id);

    //-------------------------single player mode

    void setDifficultyToServer(int id, int difficulty);

    void useToolSingleToServer(int id, int indexTool, int indexPool);

    //-------------------------custom card

    void setPatternCustomToServer(int id, PatternCard patternCard);

    //-----------------------disconnection

    void setExitToServer(int id);

    void setReconnectToServer(int id);



}
