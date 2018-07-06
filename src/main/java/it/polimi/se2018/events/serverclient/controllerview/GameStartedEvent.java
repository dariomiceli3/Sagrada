package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.events.Event;

/**
 * Class GameStartedEvent: controller view event for the start of the game
 */
public class GameStartedEvent implements Event {

    private static final long serialVersionUID = 4756L;

    private final boolean isStarted;

    /**
     * class constructor with a boolean that specifies if the game is started or not
     * @param isStarted boolean hat specifies if the game is started
     */
    public GameStartedEvent(boolean isStarted) {
        this.isStarted = isStarted;
    }

    /**
     * method that provides the caller if the game is started or not
     * @return boolean isStarted
     */
    public boolean isStarted() {
        return isStarted;
    }
}
