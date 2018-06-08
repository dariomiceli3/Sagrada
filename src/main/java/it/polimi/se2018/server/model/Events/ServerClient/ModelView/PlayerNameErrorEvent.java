package it.polimi.se2018.server.model.Events.ServerClient.ModelView;

import it.polimi.se2018.server.model.Events.Event;

public class PlayerNameErrorEvent implements Event {

    private static final long serialVersionUID = 849384L;
    private int id;

    public PlayerNameErrorEvent(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
