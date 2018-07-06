package it.polimi.se2018.events.singleplayer;

import it.polimi.se2018.server.model.Cards.ToolCard;
import it.polimi.se2018.events.Event;

import java.util.List;

/**
 * Class StartToolSinglePlayerEvent: single player event that asks to the player if he wants to use
 * the tool card in single player mode
 */
public class StartToolSinglePlayerEvent implements Event {

    private static final long serialVersionUID = 49304903L;
    private List<ToolCard> toolCardList;
    private int poolSize;

    /**
     * class constructor with the list of tool cards and size of the pool
     * @param toolCards list of tool cards
     * @param poolSize size of the pool
     */
    public StartToolSinglePlayerEvent(List<ToolCard> toolCards, int poolSize) {
        this.toolCardList = toolCards;
        this.poolSize = poolSize;
    }

    /**
     * method that provides the caller list of tool cards
     * @return list of tool cards
     */
    public List<ToolCard> getToolCardList() {
        return toolCardList;
    }

    /**
     * method that provides the caller the size of the pool
     * @return size of the pool
     */
    public int getPoolSize() {
        return poolSize;
    }
}
