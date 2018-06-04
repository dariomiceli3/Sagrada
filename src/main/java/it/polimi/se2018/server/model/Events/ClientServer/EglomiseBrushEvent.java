package it.polimi.se2018.server.model.Events.ClientServer;

import it.polimi.se2018.server.model.Events.Event;
import it.polimi.se2018.server.model.Events.ServerClient.ControllerView.EglomiseBrushRequestEvent;

public class EglomiseBrushEvent implements Event {

    private static final long serialVersionUID = 329039L;
    private int indexStart;
    private int indexEnd;

    public EglomiseBrushEvent(int indexStart, int indexEnd) {
        this.indexStart = indexStart;
        this.indexEnd = indexEnd;
    }

    public int getIndexEnd() {
        return indexEnd;
    }

    public int getIndexStart() {
        return indexStart;
    }
}
