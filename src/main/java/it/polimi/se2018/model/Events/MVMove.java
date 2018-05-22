package it.polimi.se2018.model.Events;

import it.polimi.se2018.model.Cards.PatternCard;
import it.polimi.se2018.model.Components.DraftPool;

public class MVMove {

    private DraftPool draftPool;
    private PatternCard patternCard;

    public MVMove(DraftPool draftPool, PatternCard patternCard){
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
