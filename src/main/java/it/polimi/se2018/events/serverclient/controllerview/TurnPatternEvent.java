package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.events.Event;

/**
 * Class TurnPatternEvent: controller view event to notifies //todo adri
 */
public class TurnPatternEvent implements Event {

    private static final long serialVersionUID = 93295894312L;

    private int id;
    private PatternCard patternCard;

    /**
     * class constructor with the id and the pattern of the player
     * @param id id of the player
     * @param patternCard pattern of the player
     */
    public TurnPatternEvent(int id, PatternCard patternCard){
        this.id = id;
        this.patternCard = patternCard;
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
}
