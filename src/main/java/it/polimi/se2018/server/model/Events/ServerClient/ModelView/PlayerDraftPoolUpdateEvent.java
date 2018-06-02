package it.polimi.se2018.server.model.Events.ServerClient.ModelView;

import it.polimi.se2018.server.model.Components.DraftPool;

public class PlayerDraftPoolUpdateEvent {

    private static final long serialVersionUID = 347834873L;
    private DraftPool draftPool;

    public PlayerDraftPoolUpdateEvent(DraftPool draftPool) {
        this.draftPool = draftPool;
    }

    public DraftPool getDraftPool() {
        return draftPool;
    }
}
