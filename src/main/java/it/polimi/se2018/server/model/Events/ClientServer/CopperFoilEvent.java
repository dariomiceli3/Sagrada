package it.polimi.se2018.server.model.Events.ClientServer;

import it.polimi.se2018.server.model.Events.Event;

public class CopperFoilEvent implements Event {

    private static final long sreialVersionUID = 43934L;
    private int indexStart;
    private int indexEnd;

    public CopperFoilEvent(int indexStart, int indexEnd) {
        this.indexStart = indexStart;
        this.indexEnd = indexEnd;
    }


    public int getIndexStart() {
        return indexStart;
    }

    public int getIndexEnd() {
        return indexEnd;
    }

}
