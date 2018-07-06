package it.polimi.se2018.events.serverclient.modelview;

import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.events.Event;

/**
 * Class PlayerPatternUpdateEvent: model view event that updates the pattern of the player
 */
public class PlayerPatternUpdateEvent implements Event {

    private static final long serialVersionUID = 483589L;

    private int id;
    private PatternCard card;

    /**
     * class constructor with the id and the pattern of the player
     * @param id id of the player
     * @param card patter of the player
     */
    public PlayerPatternUpdateEvent(int id, PatternCard card) {
        this.id = id;
        this.card = card;
    }

    /**
     * method that provides the caller the id of the player
     * @return id of the player
     */
    public int getID() {
        return id;
    }

    /**
     * method that provides the caller the pattern card of the player
     * @return pattern card of the player
     */
    public PatternCard getCard() {
        return card;
    }
}
