package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.events.Event;

/**
 * Class LathekinRequestEvent: controller view event for Lathekin tool card request
 */
public class LathekinRequestEvent implements Event {

    private static final long serialVersionUID = 438938L;
    private int id;

    /**
     * class constructor with the id of the player
     * @param id id of the player
     */
    public LathekinRequestEvent(int id) {
        this.id = id;
    }

    /**
     * method that provides the caller the id of the player
     * @return id of the player
     */
    public int getId() {
        return id;
    }
}
