package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.events.Event;

public class LathekinRequestEvent implements Event {

    private static final long serialVersionUID = 438938L;
    private int id;

    public LathekinRequestEvent(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
