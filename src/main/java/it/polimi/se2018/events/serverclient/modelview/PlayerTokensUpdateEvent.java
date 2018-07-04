package it.polimi.se2018.events.serverclient.modelview;

import it.polimi.se2018.events.Event;

public class PlayerTokensUpdateEvent implements Event {

    private static final long serialVersionUID = 53857L;
    private int id;
    private int tokensNumber;

    public PlayerTokensUpdateEvent(int id, int tokensNumber) {
        this.id = id;
        this.tokensNumber = tokensNumber;

    }

    public int getID() {
        return id;
    }

    public int getTokensNumber() {
        return tokensNumber;
    }


}
