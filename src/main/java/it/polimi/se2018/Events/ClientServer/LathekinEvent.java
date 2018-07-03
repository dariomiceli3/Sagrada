package it.polimi.se2018.events.ClientServer;

import it.polimi.se2018.events.Event;

public class LathekinEvent implements Event {

    private static final long serialVersionUID = 43834839L;
    private int indexStartOne;
    private int indexEndOne;
    private int indexStartTwo;
    private int indexEndTwo;

    public LathekinEvent(int indexStartOne, int indexEndOne, int indexStartTwo, int indexEndTwo) {
        this.indexStartOne = indexStartOne;
        this.indexEndOne = indexEndOne;
        this.indexStartTwo = indexStartTwo;
        this.indexEndTwo = indexEndTwo;
    }

    public int getIndexStartOne() {
        return indexStartOne;
    }

    public int getIndexEndOne() {
        return indexEndOne;
    }

    public int getIndexStartTwo() {
        return indexStartTwo;
    }

    public int getIndexEndTwo() {
        return indexEndTwo;
    }
}
