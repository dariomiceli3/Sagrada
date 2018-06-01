package it.polimi.se2018.server.model.Events.ClientServer;

import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Events.Event;

public class PlayerPatternEvent implements Event {

    private static final long serialVersionUID = 743857834L;
    private int ID;
    private PatternCard card;

    public PlayerPatternEvent(int ID, PatternCard card) {
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
