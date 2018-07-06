package it.polimi.se2018.events.clientserver;

import it.polimi.se2018.events.Event;

/**
 * Class GrindingStoneEvent: client server event for Grinding Stone tool card
 */
public class GrindingStoneEvent  implements Event {

    private static final long serialVersionUID = 349939403L;
    private int indexPool;

    /**
     * Class constructor with the index of pool of the dice at the moment of the call
     * @param indexPool index of the pool
     */
    public GrindingStoneEvent(int indexPool){
        this.indexPool = indexPool;
    }

    /**
     * method that provides the index of pool of the dice at the moment of the call
     * @return index of the pool
     */
    public int getIndexPool() {
        return indexPool;
    }
}
