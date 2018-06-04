package it.polimi.se2018.server.model.Events.ClientServer;

import it.polimi.se2018.server.model.Events.Event;

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
