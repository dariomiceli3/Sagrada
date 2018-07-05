package it.polimi.se2018.events.clientserver;

import it.polimi.se2018.events.Event;

/**
 * Class EglomiseBrushEvent: client server event for Eglomise  Brush tool card
 */
public class EglomiseBrushEvent implements Event {

    private static final long serialVersionUID = 329039L;
    private int indexStart;
    private int indexEnd;

    /**
     * Class constructor with the index where to take the dice and where to move it
     * @param indexStart index of the dice
     * @param indexEnd index where to move it
     */
    public EglomiseBrushEvent(int indexStart, int indexEnd) {
        this.indexStart = indexStart;
        this.indexEnd = indexEnd;
    }

    /**
     * method that provide the caller the index where to move the dice
     * @return int value of the index
     */
    public int getIndexEnd() {
        return indexEnd;
    }

    /**
     * method that provide the caller the index where to take the dice to move
     * @return int value of the index
     */
    public int getIndexStart() {
        return indexStart;
    }
}
