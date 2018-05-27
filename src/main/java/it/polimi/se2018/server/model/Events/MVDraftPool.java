package it.polimi.se2018.server.model.Events;

import it.polimi.se2018.server.model.Components.DraftPool;

public class MVDraftPool implements Event {

    private DraftPool draftPool;

    public MVDraftPool(DraftPool draftPool){
        this.draftPool = draftPool;
    }

    public DraftPool getDraftPool() {
        return draftPool;
    }
}
