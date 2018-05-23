package it.polimi.se2018.model.Events;

import it.polimi.se2018.model.Components.DraftPool;
import it.polimi.se2018.model.Components.RoundTracker;

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
