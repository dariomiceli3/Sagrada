package it.polimi.se2018.events.ServerClient.ModelView;

import it.polimi.se2018.events.Event;

public class PlayerTokensUpdateEvent implements Event {

    private static final long serialVersionUID = 53857L;
    private int iD;
    private int tokensNumber;

    public PlayerTokensUpdateEvent(int iD, int tokensNumber) {
        this.iD = iD;
        this.tokensNumber = tokensNumber;

    }

    public int getID() {
        return iD;
    }

    public int getTokensNumber() {
        return tokensNumber;
    }


}
