package it.polimi.se2018.server.model.Events.NOTUSED;

import it.polimi.se2018.server.model.Components.DraftPool;
import it.polimi.se2018.server.model.Components.RoundTracker;
import it.polimi.se2018.server.model.Events.Event;

public class MVRoundEvent implements Event {

    private RoundTracker roundTracker;
    private DraftPool draftPool;

    public MVRoundEvent(RoundTracker roundTracker, DraftPool draftPool){
        this.roundTracker = roundTracker;
        this.draftPool = draftPool;
    }

    public RoundTracker getRoundTracker(){
        return roundTracker;
    }

    public DraftPool getDraftPool(){
        return draftPool;
    }


}
