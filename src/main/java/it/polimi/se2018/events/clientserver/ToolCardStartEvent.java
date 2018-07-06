package it.polimi.se2018.events.clientserver;

import it.polimi.se2018.events.Event;

/**
 * Class ToolCardStartEvent: client server event for using a tool card
 */
public class ToolCardStartEvent implements Event {

    private static final long serialVersionUID = 43894834L;
    private int indexTool;

    /**
     * class constructor with the index of the tool the player wants to use
     * @param indexTool index of the tool
     */
    public ToolCardStartEvent(int indexTool) {
        this.indexTool = indexTool;
    }

    /**
     * method that provides the caller the index of the tool the player wants to use
     * @return index of the tool
     */
    public int getIndexTool() {
        return indexTool;
    }
}
