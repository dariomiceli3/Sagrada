package it.polimi.se2018.events.clientserver;

import it.polimi.se2018.events.Event;

/**
 * Class PlayerMoveEvent: client server event for the move of the player
 */
public class PlayerMoveEvent implements Event {

    private static final long serialVersionUID = 38923479L;

    private int indexPool;
    private int indexPattern;

    /**
     * class constructor with the index of the pool where to take the dice and the index of the pattern
     * where to move the dice
     * @param indexPool index of the pool
     * @param indexPattern index of the pattern
     */
    public PlayerMoveEvent(int indexPool, int indexPattern) {
        this.indexPool = indexPool;
        this.indexPattern = indexPattern;
    }

    /**
     * method that provides the caller the index of the pattern where to move the dice
     * @return index of the patter
     */
    public int getIndexPattern() {
        return indexPattern;
    }

    /**
     * method that provides the caller the index of the pool where to take the dice
     * @return index of the pool
     */
    public int getIndexPool() {
        return indexPool;
    }

}
