package it.polimi.se2018.server.model.Events.ServerClient.ModelView;

import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Events.Event;

public class PatternUpdateEvent implements Event {

    private static final long serialVersionUID = 834938L;

    private int id;
    private PatternCard patternCard;
    private String name;

    public PatternUpdateEvent(int id, PatternCard patternCard, String name) {
        this.id = id;
        this.patternCard = patternCard;
        this.name = name;
    }

    public PatternCard getPatternCard() {
        return patternCard;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }
}
