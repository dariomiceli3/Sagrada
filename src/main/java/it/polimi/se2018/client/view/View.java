package it.polimi.se2018.client.view;

import it.polimi.se2018.client.network.ClientInterface;
import it.polimi.se2018.server.model.Cards.ToolCard;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.PublicObjectiveCard;
import it.polimi.se2018.server.model.Components.*;

import java.io.IOException;
import java.util.List;

/**
 * Class View: // todo adriano
 * @author fadda-miceli-mundo
 * @see Runnable
 */
public abstract class View implements Runnable {

    //qui metodi generici comportamentabili, ovveride nelle varie view e chiamati da fuori

    private String playerName;
    private boolean isStarted;
    protected int playerID;

    /**
     * method that provides the caller the name of the player
     * @return name of the player
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * method that indicates if the game is started or not
     * @return boolean
     */
    protected boolean isStarted() {
        return isStarted;
    }

    /**
     * method that provides the caller the id of the player
     * @return id of the player
     */
    public int getPlayerID() {
        return playerID;
    }

    /**
     * method that allows to set the id of the player
     * @param playerID id of the player
     */
    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    /**
     * method that allows to set the name of the view
     * @param nameView name of the view
     */
    public void setNameView(String nameView) {
        this.playerName = nameView;
    }

    /**
     * method that allows to set if the game is started or not
     * @param isStarted boolean
     */
    public void setStarted(boolean isStarted) {
        this.isStarted = isStarted;
    }

    //---------------------- abstract method , which implementation depends on the view (cli or gui)

    /**
     * method that provides the caller the connection
     * @return clientConnection
     */
    public abstract ClientInterface getConnection();

    /**
     * method that allows to set the connection of the client
     * @param client client to set
     */
    public abstract void setConnection(ClientInterface client);

    /**
     * method that allows to show the id of the player
     */
    public abstract void showID();

    /**
     * method that allows to show that the game is started
     */
    public abstract void showGameStarted();

    /**
     * method that allows to show the choise of the name
     */
    public abstract void showNameChoose();

    /**
     * method that allows to show the name
     */
    public abstract void showName();

    /**
     * method that allows to show the current name to the other players
     * @param name name of the current player
     */
    public abstract void showNameOther(String name);

    /**
     * method that allows to show that the current name is not permitted
     */
    public abstract void showNameError();

    /**
     *  method that allows to show the private card
     * @param privateObjectiveCard private card to show
     */
    public abstract void showPrivateCard(PrivateObjectiveCard privateObjectiveCard);

    /**
     *  method that allows to show the list of the public cards
     * @param publicList list of public cards
     * @throws IOException Something goes wrong
     */
    public abstract void showPublicCard(List<PublicObjectiveCard> publicList) throws IOException;

    /**
     * method that allows to show the list of the pattern cards
     * @param patternCards list of pattern cards
     * @throws IOException Something goes wrong
     */
    public abstract void showPatternList(List<PatternCard> patternCards) throws IOException;

    /**
     *  method that allows to show the pattern the player chose
     * @param patternCard pattern chosen by the player
     * @throws IOException Something goes wrong
     */
    public abstract void showPattern(PatternCard patternCard) throws IOException;

    /**
     *  method that allows to show the pattern during the game
     * @param patternCard pattern card of a player
     * @param playerName name of the player
     * @param id id of the player
     */
    public abstract void showOtherPattern(PatternCard patternCard, String playerName, int id);

    /**
     * method that allows to show the pattern of the current player to other players
     * @param patternCard pattern card chosen by the player
     * @param id id of the player
     */
    public abstract void showOtherStartPattern(PatternCard patternCard, int id);

    /**
     * method that allows to show update of a selected pattern card
     * @param patternCard pattern card of a player
     */
    public abstract void showPatternUpdate(PatternCard patternCard);

    /**
     * method that allows to show the tokens of a player
     * @param tokensNumber number of tokens
     */
    public abstract void showTokens(int tokensNumber);

    /**
     * method that allows to show the start of a scene
     * @throws IOException Something goes wrong
     */
    public abstract void showStartScene() throws IOException;

    /**
     * method that allows to show the current round during the game
     * @param round int round of the game
     */
    public abstract void showCurrentRound(int round);

    /**
     * method that allows to show the current turn during the game
     */
    public abstract void showCurrentTurn();

    /**
     * method that allows to show to the other players, the current turn of the selected player
     * @param username name of the selected player
     */
    public abstract void showOtherCurrentTurn(String username);

