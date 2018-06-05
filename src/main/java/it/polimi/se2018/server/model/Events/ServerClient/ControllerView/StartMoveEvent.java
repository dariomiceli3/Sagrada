package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Events.Event;

public class StartMoveEvent implements Event {

    private static final long serialVersionUID = 34893L;
    private int ID;
    private int poolSize;

    public StartMoveEvent(int ID, int poolSize) {
        this.ID = ID;
        this.poolSize = poolSize;
    }

    public int getID() {
        return ID;
    }

    public int getPoolSize() {
        return poolSize;
    }
}
