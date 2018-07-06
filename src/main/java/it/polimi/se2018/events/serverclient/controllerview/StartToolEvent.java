package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.server.model.Cards.ToolCard;
import it.polimi.se2018.events.Event;

import java.util.List;

/**
 * Class StartToolEvent: controller view event that asks the player if he wants to use a tool card
 */
public class StartToolEvent implements Event {

    private static final long serialVersionUID = 390322L;
    private int id;
    private List<ToolCard> toolCardList;

    /**
     * class constructor with the id of the player and the list of tool cards
     * @param id id of the player
     * @param toolCardList list of tool card
     */
    public StartToolEvent(int id, List<ToolCard> toolCardList) {
        this.id = id;
        this.toolCardList = toolCardList;
    }
    /**
     * method that provides the caller the id of the player
     * @return id of the player
     */
    public int getId() {
        return id;
    }

    /**
     * method that provides the caller the list of the tool cards
     * @return list of the tool cards
     */
    public List<ToolCard> getToolCardList() {
        return toolCardList;
    }
}
