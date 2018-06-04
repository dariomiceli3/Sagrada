package it.polimi.se2018.server.model.Events.ClientServer;

import it.polimi.se2018.server.model.Events.Event;

public class GrozingPliersEvent implements Event {

    private static final long serialVersionUID = 539893L;
    int indexPool;

    public GrozingPliersEvent(int indexPool) {
        this.indexPool = indexPool;
    }

    public int getIndexPool() {
        return indexPool;
    }
}
