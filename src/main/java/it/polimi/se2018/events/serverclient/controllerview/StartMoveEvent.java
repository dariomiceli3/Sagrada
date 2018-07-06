package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.events.Event;

/**
 * Class StartMoveEvent: controller view event that asks to the player if want to do a move
 */
public class StartMoveEvent implements Event {

    private static final long serialVersionUID = 34893L;
    private int id;
    private int poolSize;

    /**
     * class constructor with the id of the player and the size of the pool
     * @param id id of the player
     * @param poolSize size of the pool
     */
    public StartMoveEvent(int id, int poolSize) {
        this.id = id;
        this.poolSize = poolSize;
    }

    /**
     * method that provides the caller the id of the player
     * @return id of the player
     */
    public int getID() {
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
