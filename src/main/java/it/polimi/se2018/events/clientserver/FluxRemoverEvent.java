package it.polimi.se2018.events.clientserver;

import it.polimi.se2018.events.Event;

/**
 * Class FluxRemover: client server event for Flux Remover tool card
 */
public class FluxRemoverEvent implements Event {

    private static final long serialVersionUID = 34438L;
    private int indexPool;
    private int diceValue;

    /**
     * Class constructor with the index of the pool of dice at the moment of the call and
     * the new value of the dice
     * @param indexPool index of the pool of dice
     * @param diceValue new value of the dice
     */
    public FluxRemoverEvent(int indexPool, int diceValue) {
        this.indexPool = indexPool;
        this.diceValue = diceValue;
    }

    /**
     * method that provides the index of the pool of the dice at the moment of the call
     * @return index of pool
     */
    public int getIndexPool() {
        return indexPool;
    }

    /**
     * method that provides the new value of the dice
     * @return value of dice
     */
    public int getDiceValue() {
        return diceValue;
    }
}
