package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.server.model.Cards.ToolCard;
import it.polimi.se2018.events.Event;

import java.util.List;

/**
 * Class ToolCardUpdateEvent: controller view event that update the list of the toolcard in the single player mode
 */
public class ToolCardUpdateEvent implements Event {

    private static final long serialVersionUID = 489337L;
    private List<ToolCard> toolCardList;

    /**
     * class constructor with the list of tool cards
     * @param toolCardList list of tool card
     */
    public ToolCardUpdateEvent(List<ToolCard> toolCardList) {
        this.toolCardList = toolCardList;
    }

    /**
     * method that provides the caller the list of the tool cards
     * @return list of the tool cards
     */
    public List<ToolCard> getToolCardList() {
        return toolCardList;
    }
}