    /**
     * method that allows to show to the current player  the command to rool the draft pool
     */
    public abstract void showRollCommand();

    /**
     * method that allows to show the draft pool
     * @param draftPool draft pool of the game
     */
    public abstract void showDraftPool(DraftPool draftPool);

    /**
     * method that allows to show to the current player the command to choose
     */
    public abstract void showChooseCommand();

    /**
     * method that allows to show to the current player the command to move a dice
     * @param poolSize size of the pool
     */
    public abstract void showMoveCommand(int poolSize);

    /**
     * method that allows to show the index of the pool of the dice the player wants to move
     * @param poolSize size of the pool
     */
    public abstract void showIndexPoolCommand(int poolSize);

    /**
     * method that allows to show the index of the patten where the player wants to move the dice
     */
    public abstract void showIndexPatternCommand();

    /**
     * method that allows to show the command of the tool card
     * @param toolCards list of tool cards
     */
    public abstract void showToolCommand(List<ToolCard> toolCards);

    /**
     * method that allows to show the selected tool card by the player
     */
    public abstract void showToolChooseCommand();

    /**
     * method that allows to show the cost of the selected tool card
     * @param toolCost list of tool card's costs
     * @param indexTool index of the selected tool
     */
    public abstract void showToolCostCommand(List<Integer> toolCost, int indexTool);

    /**
     * method that allows to show the round tracker
     * @param roundTracker round tracker of the game
     */
    public abstract void showRoundTracker(RoundTracker roundTracker);

    /**
     * method that allows to show the final rank at the end of the game
     * @param playerList list of the players
     * @param ended boolean that indicates if the game is ended
     */
    public abstract void showFinalRank(List<Player> playerList, boolean ended);

    /**
     * method that allows to show the player who won
     */
    public abstract void showWinner();

    /**
     * method that allows to show the players who lost
     */
    public abstract void showLosers();

    /**
     * method that allows to show the timer is ended to the current player
     */
    public abstract void showTimer();

    /**
     * method that allows to show the current player's timer is ended to the other players
     * @param playerName name of the current player
     */
    public abstract void showOtherTimer(String playerName);

    /**
     * method that allows to show the list of tool cards
     * @param toolCardList list of tool cards
     */
    public abstract void showToolCards(List<ToolCard> toolCardList);

    /**
     * method that allows to show that tokens isn't enough to use a tool card
     */
    public abstract void showTokenError();

    //---------------------tool card----------------------------------------------------------------------

    /**
     * method that allows to show the request for the Grozing tool card
     * @param poolSize size of the pool
     */
    public abstract void showGrozingRequest(int poolSize);

    /**
     * method that allows to show the command to use Grozing tool card
     */
    public abstract void showGrozingCommand();

    /**
     * method that allows to show the start index for the Eglomise tool card
     */
    public abstract void showEglomiseStart();

    /**
     * method that allows to show the end index for the Eglomise tool card
     */
    public abstract void showEglomiseEnd();

    /**
     * method that allows to show the start index for the CopperFoil tool card
     */
    public abstract void showCopperFoilStart();

    /**
     * method that allows to show the end index for the Copper Foil tool card
     */
    public abstract void showCopperFoilEnd();

    /**
     * method that allows to show the first index where to pick up the dice in Lathekin tool card
     */
    public abstract void showLathekinStart();

    /**
     * method that allows to show the second index where to pick up the dice in Lathekin tool card
     */
    public abstract void showLathekinStartTwo();

    /**
     * method that allows to show the first index where to move the dice in Lathekin tool card
     */
    public abstract void showLathekinEnd();

    /**
     * method that allows to show the second index where to move the dice in Lathekin tool card
     */
    public abstract void showLathekinEndTwo();

    /**
     * method that allows to show the Lens Cutter tool card request
     * @param poolSize size of the pool
     * @param round round of the game
     */
    public abstract void showLensCutterRequest(int poolSize, List<Integer> round);

    /**
     * method that allows to show the round of the round tracker for the Lens Cutter tool card
     * @param round round of the round tracker
     */
    public abstract void showLensCutterRound(List<Integer> round);

    /**
     * method that allows to show the dice in the round tracker for the Lens Cutter tool card
     * @param round round of the round tracker
     * @param roundIndex index of the round
     */
    public abstract void showLensCutterDice(List<Integer> round, int roundIndex);

    /**
     * method that allows to show request for the Flux Brush tool card
     * @param poolSize size of the pool
     */
    public abstract void showFluxBrushRequest(int poolSize);

