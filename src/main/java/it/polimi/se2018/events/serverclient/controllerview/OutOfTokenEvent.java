package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.events.Event;


/**
 * Class OutOfTokensEvent: controller view event where the player has not token enough to use a tool card
 */
public class OutOfTokenEvent implements Event {

    private static final long serialVersionUID = 53859L;
    private int id;

    /**
     * class constructor with the id of the player
     * @param id id of the player
     */
    public OutOfTokenEvent(int id) {
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
