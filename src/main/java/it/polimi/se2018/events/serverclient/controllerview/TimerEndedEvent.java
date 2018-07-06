package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.events.Event;

/**
 * Class TimeEndedEvent: controller view event to notifies the player that his time to play is ended
 */
public class TimerEndedEvent implements Event {

    private static final long serialVersionUID = 347384L;
    private int id;

    /**
     * class constructor with the id of the player
     * @param id id of the player
          */
    public TimerEndedEvent(int id) {
        this.id = id;
    }

    /**
     * method that provides the caller the id of the player
     * @return id of the player
     */
    public int getId() {
        return id;
    }

}
