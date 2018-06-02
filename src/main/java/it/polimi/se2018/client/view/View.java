package it.polimi.se2018.client.view;

import it.polimi.se2018.client.ClientInterface;
import it.polimi.se2018.server.model.Cards.PatternCard;
import it.polimi.se2018.server.model.Cards.PrivateObjectiveCard;
import it.polimi.se2018.server.model.Cards.PublicObjectiveCard.PublicObjectiveCard;
import it.polimi.se2018.server.model.Events.Event;
import it.polimi.se2018.server.model.Cards.PatternCard;

import java.awt.*;
import java.util.List;
import java.util.Scanner;

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


    public abstract void setPlayerName(String username);

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

    public abstract void showNameChoose();

    public abstract void showPrivateCard(PrivateObjectiveCard privateObjectiveCard);

    public abstract void showPublicCard(List<PublicObjectiveCard> publicList);

    public abstract void showPatternList(List<PatternCard> patternCards);

    public abstract void showPatternChoose(int choose, List<PatternCard> patternCards);

    public abstract void showPattern(PatternCard patternCard);

    public abstract void showTokens(int tokensNumber);

    //public abstract void toStringEvent(Event event);

    //public abstract void showGameStart(); //aggiungere attributo

    //public abstract void showGameEnd(); //aggiungere attributo




    //public abstract void showToolCards(); //aggiungere attributo


    //public abstract void showRoundTracker();

    //public abstract void showDraftPool();

    //public abstract void showOthersPlayer();



}
