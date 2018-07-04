package it.polimi.se2018.events.serverclient.modelview;

import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.events.Event;

public class PlayerPatternUpdateEvent implements Event {

    private static final long serialVersionUID = 483589L;

    private int id;
    private PatternCard card;

    public PlayerPatternUpdateEvent(int id, PatternCard card) {
        this.id = id;
        this.card = card;
    }

    public int getID() {
        return id;
    }

    public PatternCard getCard() {
        return card;
    }
}
