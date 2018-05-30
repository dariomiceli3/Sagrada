package it.polimi.se2018.server.model.Events.ClientServer;

import it.polimi.se2018.server.model.Events.Event;

public class PlayerNameEvent implements Event {

    private static final long serialVersionUID = 78437L;

    private final String name;
    private int id;

    public PlayerNameEvent(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public int getID() {
        return id;
    }
}
