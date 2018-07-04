package it.polimi.se2018.events.clientserver;

import it.polimi.se2018.events.Event;

public class PlayerPatternEvent implements Event {

    private static final long serialVersionUID = 743857834L;
    private int id;
    private int indexPatternChoose;

    public PlayerPatternEvent(int id, int indexPatternChoose) {
        this.id = id;
        this.indexPatternChoose = indexPatternChoose;
    }

    public int getID() {
        return id;
    }

    public int getIndexPatternChoose() {
        return indexPatternChoose;
    }
}
