package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Events.Event;

public class CorkBackedRequestEvent implements Event {

    private static final long serialVersionUID = 4454678L;
    private  int id;

    public CorkBackedRequestEvent(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }


}
