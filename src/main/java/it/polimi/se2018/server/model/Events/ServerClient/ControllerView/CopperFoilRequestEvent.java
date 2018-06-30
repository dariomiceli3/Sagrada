package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Events.Event;

public class CopperFoilRequestEvent implements Event {

    private static final long serialVersionUID = 3294823L;
    private int id;

    public CopperFoilRequestEvent(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
