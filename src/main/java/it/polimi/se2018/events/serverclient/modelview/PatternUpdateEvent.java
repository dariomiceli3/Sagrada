package it.polimi.se2018.events.serverclient.modelview;

import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.events.Event;

/**
 * Class PatternUpdateEvent: model view event that update the pattern of the player
 */
public class PatternUpdateEvent implements Event {

    private static final long serialVersionUID = 834938L;

    private int id;
    private PatternCard patternCard;
    private String name;

    /**
     * class constructor with the id, the name and the pattern of the player
     * @param id id of the player
     * @param patternCard pattern of the player
     * @param name name of the player
     */
    public PatternUpdateEvent(int id, PatternCard patternCard, String name) {
        this.id = id;
        this.patternCard = patternCard;
        this.name = name;
    }

    /**
     * method that provides the caller the pattern of the player
     * @return pattern of the player
     */
    public PatternCard getPatternCard() {
        return patternCard;
    }

    /**
     * method that provides the caller the id of the player
     * @return id of the player
     */
    public int getID() {
        return id;
    }

    /**
     * method that provides the caller the name of the player
     * @return name of the player
     */
    public String getName() {
        return name;
    }
}
