package it.polimi.se2018.server.model.Events.ClientServer;

import it.polimi.se2018.server.model.Events.Event;

public class GrozingPliersEvent implements Event {

    private static final long serialVersionUID = 539893L;
    private int indexPool;
    private int increase;

    public GrozingPliersEvent(int indexPool, int increase) {
        this.indexPool = indexPool;
        this.increase = increase;
    }

    public int getIndexPool() {
        return indexPool;
    }

    public int getIncrease() {
        return increase;
    }
}
