package it.polimi.se2018.server.model.Events.ServerClient.ModelView;

import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.PublicObjectiveCard;
import it.polimi.se2018.server.model.Events.Event;

import java.util.List;

public class PublicDrawEvent implements Event {

    private static final long serialVersionUID = 65475L;

    private final List<PublicObjectiveCard> publicList;

    public PublicDrawEvent(List<PublicObjectiveCard> publicList) {
        this.publicList = publicList;
    }

    public List<PublicObjectiveCard> getCard(){
        return publicList;
    }

}
