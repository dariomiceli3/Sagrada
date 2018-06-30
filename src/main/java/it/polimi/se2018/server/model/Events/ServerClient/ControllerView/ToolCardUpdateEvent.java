package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.controller.ToolCard;
import it.polimi.se2018.server.model.Events.Event;

import java.util.List;

public class ToolCardUpdateEvent implements Event {

    private static final long serialVersionUID = 489337L;
    private List<ToolCard> toolCardList;

    public ToolCardUpdateEvent(List<ToolCard> toolCardList) {
        this.toolCardList = toolCardList;
    }

    public List<ToolCard> getToolCardList() {
        return toolCardList;
    }
}
