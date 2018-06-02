package it.polimi.se2018.server.model.Events.ServerClient.ModelView;

import it.polimi.se2018.server.model.Events.Event;

public class PlayerTokensUpdateEvent implements Event {

    private final static long serialVersionUID = 53857L;
    private int ID;
    private int tokensNumber;

    public PlayerTokensUpdateEvent(int ID, int tokensNumber) {
        this.ID = ID;
        this.tokensNumber = tokensNumber;

    }

    public int getID() {
        return ID;
    }

    public int getTokensNumber() {
        return tokensNumber;
    }


}
