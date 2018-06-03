package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Events.Event;

public class TurnPatternEvent implements Event {

    private static final long serialVersionUID = 93295894312L;

    private int ID;
    private PatternCard patternCard;

    public TurnPatternEvent(int ID, PatternCard patternCard){
        this.ID = ID;
        this.patternCard = patternCard;
    }

    public PatternCard getPatternCard() {
        return patternCard;
    }

    public int getID() {
        return ID;
    }
}
