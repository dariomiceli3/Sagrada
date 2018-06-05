package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Events.Event;

public class FluxRemoverRequestEvent implements Event {

    private static final long serialVersionUID = 8427977L;
    private int id;

    public FluxRemoverRequestEvent(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
