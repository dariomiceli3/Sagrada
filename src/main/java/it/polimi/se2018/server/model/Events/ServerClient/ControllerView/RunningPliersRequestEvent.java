package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Events.Event;

public class RunningPliersRequestEvent implements Event {

    private static final long serialVersionUID = 777888L;
    private int id;

    public RunningPliersRequestEvent(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}


