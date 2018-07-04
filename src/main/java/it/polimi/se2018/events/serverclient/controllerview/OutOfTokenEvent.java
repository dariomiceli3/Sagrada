package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.events.Event;

public class OutOfTokenEvent implements Event {

    private static final long serialVersionUID = 53859L;
    private int id;

    public OutOfTokenEvent(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
