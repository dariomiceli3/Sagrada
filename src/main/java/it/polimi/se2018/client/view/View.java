package it.polimi.se2018.client.view;

import it.polimi.se2018.server.model.Events.Event;

public abstract class View implements Runnable {

    protected  String playerName;
    protected boolean isGameStarted;


    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String username) {
        this.playerName = username;
    }

    public boolean isGameStarted() {
        return isGameStarted;
    }

    public void setGameStarted(boolean isGameStarted) {
        this.isGameStarted = isGameStarted;
    }

    public abstract void readEvent(Event event);

    public abstract void setConnection(); //aggiungere attributo connessione

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



}
