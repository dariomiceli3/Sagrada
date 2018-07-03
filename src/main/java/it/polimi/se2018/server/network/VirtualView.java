package it.polimi.se2018.server.network;

import it.polimi.se2018.server.model.Components.Model;
import it.polimi.se2018.events.Event;

import java.util.Observable;
import java.util.Observer;

public abstract class VirtualView extends Observable implements Observer {

    protected String name;
    protected Model model;
    protected int playerID;

    public VirtualView(int playerID) {
       this.playerID = playerID;
    }

    public String getName() {
        return name;
    }

    public Model getModel() {
        return model;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    // manda eventi da virtual view al client
    public abstract void sendEvent(Event event);













}
