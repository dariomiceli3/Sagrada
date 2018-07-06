package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.events.Event;

/**
 * Class RollDraftPoolEvent: controller view event when the player roll the draftpool
 */
public class RollDraftPoolEvent implements Event {

    private static final long serialVersionUID = 36722L;
    private int id;

    /**
     * class constructor with the id of the player
     * @param id id of the player
     */
    public RollDraftPoolEvent(int id) {
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
