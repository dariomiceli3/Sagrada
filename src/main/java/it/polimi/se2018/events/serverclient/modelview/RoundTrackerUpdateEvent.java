package it.polimi.se2018.events.serverclient.modelview;

import it.polimi.se2018.server.model.Components.RoundTracker;
import it.polimi.se2018.events.Event;

/**
 * Class RoundTrackerUpdateEvent: model view event that updates the round tracker
 */
public class RoundTrackerUpdateEvent implements Event {

    public static final long serialVersionUID = 8493894L;

    private RoundTracker roundTracker;

    /**
     * class constructor with round tracker
     * @param roundTracker round tracker of the game
     */
    public RoundTrackerUpdateEvent(RoundTracker roundTracker) {
        this.roundTracker = roundTracker;
    }

    /**
     * method that provides the caller the round tracker
     * @return the round tracker
     */
    public RoundTracker getRoundTracker() {
        return roundTracker;
    }
}
