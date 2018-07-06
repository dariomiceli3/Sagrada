package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.events.Event;

/**
 * Class DisconnectionMsgEvent: controller view event that warns other players
 *  that a player disconnected from the game
 */
public class DisconnectionMsgEvent implements Event {

    private static final long serialVersionUID = 34567555L;
    private int id;
    private String name;

    /**
     * class constructor with the id  and the name of the player
     * @param id id of the player
     * @param name name of the player
     */
    public DisconnectionMsgEvent(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * method that provides the caller the id of the player
     * @return id of the player
     */
    public int getID() {
        return id;
    }

    /**
     * method that provides the caller the name of the player
     * @return name of the player
     */
    public String getName() {
        return name;
    }
}
