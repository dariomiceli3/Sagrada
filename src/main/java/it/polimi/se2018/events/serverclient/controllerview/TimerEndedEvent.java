package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.events.Event;

public class TimerEndedEvent implements Event {

    private static final long serialVersionUID = 347384L;
    private int id;

    public TimerEndedEvent(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
