package it.polimi.se2018.events.ServerClient.ModelView;

import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.events.Event;

public class PlayerPatternUpdateEvent implements Event {

    private static final long serialVersionUID = 483589L;

    private int iD;
    private PatternCard card;

    public PlayerPatternUpdateEvent(int iD, PatternCard card) {
        this.iD = iD;
        this.card = card;
    }

    public int getID() {
        return iD;
    }

    public PatternCard getCard() {
        return card;
    }
}
