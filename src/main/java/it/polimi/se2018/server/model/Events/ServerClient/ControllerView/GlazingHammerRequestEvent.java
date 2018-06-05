package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Events.Event;

public class GlazingHammerRequestEvent implements Event {

    private static final long serialVersionUID = 4389834L;
    private int id;

    public GlazingHammerRequestEvent(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
