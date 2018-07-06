package it.polimi.se2018.events.clientserver;

import it.polimi.se2018.events.Event;

/**
 * Class PlayerPatternEvent: client server event for the choose of the pattern
 */
public class PlayerPatternEvent implements Event {

    private static final long serialVersionUID = 743857834L;
    private int id;
    private int indexPatternChoose;

    /**
     * class constructor with the id of the player and the index of pattern choose by the player itself
     * @param id id of the player
     * @param indexPatternChoose int index of the pattern
     */
    public PlayerPatternEvent(int id, int indexPatternChoose) {
        this.id = id;
        this.indexPatternChoose = indexPatternChoose;
    }

    /**
     * method that provides the caller the id of the player
     * @return id of the player
     */
    public int getID() {
        return id;
    }

    /**
     * method that provides the caller the index of the pattern choose by the player
     * @return int index of pattern
     */
    public int getIndexPatternChoose() {
        return indexPatternChoose;
    }
}
