package it.polimi.se2018.server.model.Events;

public class InvalidMoveEvent implements Event {

    private static final long serialVersionUID = 329239320L;
    private String errorMsg;
    int id;

    public InvalidMoveEvent(String errorMsg,int id) {
        this.errorMsg = errorMsg;
        this.id = id;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public int getId() {
        return id;
    }
}
