package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.events.Event;

public class StartMoveEvent implements Event {

    private static final long serialVersionUID = 34893L;
    private int id;
    private int poolSize;

    public StartMoveEvent(int id, int poolSize) {
        this.id = id;
        this.poolSize = poolSize;
    }

    public int getID() {
        return id;
    }

    public int getPoolSize() {
        return poolSize;
    }
}
