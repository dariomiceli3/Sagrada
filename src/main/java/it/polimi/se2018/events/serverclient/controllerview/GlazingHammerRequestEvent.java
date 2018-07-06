package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.events.Event;

/**
 * Class GlazingHammerRequestEvent: controller view event for Glazing Hammer tool card Request
 */
public class GlazingHammerRequestEvent implements Event {

    private static final long serialVersionUID = 4389834L;
    private int id;

    /**
     * class constructor with the id of the player
     * @param id id of the player
     */
    public GlazingHammerRequestEvent(int id) {
        this.id = id;
    }

    /**
     * method that provides the caller id of the player
     * @return id of the player
     */
    public int getId() {
        return id;
    }
}
