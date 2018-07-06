package it.polimi.se2018.events.singleplayer;

import it.polimi.se2018.events.Event;

/**
 * Class SinglePlayerEvent: model view event that indicates if the mode is single player
 */
public class SinglePlayerEvent implements Event {

    private static final long serialVersionUID = 489348;
    private int id;
    private boolean singlePlayer;

    /**
     * class constructor with the id of the player and a boolean that indicates if the mode is single player
     * @param id id of the player
     * @param singlePlayer boolean that indicates if the mode is single player
     */
    public SinglePlayerEvent(int id, boolean singlePlayer) {
        this.id = id;
        this.singlePlayer = singlePlayer;
    }

    /**
     * method that provides the caller if the mode is single player or not
     * @return boolean single player
     */
    public boolean isSinglePlayer() {
        return singlePlayer;
    }

    /**
     * method that provides the caller the id of the player
     * @return id of the player
     */
    public int getId() {
        return id;
    }
}
