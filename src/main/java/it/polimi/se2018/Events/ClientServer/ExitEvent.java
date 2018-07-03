package it.polimi.se2018.events.ClientServer;

import it.polimi.se2018.events.Event;

public class ExitEvent implements Event {

    private static final long serialVersionUID = 34999000L;
    private int playerID;

    public ExitEvent(int playerID) {
        this.playerID = playerID;
    }

    public int getPlayerID() {
        return playerID;
    }
}
