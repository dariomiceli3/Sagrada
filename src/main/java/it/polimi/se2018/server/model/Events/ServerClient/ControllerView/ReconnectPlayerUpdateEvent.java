package it.polimi.se2018.server.model.Events.ServerClient.ControllerView;

import it.polimi.se2018.server.model.Events.Event;

public class ReconnectPlayerUpdateEvent implements Event {

    private static final long serialVersionUID = 48944454535L;

    private int playerID;

    public ReconnectPlayerUpdateEvent(int playerID){

        this.playerID = playerID;
    }

    public int getPlayerID() {
        return playerID;
    }
}
