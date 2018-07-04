package it.polimi.se2018.events.clientserver;

import it.polimi.se2018.events.Event;

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
