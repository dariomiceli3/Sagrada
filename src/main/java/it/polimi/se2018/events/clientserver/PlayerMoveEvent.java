package it.polimi.se2018.events.clientserver;

import it.polimi.se2018.events.Event;

public class PlayerMoveEvent implements Event {

    private static final long serialVersionUID = 38923479L;

    private int indexPool;
    private int indexPattern;

    public PlayerMoveEvent(int indexPool, int indexPattern) {
        this.indexPool = indexPool;
        this.indexPattern = indexPattern;
    }

    public int getIndexPattern() {
        return indexPattern;
    }

    public int getIndexPool() {
        return indexPool;
    }

}
