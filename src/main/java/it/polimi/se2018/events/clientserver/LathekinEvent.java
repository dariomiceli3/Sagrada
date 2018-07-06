package it.polimi.se2018.events.clientserver;

import it.polimi.se2018.events.Event;

/**
 * class Lathekin: client server event for Lathekin tool card
 */
public class LathekinEvent implements Event {

    private static final long serialVersionUID = 43834839L;
    private int indexStartOne;
    private int indexEndOne;
    private int indexStartTwo;
    private int indexEndTwo;

    /**
     * class constructor with the index where to take the first dice and where to move it and the index
     * where to take the second dice and where to move it
     * @param indexStartOne index of the first dice
     * @param indexEndOne where to move the first dice
     * @param indexStartTwo index of the second dice
     * @param indexEndTwo index where to move the second dice
     */
    public LathekinEvent(int indexStartOne, int indexEndOne, int indexStartTwo, int indexEndTwo) {
        this.indexStartOne = indexStartOne;
        this.indexEndOne = indexEndOne;
        this.indexStartTwo = indexStartTwo;
        this.indexEndTwo = indexEndTwo;
    }

    /**
     * method that provides the caller the index where to take the first dice
     * @return index of first dice
     */
    public int getIndexStartOne() {
        return indexStartOne;
    }

    /**
     * method that provides the caller the index where to move the first dice
     * @return int value of the index
     */
    public int getIndexEndOne() {
        return indexEndOne;
    }

    /**
     * method that provides the caller the index where to take the second dice
     * @return index of second dice
     */
    public int getIndexStartTwo() {
        return indexStartTwo;
    }

    /**
     * method that provides the caller the index where to move the second dice
     * @return int value of the index
     */
    public int getIndexEndTwo() {
        return indexEndTwo;
    }
}
