package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Events.Event;

public class StartTurnEvent implements Event {

    private static final long serialVersionUID = 8348L;
    private int ID;

    public StartTurnEvent(int ID) {

        this.ID = ID;

    }

    public int getID() {
        return ID;
    }
}
