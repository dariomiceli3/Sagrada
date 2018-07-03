package it.polimi.se2018.events.ServerClient.ControllerView;

import it.polimi.se2018.events.Event;

public class StartTurnEvent implements Event {

    private static final long serialVersionUID = 8348L;
    private int ID;
    private String name;

    public StartTurnEvent(int ID, String name) {

        this.name = name;
        this.ID = ID;

    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

}
