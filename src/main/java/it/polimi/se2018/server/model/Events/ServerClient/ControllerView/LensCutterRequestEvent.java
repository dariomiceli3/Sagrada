package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Events.Event;

import java.util.List;

public class LensCutterRequestEvent implements Event {

    private static final long serialVersionUID = 4043904L;
    private int id;
    private int poolSize;
    private List<Integer> roundSizes;

    public LensCutterRequestEvent(int id, int poolSize, List<Integer> roundSizes)  {
        this.id = id;
        this.poolSize = poolSize;
        this.roundSizes = roundSizes;
    }

    public int getId() {
        return id;
    }

    public int getPoolSize() {
        return poolSize;
    }

    public List<Integer> getRoundSizes() {
        return roundSizes;
    }
}
