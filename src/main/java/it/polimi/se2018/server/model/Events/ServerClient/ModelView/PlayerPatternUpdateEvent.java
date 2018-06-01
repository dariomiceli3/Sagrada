package it.polimi.se2018.server.model.Events.ServerClient.ModelView;

import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Events.Event;

public class PlayerPatternUpdateEvent implements Event {

    private final static long serialVersionUID = 483589L;

    private int ID;
    private PatternCard card;

    public PlayerPatternUpdateEvent(int ID, PatternCard card) {
        this.ID = ID;
        this.card = card;
    }

    public int getID() {
        return ID;
    }

    public PatternCard getCard() {
        return card;
    }
}
