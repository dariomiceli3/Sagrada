package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Events.Event;

public class WinnerEvent implements Event {

    private static final long serialVersionUID = 4839483L;
    private int ID;

    public WinnerEvent(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

}
