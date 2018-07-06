package it.polimi.se2018.events.serverclient.modelview;

import it.polimi.se2018.events.Event;

/**
 * Class PlayerIDEvent: model view event that notifies the view that the id of player is set
 */
public class PlayerIDEvent implements Event {

    private static final long serialVersionUID = 4903589L;

    private final int playerID;

    /**
     * class constructor with the id of the player and the size of the pool
     * @param playerID id of the player
          */
    public PlayerIDEvent(int playerID) {
        this.playerID = playerID;
    }

    /**
     * method that provides the caller the id of the player
     * @return id of the player
     */
    public int getPlayerID() {
        return playerID;
    }
}
