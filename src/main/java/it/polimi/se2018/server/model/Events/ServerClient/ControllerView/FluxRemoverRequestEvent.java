package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Components.DiceColor;
import it.polimi.se2018.server.model.Events.Event;

public class FluxRemoverRequestEvent implements Event {

    private static final long serialVersionUID = 8427977L;
    private int id;
    private DiceColor diceColor;
    private int poolSize;

    public FluxRemoverRequestEvent(int id, DiceColor diceColor, int poolSize) {
        this.id = id;
        this.diceColor = diceColor;
        this.poolSize = poolSize;
    }

    public int getId() {
        return id;
    }

    public DiceColor getDiceColor() {
        return diceColor;
    }

    public int getPoolSize() {
        return poolSize;
    }
}
