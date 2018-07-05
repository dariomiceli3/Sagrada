package it.polimi.se2018.client.network;

import it.polimi.se2018.server.model.Cards.PatternCard;

/**
 * interface ClientInterface: interface that represent all the possible input that the client can send to the server, it
 * has all the method signature that the classes that implements the interface have to respect.
 * @author  fadda=-miceli-mundo
 */
public interface ClientInterface {

    /**
     * method that set to the server if the game mode chose is single player or not
     * @param id of the player
     * @param singlePlayer mode game
     */
    void setSinglePlayerMode(int id, boolean singlePlayer);

    /**
     * method that set to the server the name of the player with the id passed as parameter
     * @param username name to set
     * @param id of the player
     */
    void setPlayerNameToServer(String username, int id);

    /**
     * method that set to the server the Pattern Card used by the player for the rest of the game
     * @param indexPatternChoose index of the player's pattern  card list
     * @param id of the player
     */
    void setPatternCardToServer(int indexPatternChoose, int id);

    /**
     * method that alert to the server to roll the draft pool
     * @param id of the player
     */
    void setDraftPoolToServer(int id);

    /**
     * method that set to the server the choose of the first move of the player with that id
     * @param id of the player
     * @param step first move chose of the player
     */
    void setChooseToServer(int id, int step);

    /**
     * method that set to the server the move of a dice to the pattern done by the player
     * @param id of the player
     * @param indexPool index of the dice in the draft pool
     * @param indexPattern index of the box of the pattern card
     */
    void setMoveToServer(int id, int indexPool, int indexPattern);

    /**
     * method that alert to the server that the player decided to use a tool card
     * @param id of the player
     */
    void setStartToolToServer(int id);

    /**
     * method that alert of the next turn to the server
     * @param id of the player
     */
    void setNextTurnToServer(int id);

    /**
     * method that alert to the server that the player decided to not perform a tool card move because of the cost
     * @param id player id
     */
    void setNoTokenToServer(int id);

    /**
     * method that alert to the server that the player decided to use the tool card obtained as parameter
     * @param id of the player
     * @param indexTool index of the tool card list
     */
    void useToolCardToServer(int id, int indexTool);

    /**
     * method that set to the server the player uses the Grozing Pliers tool card
     * @param id of the player
     * @param indexPool index of the dice in the draft pool
     * @param increase increase or decrease decision of the player
     */
    void useGrozingToolCard(int id, int indexPool, int increase);

    /**
     * method that set to the server the player uses the Eglomise Brush tool card
     * @param id of the player
     * @param indexStart index of the dice to move
     * @param indexEnd index of where to move the dice
     */
    void useEglomiseToolCard(int id, int indexStart, int indexEnd);

    /**
     * method that set to the server the player uses the Copper Foil Burnisher tool card
     * @param id of the player
     * @param indexStart index of the dice to move
     * @param indexEnd index of where to move the dice
     */
    void useCopperFoilToolCard(int id, int indexStart, int indexEnd);

    /**
     * method that set to the server the player uses Lathekin tool card
     * @param id of the player
     * @param indexStartOne index of the first dice to move
     * @param indexEndOne index of where to move the first dice
     * @param indexStartTwo index of the second dice to move
     * @param indexEndTwo index of where to move the second dice
     */
    void useLathekinToolCard(int id, int indexStartOne, int indexEndOne, int indexStartTwo, int indexEndTwo);

    /**
     * method that set to the server the player uses Lens Cutter tool card
     * @param id of the player
     * @param indexPool index of the dice in the draft pool
     * @param indexRound index of the round
     * @param indexPosition index of the position of the dice in the round list
     */
    void useLensCutterToolCard(int id, int indexPool, int indexRound, int indexPosition);

    /**
     * method that set to the server the player uses Flux Brush tool card
     * @param id of the player
     * @param indexPool index of the dice in the draft pool
     */
    void useFluxBrushToolCard(int id, int indexPool);

    /**
     * method that set to the server the player uses Glazing Hammer tool card
     * @param id of the player
     */
    void useGlazingHammerToolCard(int id);

    /**
     * method that set to the server the player uses Running Pliers tool cad
     * @param id of the player
     * @param indexPool index of the dice in the draft pool
     * @param indexPattern index of the box of the pattern card
     */
    void useRunningPliersToolCard(int id, int indexPool, int indexPattern);

    /**
     * method that set to the server the player uses Cork Backed tool card
     * @param id of the player
     * @param indexPool index of the dice in the draft pool
     * @param indexPattern index of the box of the pattern card
     */
    void useCorkBackedToolCard(int id, int indexPool, int indexPattern);

    /**
     * method that set to the server the player uses Grinding Stone tool card
     * @param id of the player
     * @param indexPool index of the dice in the draft pool
     */
    void useGrindingStoneToolCard(int id, int indexPool);

    /**
     * method that set to the server the player uses Flux Remover tool card
     * @param id of the player
     * @param indexPool index of the dice in the draft pool
     * @param diceValue the value to change the dice
     */
    void useFluxRemoverToolCard(int id, int indexPool, int diceValue);

    /**
     * method that set to the server the player uses Tap Wheel tool card
     * @param id of the player
     * @param number of dice to move
     * @param indexStartOne index of the first dice to move
     * @param indexEndOne index where to move the first dice
     * @param indexStartTwo index of the second dice to move
     * @param indexEndTwo index where to move the second dice
     */
    void useTapWheelToolCard(int id, int number, int indexStartOne, int indexEndOne, int indexStartTwo, int indexEndTwo);

    /**
     * method that alert to the server the end of timer
     * @param id of the player
     */
    void setEndGameTimer(int id);

    //-------------------------single player mode---------------------------------------------------------------------

    /**
     * method that set to the server the difficulty of the single player game mode
     * @param id of the player
     * @param difficulty value of the difficulty
     */
    void setDifficultyToServer(int id, int difficulty);

    /**
     * method that set to server that the player use a tool card
     * @param id of the player
     * @param indexTool index of the tool card in tool card list
     * @param indexPool index of the the dice in the draft pool
     */
    void useToolSingleToServer(int id, int indexTool, int indexPool);

    //-------------------------custom card---------------------------------------------------------------------------

    /**
     * method to set to the server the custom pattern used by the player
     * @param id player id
     * @param patternCard pattern card to set to the player
     */
    void setPatternCustomToServer(int id, PatternCard patternCard);

    //-----------------------disconnection---------------------------------------------------------------------------


    /**
     * method to set to the server the player exit the game
     * @param id of the player
     */
    void setExitToServer(int id);

    /**
     * method to set to the server the player reconnect to the game
     * @param id of the player
     */
    void setReconnectToServer(int id);

}
