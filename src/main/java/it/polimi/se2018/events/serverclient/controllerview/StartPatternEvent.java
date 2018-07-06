package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.events.Event;

import java.util.List;

/**
 * Class StartPatternEvent: controller view event that asks to the player if want to do a move
 */
public class StartPatternEvent implements Event {

    private static final long serialVersionUID = 58798L;

    private final int id;
    private List<PatternCard> patternList;

    /**
     * class constructor with the id of the player and the list of pattern cards
     * @param id id of the player
     * @param patternList list of pattern
     */
    public StartPatternEvent(int id, List<PatternCard> patternList) {

        this.id = id;
        this.patternList = patternList;
    }

    /**
     * method that provides the caller the id of the player
     * @return id of the player
     */
    public int getID() {
        return id;
    }

    /**
     * method that provides the caller the list of pattern
     * @return list of pattern
     */
    public List<PatternCard> getPatternListEvent() {
        return patternList;
    }
}
