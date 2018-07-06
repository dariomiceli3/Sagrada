package it.polimi.se2018.events.singleplayer;

import it.polimi.se2018.events.Event;
/**
 * Class ToolCardSinglePlayerStarEvent: single player event that allows to use a tool card
 */
public class ToolCardSinglePlayerStartEvent implements Event {

    private static final long serialVersionUID = 438943L;
    private int indexTool;
    private int indexPool;

    /**
     * class constructor with the index of the tool and the index of the pool
     * @param indexTool index of the tool
     * @param indexPool index of the pool
     */
     public ToolCardSinglePlayerStartEvent(int indexTool, int indexPool) {
         this.indexTool = indexTool;
         this.indexPool = indexPool;
     }

    /**
     * method that provides the caller the index of the pool of the dice the player wants to take
     * for using the tool card
     * @return int index of the pool
     */
    public int getIndexPool() {
        return indexPool;
    }

    /**
     * method that provides the caller the index of the tool the player wants to use
     * @return int index of the tool
     */
    public int getIndexTool() {
        return indexTool;
    }
}
