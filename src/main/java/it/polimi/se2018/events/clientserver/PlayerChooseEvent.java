package it.polimi.se2018.events.clientserver;

import it.polimi.se2018.events.Event;

/**
 * Class PlayerChooseEvent: client server event for the choose of the step between using a tool card
 * or moving a dice
 */
public class PlayerChooseEvent implements Event {

    private static final long serialVersionUID = 676766L;
    private int step;

    /**
     * class constructor with the step
     * @param step int choose of the player
     */
    public PlayerChooseEvent(int step) {
        this.step = step;
    }

    /**
     * method that provides the caller the current step at the moment of the call
     * @return int step
     */
    public int getStep() {
        return step;
    }
}
