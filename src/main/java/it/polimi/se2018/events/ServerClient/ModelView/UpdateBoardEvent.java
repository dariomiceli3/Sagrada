package it.polimi.se2018.events.ServerClient.ModelView;

import it.polimi.se2018.server.model.Components.DraftPool;
import it.polimi.se2018.server.model.Components.RoundTracker;
import it.polimi.se2018.events.Event;

public class UpdateBoardEvent implements Event {

    private static final long serialVersionUID = 4903940L;
    private RoundTracker roundTracker;
    private DraftPool draftPool;

    public UpdateBoardEvent(RoundTracker roundTracker, DraftPool draftPool) {
        this.draftPool = draftPool;
        this.roundTracker = roundTracker;
    }

    public RoundTracker getRoundTracker() {
        return roundTracker;
    }

    public DraftPool getDraftPool() {
        return draftPool;
    }
}
