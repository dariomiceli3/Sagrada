package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.events.Event;

/**
 * Class StartRoundEvent: controller view event when a new round starts
 */
public class StartRoundEvent implements Event {

    private static final long serialVersionUID = 48574L;
    private int round;

    /**
     * class constructor with the round that has started
     * @param round int round
     */
    public StartRoundEvent(int round) {
        this.round = round;
    }

    /**
     * method that provides the caller the current round
     * @return int round
     */
    public int getRound() {
        return round;
    }
}


