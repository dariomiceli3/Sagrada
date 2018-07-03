package it.polimi.se2018.events.ClientServer;

import it.polimi.se2018.events.Event;

public class DisconnectionEvent implements Event {

    private static final long serialVersionUID = 4930943L;
    private int ID;

    public DisconnectionEvent(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }
}
