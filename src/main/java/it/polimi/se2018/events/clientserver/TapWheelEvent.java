package it.polimi.se2018.events.clientserver;

import it.polimi.se2018.events.Event;

public class TapWheelEvent implements Event {

    private static final long serialVersionUID = 4934839L;
    private int numberDice;
    private int indexStartOne;
    private int indexStartTwo;
    private int indexEndOne;
    private int indexEndTwo;

    public TapWheelEvent(int numberDice, int indexStartOne, int indexEndOne, int indexStartTwo, int indexEndTwo) {
        this.numberDice = numberDice;
        this.indexStartOne = indexStartOne;
        this.indexEndOne = indexEndOne;
        this.indexStartTwo = indexStartTwo;
        this.indexEndTwo = indexEndTwo;
    }

    public int getNumberDice() {
        return numberDice;
    }

    public int getIndexStartOne() {
        return indexStartOne;
    }

    public int getIndexStartTwo() {
        return indexStartTwo;
    }

    public int getIndexEndOne() {
        return indexEndOne;
    }

    public int getIndexEndTwo() {
        return indexEndTwo;
    }
}
