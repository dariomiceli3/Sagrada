package it.polimi.se2018.events.clientserver;

import it.polimi.se2018.events.Event;

/**
 * Class FluxBrushEvent: client server event for Flux Brush tool card
 */
public class FluxBrushEvent implements Event {

    private static final long serialVersionUID = 329039L;
    private int indexPool;

    /**
     * Class constructor with the index of pool of the dice at the moment of the call
     * @param indexPool index of the pool
     */
    public FluxBrushEvent(int indexPool){
        this.indexPool = indexPool;
    }

    /**
     * method that provide the caller the index of the pool of the dice at the moment of the call
     * @return index of the pool
     */
    public int getIndexPool() {
        return indexPool;
    }
}
