package it.polimi.se2018.server.model.Events;

import it.polimi.se2018.server.model.Components.Player;

public class MVModifyPlayerEvents implements Event {

    private Player player;

    public MVModifyPlayerEvents(Player player){
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
