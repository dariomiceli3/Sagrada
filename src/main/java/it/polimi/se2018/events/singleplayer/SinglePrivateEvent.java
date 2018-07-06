package it.polimi.se2018.events.singleplayer;

import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.events.Event;

import java.util.List;
/**
 * Class SinglePrivateEvent: single player event that deliveries the list of private cards
 */
public class SinglePrivateEvent implements Event {

    private static final long serialVersionUID = 384934L;
    private List<PrivateObjectiveCard> privateList;

    /**
     * class constructor with the list of private cards
     * @param privateList list of private cards
     */
    public SinglePrivateEvent(List<PrivateObjectiveCard> privateList) {
        this.privateList = privateList;
    }

    /**
     * method that provides the caller list of private cards
     * @return list of private cards
     */
    public List<PrivateObjectiveCard> getPrivateList() {
        return privateList;
    }


}
