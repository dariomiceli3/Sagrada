package it.polimi.se2018.server.model.Events.ClientServer;

import it.polimi.se2018.server.model.Events.Event;

public class FluxRemoverEvent implements Event {

    private static final long serialVersionUID = 34438L;
    private int indexPool;

    public FluxRemoverEvent(int indexPool) {
        this.indexPool = indexPool;
    }

    public int getIndexPool() {
        return indexPool;
    }
}
