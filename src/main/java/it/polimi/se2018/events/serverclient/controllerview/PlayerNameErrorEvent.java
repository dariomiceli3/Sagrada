package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.events.Event;


/**
 * Class PlayerNameErrorEvent: controller view event when the player choose a name already used by another player
 */
public class PlayerNameErrorEvent implements Event {

    private static final long serialVersionUID = 849384L;
    private int id;

    /**
     * class constructor with the id of the player
     * @param id id of the player
     */
    public PlayerNameErrorEvent(int id) {
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
