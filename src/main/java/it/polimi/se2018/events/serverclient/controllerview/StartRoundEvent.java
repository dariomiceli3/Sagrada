package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.events.Event;

public class StartRoundEvent implements Event {

    private static final long serialVersionUID = 48574L;
    private int round;

    public StartRoundEvent(int round) {
        this.round = round;
    }

    public int getRound() {
        return round;
    }
}


