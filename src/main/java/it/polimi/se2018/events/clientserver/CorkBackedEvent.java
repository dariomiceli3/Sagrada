package it.polimi.se2018.events.clientserver;

import it.polimi.se2018.events.Event;

/**
 * Class CorkBackedEvent: client server event for the Cork Backed tool card
 */
public class CorkBackedEvent implements Event {

    private static final long serialVersionUID = 349349L;
    private int indexPool;
    private int indexPattern;

    /**
     * Class constructor with an index pool for the dice and an index pattern for the index of the box list
     * @param indexPool index of the dice in the draft pool
     * @param indexPattern index of where to move the dice in the box list
     */
    public CorkBackedEvent (int indexPool, int indexPattern) {
        this.indexPool = indexPool;
        this.indexPattern = indexPattern;
    }

    /**
     * method that provide the caller the index of the dice in the draft pool
     * @return int value of the index
     */
    public int getIndexPool() {
        return indexPool;
    }

    /**
     * method that provide the caller of the index where to move the dice
     * @return int value of the index
     */
    public int getIndexPattern() {
        return indexPattern;
    }
}
