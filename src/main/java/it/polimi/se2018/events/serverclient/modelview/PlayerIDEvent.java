package it.polimi.se2018.events.serverclient.modelview;

import it.polimi.se2018.events.Event;

public class PlayerIDEvent implements Event {

    private static final long serialVersionUID = 4903589L;

    private final int playerID;

    public PlayerIDEvent(int playerID) {
        this.playerID = playerID;
    }

    public int getPlayerID() {
        return playerID;
    }
}