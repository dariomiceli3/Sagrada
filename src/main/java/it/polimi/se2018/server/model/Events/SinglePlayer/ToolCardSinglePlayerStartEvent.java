package it.polimi.se2018.server.model.Events.SinglePlayer;

import it.polimi.se2018.server.model.Events.Event;

public class ToolCardSinglePlayerStartEvent implements Event {

    private static final long serialVersionUID = 438943L;
    private int indexTool;
    private int indexPool;

     public ToolCardSinglePlayerStartEvent(int indexTool, int indexPool) {
         this.indexTool = indexTool;
         this.indexPool = indexTool;
     }

    public int getIndexPool() {
        return indexPool;
    }

    public int getIndexTool() {
        return indexTool;
    }
}
