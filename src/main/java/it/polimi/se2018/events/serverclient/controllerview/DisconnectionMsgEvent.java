package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.events.Event;

public class DisconnectionMsgEvent implements Event {

    private static final long serialVersionUID = 34567555L;
    private int id;
    private String name;

    public DisconnectionMsgEvent(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }
}
