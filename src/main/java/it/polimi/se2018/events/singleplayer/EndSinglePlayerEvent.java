package it.polimi.se2018.events.singleplayer;

import it.polimi.se2018.events.Event;

/**
 * Class EndSinglePlayerEvent: single player event that handle the end of the game in single payer mode
 */
public class EndSinglePlayerEvent implements Event {

    private static final long serialVersionUID  = 34284934L;

    private boolean winner;
    private int playerPoints;
    private int gameThreshold;

    /**
     * class constructor with the boolean that indicates if the player won or not, the final
     * points of the player and the threshold
     * @param winner boolean
     * @param playerPoints total points of the player
     * @param gameThreshold threshold to overcome for winning
     */
    public EndSinglePlayerEvent(boolean winner, int playerPoints, int gameThreshold){
        this.gameThreshold = gameThreshold;
        this.playerPoints = playerPoints;
        this.winner = winner;
    }

    /**
     * method that provides the caller the threshold
     * @return int threshold
     */
    public int getGameThreshold() {
        return gameThreshold;
    }

    /**
     * method that provides the caller total points of player
     * @return total points of player
     */
    public int getPlayerPoints() {
        return playerPoints;
    }

    /**
     * method that provides the caller if the player won or not
     * @return boolean winner
     */
    public boolean isWinner() {
        return winner;
    }
}

