package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Events.Event;

public class GrozingPliersRequestEvent implements Event {

    private static final long serialVersionUID = 4389348L;
    private int id;

    public GrozingPliersRequestEvent(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
