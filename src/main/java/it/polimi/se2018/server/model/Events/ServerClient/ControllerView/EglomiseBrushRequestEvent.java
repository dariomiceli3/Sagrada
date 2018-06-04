package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Events.Event;

public class EglomiseBrushRequestEvent implements Event {

    private static final long serialVersionUID = 389232L;
    private int id;

    public EglomiseBrushRequestEvent(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


}
