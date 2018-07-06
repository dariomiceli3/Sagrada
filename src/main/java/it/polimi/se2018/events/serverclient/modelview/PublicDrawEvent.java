package it.polimi.se2018.events.serverclient.modelview;

import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.PublicObjectiveCard;
import it.polimi.se2018.events.Event;

import java.util.List;

/**
 * Class PublicDrawEvent: model view event that delivered the public cards
 */
public class PublicDrawEvent implements Event {

    private static final long serialVersionUID = 65475L;

    private final List<PublicObjectiveCard> publicList;

    /**
     * class constructor with list of public cards
     * @param publicList list of public cards
     */
    public PublicDrawEvent(List<PublicObjectiveCard> publicList) {
        this.publicList = publicList;
    }

    /**
     * method that provides the caller the list of the public cards
     * @return list of the public cards
     */
    public List<PublicObjectiveCard> getCard(){
        return publicList;
    }


}
