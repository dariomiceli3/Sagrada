package it.polimi.se2018.server.model.Events.ClientServer;

import it.polimi.se2018.server.model.Events.Event;

public class FluxRemoverEvent implements Event {

    private static final long serialVersionUID = 34438L;
    private int indexPool;
    private int diceValue;

    public FluxRemoverEvent(int indexPool, int diceValue) {
        this.indexPool = indexPool;
        this.diceValue = diceValue;
    }

    public int getIndexPool() {
        return indexPool;
    }

    public int getDiceValue() {
        return diceValue;
    }
}
