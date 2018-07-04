package it.polimi.se2018.events.clientserver;

import it.polimi.se2018.events.Event;

public class DisconnectionEvent implements Event {

    private static final long serialVersionUID = 4930943L;
    private int id;

    public DisconnectionEvent(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }
}
