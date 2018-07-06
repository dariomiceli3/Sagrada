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

    /**
     * method that add an rmi client to the list of clients in the server
     * @param clientRmi that have to be added
     * @throws RemoteException if something goes wrong
     */
    void registerRmiClient(RmiClientInterface clientRmi) throws RemoteException;

    /**
     * method that add to the server an rmi virtual to the list of the rmi clients
     * @param virtualRmi that have to be added
     * @throws RemoteException if something goes wrong
     */
    void addToClientsRmiImpl(VirtualRmi virtualRmi) throws RemoteException;

    /**
     * method that set to the server if the game mode chose is single player or not
     * @param id of the player
     * @param singlePlayer mode game
     * @throws RemoteException if something goes wrong
     */
    void setSinglePlayerMode(int id, boolean singlePlayer) throws RemoteException;

    /**
     * method that set to the server the name of the player with the id obtained as parameter
     * @param username name to set
     * @param id of the player
     * @throws RemoteException if something goes wrong
     */
    void setPlayerNameToServer(String username, int id) throws RemoteException;

    /**
     * method that set to the server the Pattern Card used by the player for the rest of the game
     * @param indexPatternChoose index of the player's pattern card list
     * @param id of the player
     * @throws RemoteException if something goes wrong
     */
    void setPatternCardToServer(int indexPatternChoose, int id) throws RemoteException;

    /**
     * method that alert to the server to roll the draft pool
     * @param id of the player
     * @throws RemoteException if something goes wrong
     */
    void setDraftPoolToServer(int id) throws RemoteException;

    /**
     * method that set to the server the choose of the first move of the player with that id
     * @param id of the player
     * @param step first move chose of the player
     * @throws RemoteException if something goes wrong
     */
    void setChooseToServer(int id, int step) throws RemoteException;

    /**
     * method that set to the server the move of a dice to the pattern done by the player
     * @param id of the player
     * @param indexPool index of the dice in the draft pool
     * @param indexPattern index of the box of the pattern card
     * @throws RemoteException if something goes wrong
     */
    void setMoveToServer(int id, int indexPool, int indexPattern) throws RemoteException;

    /**
     * method that alert to the server that the player decided to use a tool card
     * @param id of the player
     * @throws RemoteException if something goes wrong
     */
    void setStartToolToServer(int id) throws RemoteException;

    /**
     * method that alert of the next turn to the server
     * @param id of the player
     * @throws RemoteException if something goes wrong
     */
    void setNextTurnToServer(int id) throws RemoteException;

    /**
     * method that alert to the server that the player decided to not perform a tool card move
     * because of the cost
     * @param id player id
     * @throws RemoteException if something goes wrong
     */
    void setNoTokenToServer(int id) throws RemoteException;

    /**
     * method that alert to the server that the player decided to use the tool card obtained as parameter
     * @param id of the player
     * @param indexTool index of the tool card list
     * @throws RemoteException if something goes wrong
     */
    void useToolCardToServer(int id, int indexTool) throws RemoteException;

    /**
     * method that set to the server the player uses the Grozing Pliers tool card
     * @param id of the player
     * @param indexPool index of the dice in the draft pool
     * @param increase increase or decrease decision of the player
     * @throws RemoteException if something goes wrong
     */
    void useGrozingToolCard(int id, int indexPool, int increase) throws RemoteException;

    /**
     * method that set to the server the player uses the Eglomise Brush tool card
     * @param id of the player
     * @param indexStart index of the dice to move
     * @param indexEnd index of where to move the dice
     * @throws RemoteException if something goes wrong
     */
    void useEglomiseToolCard(int id, int indexStart, int indexEnd) throws RemoteException;

    /**
     * method that set to the server the player uses the Copper Foil Burnisher tool card
     * @param id of the player
     * @param indexStart index of the dice to move
     * @param indexEnd index of where to move the dice
     * @throws RemoteException if something goes wrong
     */
    void useCopperFoilToolCard(int id, int indexStart, int indexEnd) throws RemoteException;

    /**
     * method that set to the server the player uses Lathekin tool card
     * @param id of the player
     * @param indexStartOne index of the first dice to move
     * @param indexEndOne index of where to move the first dice
     * @param indexStartTwo index of the second dice to move
     * @param indexEndTwo index of where to move the second dice
     * @throws RemoteException if something goes wrong
     */
    void useLathekinToolCard(int id, int indexStartOne, int indexEndOne, int indexStartTwo, int indexEndTwo) throws RemoteException;

    /**
     * method that set to the server the player uses Lens Cutter tool card
     * @param id of the player
     * @param indexPool index of the dice in the draft pool
     * @param indexRound index of the round
     * @param indexPosition index of the position of the dice in the round list
     * @throws RemoteException if something goes wrong
     */
    void useLensCutterToolCard(int id, int indexPool, int indexRound, int indexPosition) throws RemoteException;

    /**
     * method that set to the server the player uses Flux Brush tool card
     * @param id of the player
     * @param indexPool index of the dice in the draft pool
     * @throws RemoteException if something goes wrong
     */
    void useFluxBrushToolCard(int id, int indexPool) throws RemoteException;

    /**
     * method that set to the server the player uses Glazing Hammer tool card
     * @param id of the player
     * @throws RemoteException if something goes wrong
     */
    void useGlazingHammerToolCard(int id) throws RemoteException;

    /**
     * method that set to the server the player uses Running Pliers tool cad
     * @param id of the player
     * @param indexPool index of the dice in the draft pool
     * @param indexPattern index of the box of the pattern card
     * @throws RemoteException if something goes wrong
     */
    void useRunningPliersToolCard(int id, int indexPool, int indexPattern) throws RemoteException;

    /**
     * method that set to the server the player uses Cork Backed tool card
     * @param id of the player
     * @param indexPool index of the dice in the draft pool
     * @param indexPattern index of the box of the pattern card
     * @throws RemoteException if something goes wrong
     */
    void useCorkBackedToolCard(int id, int indexPool, int indexPattern) throws RemoteException;

    /**
     * method that set to the server the player uses Grinding Stone tool card
     * @param id of the player
     * @param indexPool index of the dice in the draft pool
     * @throws RemoteException if something goes wrong
     */
    void useGrindingStoneToolCard(int id, int indexPool) throws RemoteException;

    /**
     * method that set to the server the player uses Flux Remover tool card
     * @param id of the player
     * @param indexPool index of the dice in the draft pool
     * @param diceValue the value to change the dice
     * @throws RemoteException if something goes wrong
     */
    void useFluxRemoverToolCard(int id, int indexPool, int diceValue) throws RemoteException;

    /**
     * method that set to the server the player uses Tap Wheel tool card
     * @param id of the player
     * @param number of dice to move
     * @param indexStartOne index of the first dice to move
     * @param indexEndOne index where to move the first dice
     * @param indexStartTwo index of the second dice to move
     * @param indexEndTwo index where to move the second dice
     * @throws RemoteException if something goes wrong
     */
    void useTapWheelToolCard(int id, int number, int indexStartOne, int indexEndOne, int indexStartTwo, int indexEndTwo) throws RemoteException;

    /**
     * method that alert to the server the end of timer
     * @param id of the player
     * @throws RemoteException if something goes wrong
     */
    void setEndGameTimer(int id) throws RemoteException;

    //-------------------------single player mode

    /**
     * method that set to the server the difficulty of the single player game mode
     * @param id of the player
     * @param difficulty value of the difficulty
     * @throws RemoteException if something goes wrong
     */
    void setDifficultyToServer(int id, int difficulty) throws RemoteException;

    /**
     * method that set to server that the player use a tool card
     * @param id of the player
     * @param indexTool index of the tool card in tool card list
     * @param indexPool index of the the dice in the draft pool
     * @throws RemoteException if something goes wrong
     */
    void useToolSingleToServer(int id, int indexTool, int indexPool) throws RemoteException;

    //-------------------------custom card

    /**
     * method to set to the server the custom pattern used by the player
     * @param id player id
     * @param patternCard pattern card to set to the player
     * @throws RemoteException if something goes wrong
     */
    void setPatternCustomToServer(int id, PatternCard patternCard) throws RemoteException;

    //-------------------------disconnection

    /**
     * method to set to the server the player exit the game
     * @param id of the player
     * @throws RemoteException if something goes wrong
     */
    void setExitToServer(int id) throws RemoteException;


    /**
     * method to set to the server the player reconnect to the game
     * @param id of the player
     * @throws RemoteException if something goes wrong
     */
    void setReconnectToServer(int id) throws RemoteException;

    /**
     * method to set to the server the client is pinging the server
     * @param id of the player
     * @throws RemoteException if something goes wrong
     */
    void clientPing(int id) throws RemoteException;

}
