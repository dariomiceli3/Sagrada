package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Events.Event;

public class StartChooseEvent implements Event {

    private static final long serialVersionUID = 388893L;
    private int iD;

    public StartChooseEvent(int iD) {
        this.iD = iD;
    }

    public int getID() {
        return iD;
    }
}
