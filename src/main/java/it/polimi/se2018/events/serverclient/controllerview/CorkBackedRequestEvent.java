package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.events.Event;

/**
 * Class CorkBackedRequestEvent: controller view event for Backed Request tool card request
 */
public class CorkBackedRequestEvent implements Event {

    private static final long serialVersionUID = 4454678L;
    private  int id;
    private int poolSize;

    /**
     * class constructor with the id of the player and the size of the pool
     * @param id id of the player
     * @param poolSize int size of the pool
     */
    public CorkBackedRequestEvent(int id, int poolSize) {
        this.id = id;
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
     * method that provides the caller the size of the pool
     * @return size of the pool
     */
    public int getPoolSize() {
        return poolSize;
    }
}
