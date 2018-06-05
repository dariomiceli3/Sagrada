package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Events.Event;

public class LensCutterRequestEvent implements Event {

    private static final long serialVersionUID = 4043904L;
    private int id;

    public LensCutterRequestEvent(int id)  {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
