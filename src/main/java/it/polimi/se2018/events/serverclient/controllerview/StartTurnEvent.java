package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.events.Event;

/**
 * Class StartTurnEvent: controller view event to start the new turn
 */
public class StartTurnEvent implements Event {

    private static final long serialVersionUID = 8348L;
    private int id;
    private String name;

    /**
     * class constructor with the id and the name of the player
     * @param id id of the player
     * @param name name of the player
     */
    public StartTurnEvent(int id, String name) {

        this.name = name;
        this.id = id;

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
