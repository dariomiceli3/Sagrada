package it.polimi.se2018.events.ServerClient.ModelView;

import it.polimi.se2018.server.model.Components.Player;
import it.polimi.se2018.events.Event;

import java.util.List;

public class PlayerPointsUpdateEvent implements Event {

    private static final long serialVersionUID = 483958L;
    private List<Player> playerList;
    private boolean finish;

    public PlayerPointsUpdateEvent(List<Player> playerList, boolean finish) {
        this.playerList = playerList;
        this.finish = finish;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public boolean isFinish() {
        return finish;
    }
}
