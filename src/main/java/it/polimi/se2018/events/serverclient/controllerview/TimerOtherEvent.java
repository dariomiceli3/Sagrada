package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.events.Event;

/**
 * Class TimeOtherEvent: controller view event to notifies the other players that the time of the
 * current player is ended
 */
public class TimerOtherEvent implements Event {

    private static final long serialVersionUID = 943094033904L;
    private String name;

    /**
     * class constructor with the name of the player whose time is ended
     * @param name name of the player
     */
    public TimerOtherEvent(String name) {
        this.name = name;
    }

    /**
     * method that provides the caller the name of the player whose timer is ended
     * @return name of the player
     */
    public String getName() {
        return name;
    }
}
