package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.events.Event;

/**
 * Class FluxRemoverRequestEvent: controller view event for Flux Remover tool card request
 */
public class FluxBrushRequestEvent implements Event {

    private static final long serialVersionUID = 349043L;
    private int id;
    private int poolSize;

    /**
     * class constructor with the id of the player and the size of the pool
     * @param id id of the player
     * @param poolSize size of the pool
     */
    public FluxBrushRequestEvent(int id, int poolSize) {
        this.id = id;
        this.poolSize = poolSize;
    }

    /**
     * method that provides the caller the id of the player
     * @return id of th player
     */
    public int getId() {
        return id;
    }

    /**
     * method that provides the caller the size of the pool
     * @return size of the pool
     */
    public int getPoolSize() {
        return poolSize;
    }
}
