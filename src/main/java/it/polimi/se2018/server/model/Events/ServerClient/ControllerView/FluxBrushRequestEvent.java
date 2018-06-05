package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Events.Event;

public class FluxBrushRequestEvent implements Event {

    private static final long serialVersionUID = 349043L;
    private int id;

    public FluxBrushRequestEvent(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
