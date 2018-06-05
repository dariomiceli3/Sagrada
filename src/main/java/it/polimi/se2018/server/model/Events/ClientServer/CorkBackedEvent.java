package it.polimi.se2018.server.model.Events.ClientServer;

import it.polimi.se2018.server.model.Events.Event;

public class CorkBackedEvent implements Event {

    private static final long serialVersionUID = 349349L;
    private int indexPool;
    private int indexPattern;

    public CorkBackedEvent (int indexPool, int indexPattern) {
        this.indexPool = indexPool;
        this.indexPattern = indexPattern;
    }

    public int getIndexPool() {
        return indexPool;
    }

    public int getIndexPattern() {
        return indexPattern;
    }
}
