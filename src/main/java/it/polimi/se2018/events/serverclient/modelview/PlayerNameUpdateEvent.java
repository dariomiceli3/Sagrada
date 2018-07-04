package it.polimi.se2018.events.serverclient.modelview;

import it.polimi.se2018.events.Event;

public class PlayerNameUpdateEvent implements Event {

    private static final long serialVersionUID = 58458L;

    private final String name;
    private int id;

    public PlayerNameUpdateEvent(String name, int id) {
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
