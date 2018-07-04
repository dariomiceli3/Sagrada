package it.polimi.se2018.events.serverclient.modelview;

import it.polimi.se2018.server.model.Components.RoundTracker;
import it.polimi.se2018.events.Event;

public class RoundTrackerUpdateEvent implements Event {

    public static final long serialVersionUID = 8493894L;

    private RoundTracker roundTracker;

    public RoundTrackerUpdateEvent(RoundTracker roundTracker) {
        this.roundTracker = roundTracker;
    }

    public RoundTracker getRoundTracker() {
        return roundTracker;
    }
}