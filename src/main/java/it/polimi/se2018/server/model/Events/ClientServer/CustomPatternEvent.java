package it.polimi.se2018.server.model.Events.ClientServer;


import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Events.Event;

import java.util.regex.Pattern;

public class CustomPatternEvent implements Event {

    private static final long serialVersionUID = 439043943L;

    private PatternCard patternCard;

    public CustomPatternEvent(PatternCard patternCard) {
        this.patternCard = patternCard;
    }

    public PatternCard getPatternCard() {
        return patternCard;
    }
}
