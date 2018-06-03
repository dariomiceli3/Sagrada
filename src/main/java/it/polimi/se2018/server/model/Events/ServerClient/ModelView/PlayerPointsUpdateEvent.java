package it.polimi.se2018.server.model.Events.ServerClient.ModelView;

import it.polimi.se2018.server.model.Components.Player;
import it.polimi.se2018.server.model.Events.Event;

import java.util.List;

public class PlayerPointsUpdateEvent implements Event {

    private static final long serialVersionUID = 483958L;
    private List<Player> playerList;

    public PlayerPointsUpdateEvent(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

}
