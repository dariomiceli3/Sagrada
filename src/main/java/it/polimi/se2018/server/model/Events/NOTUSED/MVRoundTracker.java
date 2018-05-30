package it.polimi.se2018.server.model.Events.NOTUSED;

import it.polimi.se2018.server.model.Components.RoundTracker;
import it.polimi.se2018.server.model.Events.Event;

public class MVRoundTracker implements Event {

    private RoundTracker roundTracker;

    public MVRoundTracker(RoundTracker roundTracker){
        this.roundTracker = roundTracker;
    }

    public RoundTracker getRoundTracker() {
        return roundTracker;
    }
}
