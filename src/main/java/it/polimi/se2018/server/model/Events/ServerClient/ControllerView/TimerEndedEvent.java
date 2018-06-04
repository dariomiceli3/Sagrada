package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Events.Event;

public class TimerEndedEvent implements Event {

    private static final long serialVersionUID = 347384L;
    private int id;
    private String name;

    public TimerEndedEvent(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
