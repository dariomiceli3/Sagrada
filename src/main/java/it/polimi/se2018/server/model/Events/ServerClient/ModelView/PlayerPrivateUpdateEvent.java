package it.polimi.se2018.server.model.Events.ServerClient.ModelView;

import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Events.Event;

public class PlayerPrivateUpdateEvent implements Event {
    private static final long serialVersionUID = 534534L;

    private final PrivateObjectiveCard privateCard;
    private final int ID;

    public PlayerPrivateUpdateEvent(int ID, PrivateObjectiveCard privateCard) {
        this.privateCard = privateCard;
        this.ID = ID;
    }

    public PrivateObjectiveCard getCard(){
        return privateCard;
    }

    public int getID(){
        return ID;
    }
}
