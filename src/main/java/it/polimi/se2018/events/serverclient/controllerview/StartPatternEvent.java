package it.polimi.se2018.events.serverclient.controllerview;

import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.events.Event;

import java.util.List;

public class StartPatternEvent implements Event {

    private static final long serialVersionUID = 58798L;

    private final int id;
    private List<PatternCard> patternList;

    public StartPatternEvent(int id, List<PatternCard> patternList) {

        this.id = id;
        this.patternList = patternList;
    }

    public int getID() {
        return id;
    }

    public List<PatternCard> getPatternListEvent() {
        return patternList;
    }
}
