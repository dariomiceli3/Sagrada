package it.polimi.se2018.client.view;

import it.polimi.se2018.client.ClientInterface;
import it.polimi.se2018.server.model.Events.Event;

public abstract class View implements Runnable {

    //qui metodi generici comportamentabili, ovveride nelle varie view e chiamati da fuori

    protected String playerName;
    protected boolean isStarted;
    protected int playerID;
    protected ClientInterface connection;

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setNameView(String nameView){
        this.playerName = nameView;
    }

    /*public void setNameView(String name, int ID) {
        this.playerName = name;

    }*/

    public abstract void setPlayerName(String username);

    public abstract void showNameView(String name);

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean isStarted) {
        this.isStarted = isStarted;
    }

    public  void setConnection(ClientInterface client) {
        this.connection = client;
    }

    public  ClientInterface getConnection() {
        return connection;
    }

    /*public abstract void toStringEvent(Event event);

    public abstract void showGameStart(); //aggiungere attributo

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
