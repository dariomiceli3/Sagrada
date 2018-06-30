package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Events.Event;

public class WinnerEvent implements Event {

    private static final long serialVersionUID = 4839483L;
    private int iD;

    public WinnerEvent(int iD) {
        this.iD = iD;
    }

    public int getID() {
        return iD;
    }

}
