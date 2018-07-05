package it.polimi.se2018.events.clientserver;

import it.polimi.se2018.events.Event;

/**
 * Class DisconnectionEvent: client server event for the disconnection
 */
public class DisconnectionEvent implements Event {

    private static final long serialVersionUID = 4930943L;
    private int id;

    /**
     * Class constructor for the disconnection of a player associated with an id
     * @param id of the player
     */
    public DisconnectionEvent(int id) {
        this.id = id;
    }

    /**
     * method that provides the caller the id of the player that tried to disconnect
     * @return
     */
    public int getID() {
        return id;
    }
}
