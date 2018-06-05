package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Events.Event;

public class StartTurnEvent implements Event {

    private static final long serialVersionUID = 8348L;
    private int ID;
    private String name;
    private int poolSize;

    public StartTurnEvent(int ID, String name, int poolSize) {

        this.name = name;
        this.ID = ID;
        this.poolSize = poolSize;

    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getPoolSize() {
        return poolSize;
    }
}
