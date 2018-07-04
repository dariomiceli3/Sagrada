package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.server.model.Cards.ToolCard;
import it.polimi.se2018.events.Event;

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