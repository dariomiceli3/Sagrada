package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.server.model.Components.DiceColor;
import it.polimi.se2018.events.Event;

/**
 * Class FluxRemoverRequestEvent: controller view event for Flux Remover tool card request
 */
public class FluxRemoverRequestEvent implements Event {

    private static final long serialVersionUID = 8427977L;
    private int id;
    private DiceColor diceColor;
    private int poolSize;

    /**
     * class constructor with the id of the player, the size of the pool and the color of the dice
     * @param id id of the player
     * @param diceColor color of the dice
     * @param poolSize size of the pool
     */
    public FluxRemoverRequestEvent(int id, DiceColor diceColor, int poolSize) {
        this.id = id;
        this.diceColor = diceColor;
        this.poolSize = poolSize;
    }

    /**
     * method that provides the caller the id of the player
     * @return id of the player
     */
    public int getId() {
        return id;
    }

    /**
     * method that provides the caller color of the dice
     * @return color of the dice
     */
    public DiceColor getDiceColor() {
        return diceColor;
    }

    /**
     * method that provides the caller size of the pool
     * @return pool of the size
     */
    public int getPoolSize() {
        return poolSize;
    }
}
