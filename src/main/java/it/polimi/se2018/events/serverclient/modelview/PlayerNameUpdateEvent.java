package it.polimi.se2018.events.serverclient.modelview;

import it.polimi.se2018.events.Event;

/**
 * Class PlayerNameUpdateEvent: model view event that update the name of the player
 */
public class PlayerNameUpdateEvent implements Event {

    private static final long serialVersionUID = 58458L;

    private final String name;
    private int id;

    /**
     * class constructor with the id of the player and the size of the pool
     * @param id id of the player
     * @param name name of the player
     */
    public PlayerNameUpdateEvent(String name, int id) {
        this.name = name;
        this.id = id;
    }

    /**
     * method that provides the caller the name of the player
     * @return name of the player
     */
    public String getName(){
        return name;
    }

    /**
     * method that provides the caller the id of the player
     * @return id of the player
     */
    public int getID() {
        return id;
    }
}
