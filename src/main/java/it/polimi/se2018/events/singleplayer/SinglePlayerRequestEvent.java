package it.polimi.se2018.events.singleplayer;

import it.polimi.se2018.events.Event;

/**
 * Class SinglePlayerRequestEvent: model view event that //todo adriano
 */
public class SinglePlayerRequestEvent implements Event {

    private static final long serialVersionUID = 32430999L;
    private int id;

    /**
     * class constructor with the id of the player
     * @param id id of the player
     */
    public SinglePlayerRequestEvent(int id) {
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
