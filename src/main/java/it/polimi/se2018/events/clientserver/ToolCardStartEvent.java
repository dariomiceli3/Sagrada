package it.polimi.se2018.events.clientserver;

import it.polimi.se2018.events.Event;

public class ToolCardStartEvent implements Event {

    private static final long serialVersionUID = 43894834L;
    private int indexTool;

    public ToolCardStartEvent(int indexTool) {
        this.indexTool = indexTool;
    }

    public int getIndexTool() {
        return indexTool;
    }
}
