package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Events.Event;

public class GrindingStoneRequestEvent implements Event {

    private static final long serialVersionUID = 576837L;
    private int id;

    public GrindingStoneRequestEvent(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
