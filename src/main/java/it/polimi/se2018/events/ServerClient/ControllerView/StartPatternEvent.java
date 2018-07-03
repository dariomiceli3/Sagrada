package it.polimi.se2018.events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.events.Event;

import java.util.List;

public class StartPatternEvent implements Event {

    private static final long serialVersionUID = 58798L;

    private final int iD;
    private List<PatternCard> patternList;

    public StartPatternEvent(int id, List<PatternCard> patternList) {

        this.iD = id;
        this.patternList = patternList;
    }

    public int getID() {
        return iD;
    }

    public List<PatternCard> getPatternListEvent() {
        return patternList;
    }
}
