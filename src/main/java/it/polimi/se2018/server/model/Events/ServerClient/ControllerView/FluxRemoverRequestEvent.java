package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Components.DiceColor;
import it.polimi.se2018.server.model.Events.Event;

public class FluxRemoverRequestEvent implements Event {

    private static final long serialVersionUID = 8427977L;
    private int id;
    private DiceColor diceColor;

    public FluxRemoverRequestEvent(int id, DiceColor diceColor) {
        this.id = id;
        this.diceColor = diceColor;
    }

    public int getId() {
        return id;
    }

    public DiceColor getDiceColor() {
        return diceColor;
    }
}
