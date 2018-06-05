package it.polimi.se2018.server.model.Events.ClientServer;

import it.polimi.se2018.server.model.Events.Event;

public class RunningPliersEvent implements Event {

    private static final long serialVersionUID = 348943843L;
    private int indexPool;

    public RunningPliersEvent(int indexPool) {
        this.indexPool = indexPool;
    }

    public int getIndexPool() {
        return indexPool;
    }
}
