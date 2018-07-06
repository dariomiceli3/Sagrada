package it.polimi.se2018.events.clientserver;

import it.polimi.se2018.events.Event;

/**
 * Class ExitEvent: client server event for exiting
 */
public class ExitEvent implements Event {

    private static final long serialVersionUID = 34999000L;
    private int playerID;

    /**
     * Class constructor with the id of the player who wants to exit game
     * @param playerID ID of the player who wants to exit
     */
    public ExitEvent(int playerID) {
        this.playerID = playerID;
    }

    /**
     *  method that provide the caller the ID of the player who wants to exit
     * @return ID of the player
     */
    public int getPlayerID() {
        return playerID;
    }
}
