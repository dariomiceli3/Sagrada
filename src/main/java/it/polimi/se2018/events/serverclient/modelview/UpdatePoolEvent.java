package it.polimi.se2018.events.serverclient.modelview;

import it.polimi.se2018.server.model.Components.DraftPool;
import it.polimi.se2018.events.Event;

/**
 * Class UpdatePoolEvent: model view event that updates the pool
 */

public class UpdatePoolEvent implements Event {

    private static final long serialVersionUID = 3249239L;
    private DraftPool draftPool;

    /**
     * class constructor with the draft pool
     * @param draftPool draft pool of the game
     */
    public UpdatePoolEvent(DraftPool draftPool) {
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
