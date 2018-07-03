package it.polimi.se2018.events.SinglePlayer;

import it.polimi.se2018.events.Event;



public class ToolNumberEvent implements Event {

    private static final long serialVersionUID  = 384934L;
    private int difficulty;

    public ToolNumberEvent(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getDifficulty() {
        return difficulty;
    }
}
