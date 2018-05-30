package it.polimi.se2018.server.model.Events.NOTUSED;

import it.polimi.se2018.server.model.Components.Player;
import it.polimi.se2018.server.model.Events.Event;

import java.util.List;

public class MVEndGame implements Event {

    private List<Player> playerList;

    public MVEndGame(List<Player> playerList){
        this.playerList = playerList;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }
}
