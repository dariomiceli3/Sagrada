package it.polimi.se2018.events.serverclient.modelview;

import it.polimi.se2018.server.model.Components.DraftPool;
import it.polimi.se2018.events.Event;

/**
 * Class PlayerDraftPoolEvent: model view event that updates the draft pool
 */
public class PlayerDraftPoolUpdateEvent implements Event {

    private static final long serialVersionUID = 347834873L;
    private DraftPool draftPool;

    /**
     * class constructor with the draft pool
     * @param draftPool the new draft pool
     */
    public PlayerDraftPoolUpdateEvent(DraftPool draftPool) {
        this.draftPool = draftPool;
    }

    /**
     * method that provides the caller the draft pool
     * @return the draft pool
     */
    public DraftPool getDraftPool() {
        return draftPool;
    }
}
