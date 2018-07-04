package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.events.Event;

public class WinnerEvent implements Event {

    private static final long serialVersionUID = 4839483L;
    private int id;

    public WinnerEvent(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }

}
