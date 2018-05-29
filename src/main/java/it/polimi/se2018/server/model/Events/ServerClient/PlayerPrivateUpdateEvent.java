package it.polimi.se2018.server.model.Events.ServerClient;

import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Events.Event;

public class PlayerPrivateUpdateEvent implements Event {
    private static final long serialVersionUID = 58458L;

    private final PrivateObjectiveCard privateCard;

    public PlayerPrivateUpdateEvent(PrivateObjectiveCard privateCard) {
        this.privateCard = privateCard;
    }

    public PrivateObjectiveCard getCard(){
        return privateCard;
    }
}
