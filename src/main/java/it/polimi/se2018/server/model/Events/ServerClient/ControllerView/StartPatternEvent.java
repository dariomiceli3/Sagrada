package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Events.Event;

import java.util.ArrayList;
import java.util.List;

public class StartPatternEvent implements Event {

    private static final long serialVersionUID = 58798L;

    private final int ID;
    private List<PatternCard> patternList;

    public StartPatternEvent(int id, List<PatternCard> patternList) {

        this.ID = id;
        this.patternList = patternList;
    }

    public int getID() {
        return ID;
    }

    public List<PatternCard> getPatternListEvent() {
        return patternList;
    }
}
