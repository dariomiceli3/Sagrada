package it.polimi.se2018.model.Events;

import it.polimi.se2018.model.Components.DraftPool;
import it.polimi.se2018.model.Components.RoundTracker;

public class MVRound {

    private RoundTracker roundTracker;
    private DraftPool draftPool;

    public MVRound(RoundTracker roundTracker, DraftPool draftPool){
        this.roundTracker = roundTracker;
        this.draftPool = draftPool;
    }

    public RoundTracker getRoundTracker(){
        return roundTracker;
    }

    public DraftPool draftPool(){
        return draftPool;
    }


}
