package it.polimi.se2018.server.model.Events.ClientServer;

import it.polimi.se2018.server.model.Events.Event;

public class PlayerNameEvent implements Event {

    private static final long serialVersionUID = 78437L;

    private final String name;

    public PlayerNameEvent(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
