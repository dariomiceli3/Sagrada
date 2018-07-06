package it.polimi.se2018.events.clientserver;

import it.polimi.se2018.events.Event;

/**
 * Class TapWheelEvent: client server event for Tap Wheel tool card
 */
public class TapWheelEvent implements Event {

    private static final long serialVersionUID = 4934839L;
    private int numberDice;
    private int indexStartOne;
    private int indexStartTwo;
    private int indexEndOne;
    private int indexEndTwo;

    /**
     * class constructor with the number of the dice the player wants to move,
     *  the index where to take the first dice and where to move it and
     *  index where to take the second dice and where to move it
     *
     * @param numberDice number of dice the player wants to move
     * @param indexStartOne index where to take the first dice
     * @param indexEndOne index where to move the first dice
     * @param indexStartTwo index where to take the second dice
     * @param indexEndTwo index where to move the second dice
     */
    public TapWheelEvent(int numberDice, int indexStartOne, int indexEndOne, int indexStartTwo, int indexEndTwo) {
        this.numberDice = numberDice;
        this.indexStartOne = indexStartOne;
        this.indexEndOne = indexEndOne;
        this.indexStartTwo = indexStartTwo;
        this.indexEndTwo = indexEndTwo;
    }

    /**
     * method that provides the caller the number of dice the player wants to move
     * @return the number of dice
     */
    public int getNumberDice() {
        return numberDice;
    }

    /**
     * method that provides the caller the index where to take the first dice
     * @return index of the dice
     */
    public int getIndexStartOne() {
        return indexStartOne;
    }

    /**
     * method that provides the caller the index where to take the second the dice
     * @return index of the second dice
     */
    public int getIndexStartTwo() {
        return indexStartTwo;
    }

    /**
     * method that provides the caller the index where to move the first dice
     * @return index where to move the first dice
     */
    public int getIndexEndOne() {
        return indexEndOne;
    }

    /**
     * method that provides the caller the index where to move the second dice
     * @return index where to move the second dice
     */
    public int getIndexEndTwo() {
        return indexEndTwo;
    }
}
