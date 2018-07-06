package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.server.model.Cards.ToolCard;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.PublicObjectiveCard;
import it.polimi.se2018.server.model.Components.Player;
import it.polimi.se2018.events.Event;

import java.util.List;

/**
 * Class SuccessfulReconnectionEvent: controller view event that notifies that a player reconnected successfully to the game
 */
public class SuccessfulReconnectionEvent implements Event {

    private static final long serialVersionUID = 374843743897L;

    private Player currPlayer;
    private boolean singlePlayer;
    private boolean gameStarted;
    private List<ToolCard> toolList;
    private List<PublicObjectiveCard>  publicCardList;
    private List <Player> playerList;

    /**
     * Class constructor with the current player of the game, the boolean that notifies if mode is
     * single player or not, the boolean that notifies if the game is started or not, the list of the
     * tool cards, the list of the public cards and the list of all the players
     * @param currPlayer current player of the game
     * @param singlePlayer boolean that notifies if mode is single player
     * @param gameStarted boolean that notifies if the game is started
     * @param toolList list of tool cards
     * @param publicCardList list of public cards
     * @param playerList list of all the players
     */
    public SuccessfulReconnectionEvent(Player currPlayer, boolean singlePlayer, boolean gameStarted, List<ToolCard> toolList, List<PublicObjectiveCard> publicCardList, List<Player> playerList) {


        this.currPlayer = currPlayer;
        this.singlePlayer = singlePlayer;
        this.gameStarted = gameStarted;
        this.toolList = toolList;
        this.publicCardList = publicCardList;
        this.playerList = playerList;

    }

    /**
     * method that provides the caller if the game is started
     * @return boolean game started
     */
    public boolean isGameStarted() {
        return gameStarted;
    }

    /**
     * method that provides the caller the list of the tool cards
     * @return list of tool cards
     */
    public List<ToolCard> getToolList() {
        return toolList;
    }

    /**
     * method that provides the caller the list of the public cards
     * @return list of public cards
     */
    public List<PublicObjectiveCard> getPublicCardList() {
        return publicCardList;
    }

    /**
     * method that provides the caller the current player
     * @return current player
     */
    public Player getCurrPlayer() {
        return currPlayer;
    }

    /**
     * method that provides the caller the list of all the players
     * @return list of players
     */
    public List<Player> getPlayerList() {

        return playerList;
    }

    /**
     * method that provides the caller if the mode is single player
     * @return boolean single player
     */
    public boolean isSinglePlayer() {
        return singlePlayer;
    }
}

