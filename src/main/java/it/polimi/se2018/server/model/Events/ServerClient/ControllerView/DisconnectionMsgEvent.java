package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Events.Event;

public class DisconnectionMsgEvent implements Event {

    private static final long serialVersionUID = 34567555L;
    private int ID;
    private String name;

    public DisconnectionMsgEvent(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }
}
