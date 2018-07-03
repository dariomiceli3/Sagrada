package it.polimi.se2018.events.ServerClient.ModelView;

import it.polimi.se2018.events.Event;

public class PlayerNameUpdateEvent implements Event {

    private static final long serialVersionUID = 58458L;

    private final String name;
    private int iD;

    public PlayerNameUpdateEvent(String name, int iD) {
        this.name = name;
        this.iD = iD;
    }

    public String getName(){
        return name;
    }

    public int getID() {
        return iD;
    }
}
