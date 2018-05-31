package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Events.Event;

public class GameStartedEvent implements Event {

    private static final long serialVersionUID = 4756L;

    private final boolean isStarted;

    public GameStartedEvent(boolean isStarted) {
        this.isStarted = true;
    }

    public boolean isStarted() {
        return isStarted;
    }
}
