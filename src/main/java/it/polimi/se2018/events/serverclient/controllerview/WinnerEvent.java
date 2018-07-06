package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.events.Event;

/**
 * Class WinnerEvent: controller view event to notifies the player who won the game
 */
public class WinnerEvent implements Event {

    private static final long serialVersionUID = 4839483L;
    private int id;

    /**
     * class constructor with the id of the player
     * @param id id of the player
     */
    public WinnerEvent(int id) {
        this.id = id;
    }

    /**
     * method that provides the caller the id of the player
     * @return id of the player
     */
    public int getID() {
        return id;
    }

}
