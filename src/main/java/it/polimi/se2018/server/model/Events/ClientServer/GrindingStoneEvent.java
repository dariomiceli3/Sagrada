package it.polimi.se2018.server.model.Events.ClientServer;

import it.polimi.se2018.server.model.Events.Event;

public class GrindingStoneEvent  implements Event {

    private static final long serialVersionUID = 349939403L;
    private int indexPool;

    public GrindingStoneEvent(int indexPool){
        this.indexPool = indexPool;
    }

    public int getIndexPool() {
        return indexPool;
    }
}
