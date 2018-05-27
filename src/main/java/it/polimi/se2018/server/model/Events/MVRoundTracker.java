package it.polimi.se2018.server.model.Events;

import it.polimi.se2018.server.model.Components.RoundTracker;

public class MVRoundTracker implements Event {

    private RoundTracker roundTracker;

    public MVRoundTracker(RoundTracker roundTracker){
        this.roundTracker = roundTracker;
    }

    public RoundTracker getRoundTracker() {
        return roundTracker;
    }
}
