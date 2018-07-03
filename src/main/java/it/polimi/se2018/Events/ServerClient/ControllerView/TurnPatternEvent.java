package it.polimi.se2018.events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.events.Event;

public class TurnPatternEvent implements Event {

    private static final long serialVersionUID = 93295894312L;

    private int iD;
    private PatternCard patternCard;

    public TurnPatternEvent(int iD, PatternCard patternCard){
        this.iD = iD;
        this.patternCard = patternCard;
    }

    public PatternCard getPatternCard() {
        return patternCard;
    }

    public int getID() {
        return iD;
    }
}
