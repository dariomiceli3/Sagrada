package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.events.Event;

/**
 * Class ReconnectionMsgEvent: controller view event when the player reconnects to the game
 */
public class ReconnectionMsgEvent implements Event {

    private static final long serialVersionUID = 234567L;
    private int ID;
    private String name;

    /**
     * class constructor with the id and the name of the player
     * @param ID id of the player
     * @param name name of the player
     */
    public ReconnectionMsgEvent(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    /**
     * method that provides the caller the name of the player
     * @return name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * method that provides the caller the id of the player
     * @return id of the player
     */
    public int getID() {
        return ID;
    }
}