    /**
     * method that allows to show request for the Glazing Hammer tool card
     */
    public abstract void showGlazingHammerRequest();

    /**
     * method that allows to show the index of the pool
     * @param poolSize size of the pool
     */
    public abstract void showRunningPliersPool(int poolSize);

    /**
     * method that allows to show the index where to move the dice in the pattern card
     */
    public abstract void showRunningPliersEnd();

    /**
     * method that allows to show the index of the pool
     * @param poolSize size of the pool
     */
    public abstract void showCorkBackedPool(int poolSize);

    /**
     * method that allows to show the index where to move the dice in the pattern card
     */
    public abstract void showCorkBackedEnd();

    /**
     * method that allows to show the request for Cork Backed tool card
     * @param poolSize size of the pool
     */
    public abstract void showGrindingStoneRequest(int poolSize);

    /**
     * method that allows to show the color of the selected dice e the index of the pool
     * @param color color of the selected dice
     * @param poolSize index of the pool
     */
    public abstract void showFluxRemoverPool(DiceColor color, int poolSize);

    /**
     * method that allows to show the new value of the selected dice
     */
    public abstract void showFluxRemoverValue();

    /**
     * method that allows to show the number of dice the player wants to move
     */
    public abstract void showTapWheelNumber();

    /**
     * method that allows to show the first index where to pick up the dice in Tap Wheel tool card
     */
    public abstract void showTapWheelStartOne();

    /**
     * method that allows to show the first index where to move the dice in Tap Wheel tool card
     */
    public abstract void showTapWheelEndOne();

    /**
     * method that allows to show the second index where to pick up the dice in Tap Wheel tool card
     */
    public abstract void showTapWheelStartTwo();

    /**
     * method that allows to show the second index where to move the dice in Tap Wheel tool card
     */
    public abstract void showTapWheelEndTwo();

    /**
     * method that allows to show the board of the game
     * @param roundTracker round tracker of the game
     * @param draftPool draft pool of the game
     */
    public abstract void showBoard(RoundTracker roundTracker, DraftPool draftPool);

    /**
     * method that allows to show an invalid move
     * @param msg message to show
     */
    public abstract void showInvalidMove(String msg);

    //------------------------single player mode----------------------------------

    /**
     * method that allows to show request for the single player mode
     */
    public abstract void showSinglePlayerRequest();

    /**
     * method that allows to show the difficulty chosen by the player
     */
    public abstract void showDifficultyRequest();

    /**
     * method that allows to show the list of the public cards
     * @param publicList list of publi cards
     */
    public abstract void showPrivateSingle(List<PrivateObjectiveCard> publicList);

    /**
     * method that allows to show the possiblity to choose a tool card
     * @param toolList list of the tool cards
     * @param poolSize size of the pool
     */
    public abstract void showToolSingleCommand(List<ToolCard> toolList, int poolSize);

    /**
     * method that allows to show the selected tool card by the player
     */
    public abstract void showToolSingleChoose();

    /**
     * method that allows to show the selected dice to use the tool card
     */
    public abstract void showToolSingleDice();

    /**
     * method that allows to show that the selected dice isn't right to use the tool card
     */
    public abstract void showMatchError();

    /**
     * method that allows to show if the player won the game
     * @param winner boolean that indicates if the player won
     * @param playerPoints total points of the player
     * @param gameThreshold threshold to overcome to win
     */
    public abstract void showEndSinglePlayer(boolean winner, int playerPoints, int gameThreshold);

    //--------------------disconnection---------------------------------------------

    /**
     * method that allows to show that the limit of the player reached the maximum
     */
    public abstract void showMaxPlayerLogin();

    /**
     * method that allows to show the player that exited the game
     * @param playerName name of the player who exited the game
     */
    public abstract void showExitPlayer(String playerName);

    /**
     * method that allows to show the player that reconnected to the game
     * @param playerName name of the player that reconnected to the game
     */
    public abstract void showReconnectPlayer(String playerName);

    /**
     * method that allows to show that a player can't reconnect to a game because no players exite
     */
    public abstract void showNotPermittedReconnection();

    /**
     * method that allows to reload all the scene of the player who reconnected to the game
     * @param currPlayer current player
     * @param singlePlay boolean that indicates if the modality is single player
     * @param gameStart boolean that indicates if the game is started
     * @param tool list of tool cards
     * @param publicCard list of public cards
     * @param players list of players
     */
    public abstract void showReload(Player currPlayer,boolean singlePlay, boolean gameStart, List<ToolCard> tool, List<PublicObjectiveCard> publicCard, List<Player> players);
}