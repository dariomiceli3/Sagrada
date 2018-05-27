package it.polimi.se2018.server.model.Events;

import it.polimi.se2018.server.model.Cards.PatternCard;

public class MVChoosePattern implements Event {

    private PatternCard pattern;

    public MVChoosePattern(PatternCard pattern) {

        this.pattern = pattern;
    }

    public PatternCard getPattern() {
        return pattern;
    }
}
