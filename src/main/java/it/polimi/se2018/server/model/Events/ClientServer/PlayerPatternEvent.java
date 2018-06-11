package it.polimi.se2018.server.model.Events.ClientServer;

import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Events.Event;

public class PlayerPatternEvent implements Event {

    private static final long serialVersionUID = 743857834L;
    private int ID;
    private int indexPatternChoose;

    public PlayerPatternEvent(int ID, int indexPatternChoose) {
        this.ID = ID;
        this.indexPatternChoose = indexPatternChoose;
    }

    public int getID() {
        return ID;
    }

    public int getIndexPatternChoose() {
        return indexPatternChoose;
    }
}
