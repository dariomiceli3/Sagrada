package it.polimi.se2018.events.serverclient.modelview;

import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.events.Event;

public class PlayerPrivateUpdateEvent implements Event {
    private static final long serialVersionUID = 534534L;

    private final PrivateObjectiveCard privateCard;
    private final int id;

    public PlayerPrivateUpdateEvent(int id, PrivateObjectiveCard privateCard) {
        this.privateCard = privateCard;
        this.id = id;
    }

    public PrivateObjectiveCard getCard(){
        return privateCard;
    }

    public int getID(){
        return id;
    }
}
