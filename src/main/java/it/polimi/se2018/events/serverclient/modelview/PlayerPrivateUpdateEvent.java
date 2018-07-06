package it.polimi.se2018.events.serverclient.modelview;

import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.events.Event;

/**
 * Class PlayerPrivateUpdateEvent: model view  event that updates the points of the private card
 */
public class PlayerPrivateUpdateEvent implements Event {
    private static final long serialVersionUID = 534534L;

    private final PrivateObjectiveCard privateCard;
    private final int id;

    /**
     * class constructor with the id and the private of the player
     * @param id id of the player
     * @param privateCard private card of the player
     */
    public PlayerPrivateUpdateEvent(int id, PrivateObjectiveCard privateCard) {
        this.privateCard = privateCard;
        this.id = id;
    }

    /**
     * method that provides the caller the private card of the player
     * @return private card of the player
     */
    public PrivateObjectiveCard getCard(){
        return privateCard;
    }

    /**
     * method that provides the caller the id of the player
     * @return id of the player
     */
    public int getID(){
        return id;
    }
}
