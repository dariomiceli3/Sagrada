package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.events.Event;

public class GameStartedEvent implements Event {

    private static final long serialVersionUID = 4756L;

    private final boolean isStarted;

    public GameStartedEvent(boolean isStarted) {
        this.isStarted = isStarted;
    }

    public boolean isStarted() {
        return isStarted;
    }
}
