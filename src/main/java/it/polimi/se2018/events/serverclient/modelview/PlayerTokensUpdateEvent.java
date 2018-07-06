package it.polimi.se2018.events.serverclient.modelview;

import it.polimi.se2018.events.Event;

/**
 * Class PlayerTokensUpdateEvent: model view event that updates the left tokens of the player
 */
public class PlayerTokensUpdateEvent implements Event {

    private static final long serialVersionUID = 53857L;
    private int id;
    private int tokensNumber;

    /**
     * class constructor with the id and the left tokens of the player
     * @param id id of the player
     * @param tokensNumber left tokens of the player
     */
    public PlayerTokensUpdateEvent(int id, int tokensNumber) {
        this.id = id;
        this.tokensNumber = tokensNumber;

    }

    /**
     * method that provides the caller the id of the player
     * @return id of the player
     */
    public int getID() {
        return id;
    }

    /**
     * method that provides the caller the left tokens of the player
     * @return left tokens of the player
     */
    public int getTokensNumber() {
        return tokensNumber;
    }


}
