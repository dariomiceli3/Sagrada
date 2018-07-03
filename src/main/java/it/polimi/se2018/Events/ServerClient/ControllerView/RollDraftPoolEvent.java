package it.polimi.se2018.events.ServerClient.ControllerView;

import it.polimi.se2018.events.Event;

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
