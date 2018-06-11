package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Events.Event;

public class TimerOtherEvent implements Event {

    private static final long serialVersionUID = 943094033904L;
    private String name;

    public TimerOtherEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
