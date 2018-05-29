package it.polimi.se2018.server.model.Events.ClientServer;

import it.polimi.se2018.server.model.Events.Event;

public class PlayerNameEvent implements Event {

    private static final long serialVersionUID = 78437L;

    private final String name;
    private int ID;

    public PlayerNameEvent(String name, int ID) {
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
