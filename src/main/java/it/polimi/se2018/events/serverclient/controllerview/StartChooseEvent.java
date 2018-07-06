package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.events.Event;

/**
 * Class StartChooseEvent: controller view event to ask to the player what move he wants to do
 */
public class StartChooseEvent implements Event {

    private static final long serialVersionUID = 388893L;
    private int id;

    /**
     * class constructor with the id of the player
     * @param id id of the player
     */
    public StartChooseEvent(int id) {
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
