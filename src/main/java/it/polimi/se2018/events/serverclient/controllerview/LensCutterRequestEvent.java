package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.events.Event;

import java.util.List;


/**
 * Class LensCutterRequestEvent: controller view event for Lens Cutter tool card request
 */
public class LensCutterRequestEvent implements Event {

    private static final long serialVersionUID = 4043904L;
    private int id;
    private int poolSize;
    private List<Integer> roundSizes;

    /**
     * class constructor with the id of the player and the size of the pool and a list of integers
     * that represents the size of the corresponding round
     * @param id id of the player
     * @param poolSize size of the pool
     * @param roundSizes list of integers that represents the size of the corresponding round
     */
    public LensCutterRequestEvent(int id, int poolSize, List<Integer> roundSizes)  {
        this.id = id;
        this.poolSize = poolSize;
        this.roundSizes = roundSizes;
    }

    /**
     * method that provides the caller id of the player
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

    /**
     * method that provides the caller the size of the each round
     * @return list of integer
     */
    public List<Integer> getRoundSizes() {
        return roundSizes;
    }
}
