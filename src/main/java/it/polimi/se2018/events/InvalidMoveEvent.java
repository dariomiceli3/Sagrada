package it.polimi.se2018.events;

/**
 * Class InvalidMoveEvent: event that send to the player that the move is not correct
 * @see it.polimi.se2018.events.Event
 * @author fadda-miceli-mundo
 */
public class InvalidMoveEvent implements Event {

    private static final long serialVersionUID = 329239320L;
    private String errorMsg;
    private int id;

    /**
     * Class constructor with the msg of the error and the id of the player
     * @param errorMsg the msg of the error
     * @param id of the player
     */
    public InvalidMoveEvent(String errorMsg,int id) {
        this.errorMsg = errorMsg;
        this.id = id;
    }

    /**
     * method that provide the caller the message of the error
     * @return String of the message
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * method that provides the caller the id of the player
     * @return int of id player
     */
    public int getId() {
        return id;
    }
}
