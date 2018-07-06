package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.events.Event;

/**
 * Class EglomiseBrushRequestEvent: controller view event for Eglomise Brush tool card request
 */
public class EglomiseBrushRequestEvent implements Event {

    private static final long serialVersionUID = 389232L;
    private int id;

    /**
     * class constructor with the id of the player
     * @param id id of the player
     */
    public EglomiseBrushRequestEvent(int id) {
        this.id = id;
    }

    /**
     * method that provides the caller id of the player
     * @return id of the player
     */
    public int getId() {
        return id;
    }


}
