package it.polimi.se2018.server.model.Events.ClientServer;

import it.polimi.se2018.server.model.Events.Event;

public class LensCutterEvent implements Event {

    private static final long serialVersionUID = 3483948L;
    private int indexPool;
    private int indexRound;
    private int indexPosition;

    public LensCutterEvent(int indexPool, int indexRound, int indexPosition) {
        this.indexPool = indexPool;
        this.indexRound = indexRound;
        this.indexPosition = indexPosition;
    }

    public int getIndexPool() {
        return indexPool;
    }

    public int getIndexPosition() {
        return indexPosition;
    }

    public int getIndexRound() {
        return indexRound;
    }
}
