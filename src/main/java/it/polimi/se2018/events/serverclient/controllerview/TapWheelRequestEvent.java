package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.events.Event;

public class TapWheelRequestEvent  implements Event {

    private static final long serialVersionUID = 78237832L;
    private int id;

    public TapWheelRequestEvent(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
