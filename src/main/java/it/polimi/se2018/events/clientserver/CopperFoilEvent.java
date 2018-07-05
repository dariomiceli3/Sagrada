package it.polimi.se2018.events.clientserver;

import it.polimi.se2018.events.Event;

/**
 * Class CopperFoilEvent: event for the copper foil tool card
 * @see it.polimi.se2018.events.Event
 * @author fadda-miceli-mundo
 */
public class CopperFoilEvent implements Event {

    private static final long serialVersionUID = 43934L;
    private int indexStart;
    private int indexEnd;

    /**
     * Class constructor with index of start dice and the index where to put the dice
     * @param indexStart index of the first dice to move
     * @param indexEnd index of where to move the dice
     */
    public CopperFoilEvent(int indexStart, int indexEnd) {
        this.indexStart = indexStart;
        this.indexEnd = indexEnd;
    }

    /**
     * method that provide the caller the index of the first dice
     * @return int value of the index start
     */
    public int getIndexStart() {
        return indexStart;
    }

    /**
     * method that provide the caller the index where to move the dice
     * @return int value of the end index
     */
    public int getIndexEnd() {
        return indexEnd;
    }

}
