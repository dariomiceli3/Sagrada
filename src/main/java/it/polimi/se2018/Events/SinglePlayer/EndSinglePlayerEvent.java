package it.polimi.se2018.events.SinglePlayer;

import it.polimi.se2018.events.Event;

public class EndSinglePlayerEvent implements Event {

    private static final long serialVersionUID  = 34284934L;

    private boolean winner;
    private int playerPoints;
    private int gameThreshold;

    public EndSinglePlayerEvent(boolean winner, int playerPoints, int gameThreshold){
        this.gameThreshold = gameThreshold;
        this.playerPoints = playerPoints;
        this.winner = winner;
    }

    public int getGameThreshold() {
        return gameThreshold;
    }

    public int getPlayerPoints() {
        return playerPoints;
    }

    public boolean isWinner() {
        return winner;
    }
}

