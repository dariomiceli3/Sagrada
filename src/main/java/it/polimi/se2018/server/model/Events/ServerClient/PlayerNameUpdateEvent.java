package it.polimi.se2018.server.model.Events.ServerClient;

import it.polimi.se2018.server.model.Events.Event;

public class PlayerNameUpdateEvent implements Event {

    private static final long serialVersionUID = 58458L;

    private final String name;
    private int ID;

    public PlayerNameUpdateEvent(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    public String getName(){
        return name;
    }

    public int getID() {
        return ID;
    }
}
