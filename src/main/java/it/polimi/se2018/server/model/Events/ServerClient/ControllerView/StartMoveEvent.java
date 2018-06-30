package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Events.Event;

public class StartMoveEvent implements Event {

    private static final long serialVersionUID = 34893L;
    private int iD;
    private int poolSize;

    public StartMoveEvent(int iD, int poolSize) {
        this.iD = iD;
        this.poolSize = poolSize;
    }

    public int getID() {
        return iD;
    }

    public int getPoolSize() {
        return poolSize;
    }
}
