package it.polimi.se2018.server.model.Events.ServerClient;

import it.polimi.se2018.server.model.Events.Event;

public class PlayerNameUpdateEvent implements Event {

    private static final long serialVersionUID = 58458L;

    private final String name;

    public PlayerNameUpdateEvent(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
