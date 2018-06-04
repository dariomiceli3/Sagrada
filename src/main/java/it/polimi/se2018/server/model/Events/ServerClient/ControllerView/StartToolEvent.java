package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Events.Event;

public class StartToolEvent implements Event {

    private static final long serialVersionUID = 390322L;
    private int id;

    public StartToolEvent(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


}
