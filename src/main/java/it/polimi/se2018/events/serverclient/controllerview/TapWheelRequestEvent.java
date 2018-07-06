package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.events.Event;

/**
 * Class TapWheelRequestEvent: controller view event for Tap Wheel tool card request
 */
public class TapWheelRequestEvent  implements Event {

    private static final long serialVersionUID = 78237832L;
    private int id;

    /**
     * class constructor with the id of the player
     * @param id id of the player
     */
    public TapWheelRequestEvent(int id) {
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
