package it.polimi.se2018.events.singleplayer;

import it.polimi.se2018.events.Event;


/**
 * Class ToolNumberEvent: single player event that delivered tool cards as much as the difficulty
 * chosen by player
 */
public class ToolNumberEvent implements Event {

    private static final long serialVersionUID  = 384934L;
    private int difficulty;

    /**
     * class constructor with the difficulty chosen by the player
     * @param difficulty int difficulty
     */
    public ToolNumberEvent(int difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * method that provides the caller the difficulty chosen by the player
     * @return int difficulty
     */
    public int getDifficulty() {
        return difficulty;
    }
}
