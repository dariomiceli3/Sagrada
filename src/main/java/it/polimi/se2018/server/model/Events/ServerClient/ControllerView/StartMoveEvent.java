package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Events.Event;

public class StartMoveEvent implements Event {

    private static final long serialVersionUID = 34893L;
    private int ID;

    public StartMoveEvent(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }
}
