package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.events.Event;

public class StartChooseEvent implements Event {

    private static final long serialVersionUID = 388893L;
    private int id;

    public StartChooseEvent(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }
}
