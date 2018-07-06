package it.polimi.se2018.events.serverclient.modelview;

import it.polimi.se2018.server.model.Components.DraftPool;
import it.polimi.se2018.server.model.Components.RoundTracker;
import it.polimi.se2018.events.Event;


    /**
    * Class UpdateBoardEvent: model view event that updates the board
    */

public class UpdateBoardEvent implements Event {

    private static final long serialVersionUID = 4903940L;
    private RoundTracker roundTracker;
    private DraftPool draftPool;

    /**
     * class constructor with round tracker and the draft pool
     * @param roundTracker round tracker of the game
     * @param draftPool draft pool of the game
     */
    public UpdateBoardEvent(RoundTracker roundTracker, DraftPool draftPool) {
        this.draftPool = draftPool;
        this.roundTracker = roundTracker;
    }

    /**
     * method that provides the caller the round tracker
     * @return the round tracker
     */
    public RoundTracker getRoundTracker() {
        return roundTracker;
    }

    /**
     * method that provides the caller the draft pool
     * @return the draft pool
     */
    public DraftPool getDraftPool() {
        return draftPool;
    }
}
