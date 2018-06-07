package it.polimi.se2018.server.model.Events.SinglePlayer;

import it.polimi.se2018.server.model.Events.Event;

public class SinglePlayerRequestEvent implements Event {

    private static final long serialVersionUID = 32430999L;
    private int id;

    public SinglePlayerRequestEvent(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
