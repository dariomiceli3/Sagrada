package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Events.Event;

public class RollDraftPoolEvent implements Event {

    private static final long serialVersionUID = 36722L;
    private int id;

    public RollDraftPoolEvent(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
