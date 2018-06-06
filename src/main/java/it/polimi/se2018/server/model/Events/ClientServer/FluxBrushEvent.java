package it.polimi.se2018.server.model.Events.ClientServer;

import it.polimi.se2018.server.model.Events.Event;

public class FluxBrushEvent implements Event {

    private static final long serialVersionUID = 329039L;
    private int indexPool;

    public FluxBrushEvent(int indexPool){
        this.indexPool = indexPool;
    }

    public int getIndexPool() {
        return indexPool;
    }
}