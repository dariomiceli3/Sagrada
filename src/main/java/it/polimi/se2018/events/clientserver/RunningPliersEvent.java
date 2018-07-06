package it.polimi.se2018.events.clientserver;

import it.polimi.se2018.events.Event;

/**
 * Class RunningPliersEvent: client server event for Running Pliers tool card
 */
public class RunningPliersEvent implements Event {

    private static final long serialVersionUID = 348943843L;
    private int indexPool;
    private int indexPattern;

    /**
     * class constructor with the index of the pool and the index of the pattern at the moment of the call
     * @param indexPool index of the pool
     * @param indexPattern index of the pattern
     */
    public RunningPliersEvent(int indexPool, int indexPattern) {
        this.indexPool = indexPool;
        this.indexPattern = indexPattern;
    }

    /**
     * method that provides the caller the index of the pool at the moment of the call
     * @return index of the pool
     */
    public int getIndexPool() {
        return indexPool;
    }

    /**
     * method that provides the caller the index of the pattern at the moment of the call
     * @return index of the pattern
     */
    public int getIndexPattern() {
        return indexPattern;
    }
}
