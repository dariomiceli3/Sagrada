package it.polimi.se2018.server.model.Events.SinglePlayer;

import it.polimi.se2018.server.model.Events.Event;



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
