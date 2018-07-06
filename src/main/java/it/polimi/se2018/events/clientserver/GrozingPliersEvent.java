package it.polimi.se2018.events.clientserver;

import it.polimi.se2018.events.Event;

/**
 * class GrozingPliers: client server event for Grozing Pliers tool card
 */
public class GrozingPliersEvent implements Event {

    private static final long serialVersionUID = 539893L;
    private int indexPool;
    private int increase;

    /**
     * class constructor with the index of the dice at the moment of the call and an integer to
     * decide if increase or decrease the value of dice
     * @param indexPool index of the pool
     * @param increase increase or decrease the value
     */
    public GrozingPliersEvent(int indexPool, int increase) {
        this.indexPool = indexPool;
        this.increase = increase;
    }

    /**
     * method that provides the caller the index of the pool of the dice at the moment at the call
     * @return the index of the pool
     */
    public int getIndexPool() {
        return indexPool;
    }

    /**
     * method that provides the caller the integer to decide if increase or decrease the value of dice
     * @return increase or decrease the value
     */
    public int getIncrease() {
        return increase;
    }
}
