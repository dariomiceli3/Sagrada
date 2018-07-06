package it.polimi.se2018.events.clientserver;

import it.polimi.se2018.events.Event;

/**
 * Class ReconnectionPlayerEvent: client server event for the reconnection
 */
public class ReconnectPlayerEvent implements Event {

    private static final long serialVersionUID = 39899084L;
    private int playerID;

    /**
     * class constructor with the id of the player
     * @param playerID id of the player id
     */
    public ReconnectPlayerEvent(int playerID) {
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
