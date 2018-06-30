package it.polimi.se2018.server.model.Events.ServerClient.ModelView;

import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Events.Event;

public class PlayerPrivateUpdateEvent implements Event {
    private static final long serialVersionUID = 534534L;

    private final PrivateObjectiveCard privateCard;
    private final int iD;

    public PlayerPrivateUpdateEvent(int iD, PrivateObjectiveCard privateCard) {
        this.privateCard = privateCard;
        this.iD = iD;
    }

    public PrivateObjectiveCard getCard(){
        return privateCard;
    }

    public int getID(){
        return iD;
    }
}
