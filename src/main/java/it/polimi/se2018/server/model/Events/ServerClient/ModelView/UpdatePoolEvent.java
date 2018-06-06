package it.polimi.se2018.server.model.Events.ServerClient.ModelView;

import it.polimi.se2018.server.model.Components.DraftPool;
import it.polimi.se2018.server.model.Events.Event;

public class UpdatePoolEvent implements Event {

    private static final long serialVersionUID = 3249239L;
    private DraftPool draftPool;

    public UpdatePoolEvent(DraftPool draftPool) {
        this.draftPool = draftPool;
    }

    public DraftPool getDraftPool() {
        return draftPool;
    }
}
