package it.polimi.se2018.events.clientserver;


import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.events.Event;

/**
 * Class CustomPatternEvent: client server event for the custom pattern of the player
 */
public class CustomPatternEvent implements Event {

    private static final long serialVersionUID = 439043943L;

    private PatternCard patternCard;

    /**
     * Class constructor
     * @param patternCard to set
     */
    public CustomPatternEvent(PatternCard patternCard) {
        this.patternCard = patternCard;
    }

    /**
     * method that provide the caller the Pattern Card custom
     * @return the card
     */
    public PatternCard getPatternCard() {
        return patternCard;
    }
}
