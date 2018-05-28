package it.polimi.se2018.client.view;

import it.polimi.se2018.client.ClientInterface;
import it.polimi.se2018.server.model.Events.Event;

public abstract class View implements Runnable {

    protected  String playerName;
    protected boolean isStarted;
    protected int playerID;

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public abstract String getPlayerName();

    public abstract void setPlayerName(String username);

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean isStarted) {
        this.isStarted = isStarted;
    }

    public abstract void toStringEvent(Event event);

    public abstract void setConnection(ClientInterface client);

    public abstract ClientInterface getConnection();

    /*public abstract void showGameStart(); //aggiungere attributo

    public abstract void showGameEnd(); //aggiungere attributo

    public abstract void showPrivateCard(); // aggiungere attributo

    public abstract void showPatternChoose(); //aggiungere attributo

    public abstract void showPattern(); //aggiungere attributo

    public abstract void showToolCards(); //aggiungere attributo

    public abstract void showPublicCard(); //aggiungere attributo

    public abstract void showRoundTracker();

    public abstract void showDraftPool();

    public abstract void showOthersPlayer();
*/


}
