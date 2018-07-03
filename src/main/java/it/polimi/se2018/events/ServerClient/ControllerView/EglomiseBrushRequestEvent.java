package it.polimi.se2018.events.ServerClient.ControllerView;

import it.polimi.se2018.events.Event;

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
