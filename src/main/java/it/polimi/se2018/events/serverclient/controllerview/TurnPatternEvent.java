package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.events.Event;

public class TurnPatternEvent implements Event {

    private static final long serialVersionUID = 93295894312L;

    private int id;
    private PatternCard patternCard;

    public TurnPatternEvent(int id, PatternCard patternCard){
        this.id = id;
        this.patternCard = patternCard;
    }

    public PatternCard getPatternCard() {
        return patternCard;
    }

    public int getID() {
        return id;
    }
}
