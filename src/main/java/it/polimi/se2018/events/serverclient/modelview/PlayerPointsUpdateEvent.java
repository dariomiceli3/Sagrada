package it.polimi.se2018.events.serverclient.modelview;

import it.polimi.se2018.server.model.Components.Player;
import it.polimi.se2018.events.Event;

import java.util.List;

    /**
    * Class PlayerPointsUpdateEvent: model view event that update the player's points
    */

public class PlayerPointsUpdateEvent implements Event {

    private static final long serialVersionUID = 483958L;
    private List<Player> playerList;
    private boolean finish;

    /**
     * class constructor with the list of players and the boolean finish
     * @param playerList list of all the players
     * @param finish  boolean if the game is finished or not
     */
    public PlayerPointsUpdateEvent(List<Player> playerList, boolean finish) {
        this.playerList = playerList;
        this.finish = finish;
    }

    /**
     * method that provides the caller the list of all the players
     * @return list of the players
     */
    public List<Player> getPlayerList() {
        return playerList;
    }

    /**
     * method that provides the caller if the game is finished or not
     * @return boolean isFinish
     */
    public boolean isFinish() {
        return finish;
    }
}
