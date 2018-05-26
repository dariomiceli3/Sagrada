package it.polimi.se2018.server.model.Events;

import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Components.DraftPool;

public class MVMoveEvent implements Event {

    private DraftPool draftPool;
    private PatternCard patternCard;

    public MVMoveEvent(DraftPool draftPool, PatternCard patternCard){
        this.draftPool = draftPool;
        this.patternCard = patternCard;
    }

    public DraftPool getDraftPool() {
        return draftPool;
    }

    public PatternCard getPatternCard() {
        return patternCard;
    }
}
