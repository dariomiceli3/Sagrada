package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.events.Event;

public class StartTurnEvent implements Event {

    private static final long serialVersionUID = 8348L;
    private int id;
    private String name;

    public StartTurnEvent(int id, String name) {

        this.name = name;
        this.id = id;

    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

}
