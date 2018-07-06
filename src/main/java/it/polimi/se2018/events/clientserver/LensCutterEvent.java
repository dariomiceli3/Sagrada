package it.polimi.se2018.events.clientserver;

import it.polimi.se2018.events.Event;

/**
 * Class LensCutter: client server event for Lens Cutter tool card
 */
public class LensCutterEvent implements Event {

    private static final long serialVersionUID = 3483948L;
    private int indexPool;
    private int indexRound;
    private int indexPosition;

    /**
     * class constructor with the index of the pool of the dice, the index of the round in the round tracker
     * and the index of the position
     * @param indexPool index of the pool
     * @param indexRound index of the round of the round tracker
     * @param indexPosition index of the position
     */
    public LensCutterEvent(int indexPool, int indexRound, int indexPosition) {
        this.indexPool = indexPool;
        this.indexRound = indexRound;
        this.indexPosition = indexPosition;
    }

    /**
     * method that provides the caller the index of the pool at the moment of the call
     * @return index of the pool
     */
    public int getIndexPool() {
        return indexPool;
    }

    /**
     * method that provides the caller the index of the position
     * @return index of the position
     */
    public int getIndexPosition() {
        return indexPosition;
    }

    /**
     * method that provides the caller the index of the round in the round tracker
     * @return index of the round
     */
    public int getIndexRound() {
        return indexRound;
    }
}
