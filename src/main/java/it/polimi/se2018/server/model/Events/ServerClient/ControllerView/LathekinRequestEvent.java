package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Events.Event;

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
