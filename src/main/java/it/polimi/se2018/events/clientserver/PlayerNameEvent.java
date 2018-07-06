package it.polimi.se2018.events.clientserver;

import it.polimi.se2018.events.Event;

/**
 * Class PlayerNameEvent: client server event for the choose of the player's name
 */
public class PlayerNameEvent implements Event {

    private static final long serialVersionUID = 78437L;

    private final String name;
    private int id;

    /**
     * class constructor with the id of the player who has to choose the name and the name he wants to have
     * @param name name of the player
     * @param id id of the player
     */
    public PlayerNameEvent(String name, int id) {
        this.name = name;
        this.id = id;
    }

    /**
     * method that provides the caller the name that the player wants to have
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
