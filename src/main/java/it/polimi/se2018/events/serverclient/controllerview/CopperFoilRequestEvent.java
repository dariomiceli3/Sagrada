package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.events.Event;

/**
 * Class CopperFoilRequestEvent: controller view event for Copper foil tool card request
 */
public class CopperFoilRequestEvent implements Event {

    private static final long serialVersionUID = 3294823L;
    private int id;

    /**
     * class constructor with the id of the player who wants to use the tool card
     * @param id id of the player
     */
    public CopperFoilRequestEvent(int id) {
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
