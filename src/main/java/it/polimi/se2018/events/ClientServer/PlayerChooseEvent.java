package it.polimi.se2018.events.ClientServer;

import it.polimi.se2018.events.Event;

public class PlayerChooseEvent implements Event {

    private static final long serialVersionUID = 676766L;
    private int step;

    public PlayerChooseEvent(int step) {
        this.step = step;
    }

    public int getStep() {
        return step;
    }
}