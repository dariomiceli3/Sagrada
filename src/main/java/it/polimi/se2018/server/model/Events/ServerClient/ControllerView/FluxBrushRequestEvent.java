package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Events.Event;

public class FluxBrushRequestEvent implements Event {

    private static final long serialVersionUID = 349043L;
    private int id;
    private int poolSize;

    public FluxBrushRequestEvent(int id, int poolSize) {
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
