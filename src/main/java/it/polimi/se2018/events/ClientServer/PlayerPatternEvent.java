package it.polimi.se2018.events.ClientServer;

import it.polimi.se2018.events.Event;

public class PlayerPatternEvent implements Event {

    private static final long serialVersionUID = 743857834L;
    private int iD;
    private int indexPatternChoose;

    public PlayerPatternEvent(int iD, int indexPatternChoose) {
        this.iD = iD;
        this.indexPatternChoose = indexPatternChoose;
    }

    public int getID() {
        return iD;
    }

    public int getIndexPatternChoose() {
        return indexPatternChoose;
    }
}
