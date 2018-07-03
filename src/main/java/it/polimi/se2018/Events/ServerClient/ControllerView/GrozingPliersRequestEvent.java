package it.polimi.se2018.events.ServerClient.ControllerView;

import it.polimi.se2018.events.Event;

public class GrozingPliersRequestEvent implements Event {

    private static final long serialVersionUID = 4389348L;
    private int id;
    private int poolSize;

    public GrozingPliersRequestEvent(int id, int poolSize) {
        this.id = id;
        this.poolSize = poolSize;
    }

    public int getId() {
        return id;
    }

    public int getPoolSize() {
        return poolSize;
    }
}
